package com.java.Incidents.service;


import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.model.User;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.exception.EditUsersParametersExistException;
import com.java.Travel.exception.UserNotFoundException;
import com.java.Travel.model.UserEntity;

import java.util.List;
import java.util.Optional;


import com.java.Travel.model.WalletEntity;
import com.java.Travel.repository.RoleEntityRepository;
import com.java.Travel.repository.UserEntityRepository;
import com.java.Travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final Double DEFAULT_SUM = 0D;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public boolean save(UserDTO userDTO, String role) {

        Long idExistUser = userRepository.getIdUserByEmail(userDTO.getEmail());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist", userDTO);
        }

        idExistUser = userRepository.getIdUserByLogin(userDTO.getLogin());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("This_login_is_exist", userDTO);
        }

        idExistUser = userRepository.getIdUserByPhoneNumber(userDTO.getPhoneNumber());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("This_phone_number_already_exist", userDTO);
        }

        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPatronymic(userDTO.getPatronymic());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole(roleRepository.findByRole(role));

        if (role.equals("ROLE_CLIENT")) {
            user.setWallet(new WalletEntity(DEFAULT_SUM));
        }
        userRepository.save(user);

        return true;
    }

    @Override
    public List<UserDTO> getUsersByRole(String role) {

        List<User> userList = userRepository.findAllByRoleEntity_Role(role);
        List<UserDTO> userDTOList = userList.stream()
                .map(a -> new UserDTO(
                        a.getId(),
                        a.getLogin(),
                        a.getPassword(),
                        a.getEmail(),
                        a.getFirstName(),
                        a.getLastName(),
                        a.getPatronymic(),
                        a.getPhoneNumber(),
                        a.getRole().getRole()
                ))
                .collect(Collectors.toList());

        return userDTOList;

    }

    @Transactional
    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        Optional<User> userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }
    }

    @Override
    public UserDTO findUserById(Long id) {
        Optional<User> userEntity = userRepository.findById(id);
        return userEntity.isPresent() ? mapUserDTO(userEntity.get()) : null;
    }

    private UserDTO mapUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole().getRole());
        return userDTO;
    }

    @Transactional
    @Override
    public void update(UserDTO user) {

        Long idExistUser = userRepository.getIdUserByEmail(user.getEmail());

        if (idExistUser != null && !idExistUser.equals(user.getId())) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist", user);
        }

        idExistUser = userRepository.getIdUserByLogin(user.getLogin());
        if (idExistUser != null && !idExistUser.equals(user.getId())) {
            throw new EditUsersParametersExistException("This_login_is_exist", user);
        }

        idExistUser = userRepository.getIdUserByPhoneNumber(user.getPhoneNumber());
        if (idExistUser != null && !idExistUser.equals(user.getId())) {
            throw new EditUsersParametersExistException("This_phone_number_already_exist", user);
        }

        Optional<User> editUserEntity = userRepository.findById(user.getId());
        if (editUserEntity.isPresent()) {

            editUserEntity.get().setLogin(user.getLogin());
            editUserEntity.get().setPassword(user.getPassword());
            editUserEntity.get().setEmail(user.getEmail());
            editUserEntity.get().setFirstName(user.getFirstName());
            editUserEntity.get().setLastName(user.getLastName());
            editUserEntity.get().setPatronymic(user.getPatronymic());
            editUserEntity.get().setPhoneNumber(user.getPhoneNumber());

            userRepository.save(editUserEntity.get());
        } else {
            throw new UserNotFoundException("User with id=" + user.getId() + " not found");
        }

    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }

}

