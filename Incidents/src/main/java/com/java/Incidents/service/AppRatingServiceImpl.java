package com.java.Incidents.service;

import com.java.Incidents.controller.dto.AppRatingDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.User;
import com.java.Incidents.repository.AppRatingRepository;
import com.java.Incidents.repository.RoleRepository;
import com.java.Incidents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppRatingServiceImpl {

    @Autowired
    private AppRatingRepository appRatingRepository;

    /*@Transactional
    @Override
    public boolean save(AppRatingDTO appRatingDTO) {

        Long idExistUser = appRatingRepository.getIdUserByNameRate(userDTO.getEmail());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist", userDTO);
        }

        AppRating apprating = new AppRating();
        apprating.setValue(appRatingDTO.getValue());
        apprating.setFinalValue(appRatingDTO.getFinalValue());
        apprating.setIDClientA(appRatingDTO.getIdClientA());

        appRatingRepository.save(apprating);

        return true;
    }

    @Override
    public List<UserDTO> getAppRatingById(Long id) {

        List<AppRating> appRatingList = appRatingRepository.findAllByIdClientA(Long  );
        List<AppRatingDTO> appRatingDTOList = appRatingList.stream()
                .map(a -> new AppRatingDTO(
                        a.getId(),
                        a.getValue(),
                        a.getFinalValue(),
                        a.getIDClientA()
                ))
                .collect(Collectors.toList());

        return appRatingDTOList;

    }

    @Transactional
    @Override
    public void deleteAppRatingById(Long id) throws UserNotFoundException {
        Optional<AppRating> appRatingEntity = appRatingRepository.findById(id);

        if (appRatingEntity.isPresent()) {
            appRatingRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("AppRating with id=" + id + " not found");
        }
    }

    @Override
    public UserDTO findAppRatingById(Long id) {
        Optional<AppRating> appRatingEntity = appRatingRepository.findById(id);
        return appRatingEntity.isPresent() ? mapAppRatingDTO(appRatingEntity.get()) : null;
    }

    private AppRatingDTO mapAppRatingDTO(AppRating appRating) {
        AppRatingDTO appRatingDTO = new AppRatingDTO();
        appRatingDTO.setId(appRating.getId());
        appRatingDTO.setValue(appRating.getValue());
        appRatingDTO.setFinalValue(appRating.getFinalValue());
        appRatingDTO.setIDClientA(appRating.getIDClientA());
        return appRatingDTO;
    }

    @Transactional
    @Override
    public void update(UserDTO user) {

        Long idExistAppRating = appRatingRepository.getIdAppRatingByIDClientA(appRating.getIDClientA());

        if (idExistAppRating != null && !idExistAppRating.equals(appRating.getId())) {
            throw new EditAppRatingsParametersExistException("This_person_has_already_rated_the_app", appRating);
        }


        Optional<User> editAppRatingEntity = appRatingRepository.findById(appRating.getId());
        if (editAppRatingEntity.isPresent()) {

            editAppRatingEntity.get().setValue(appRating.getValue());
            editAppRatingEntity.get().setFinalValue(appRating.getFinalValue());
            editAppRatingEntity.get().setIDClientA(appRating.getIDClientA());

            appRatingRepository.save(editAppRatingEntity.get());
        } else {
            throw new UserNotFoundException("App rating with id=" + user.getId() + " not found");
        }

    }*/



}
