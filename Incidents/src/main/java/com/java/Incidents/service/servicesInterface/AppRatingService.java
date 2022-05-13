package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.AppRatingDTO;
import com.java.Incidents.controller.dto.UserDTO;

import java.util.List;

public interface AppRatingService {
    boolean save(AppRatingDTO appRatingDTO);

    void deleteUserById(Long id);

    AppRatingDTO findUserById(Long id);

    void update(AppRatingDTO appRating);
}
