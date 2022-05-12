package com.java.Incidents.service;

import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.User;
import com.java.Incidents.repository.RoleRepository;
import com.java.Incidents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractServices {


}
