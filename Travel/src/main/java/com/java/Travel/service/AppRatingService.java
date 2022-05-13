package com.java.Travel.service;

import com.java.Travel.controller.dto.AppRatingDTO;

public interface AppRatingService {
    boolean save(AppRatingDTO appRatingDTO);

    void deleteUserById(Long id);

    AppRatingDTO findUserById(Long id);

    void update(AppRatingDTO appRating);
}
