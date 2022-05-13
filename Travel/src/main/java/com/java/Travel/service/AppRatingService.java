package com.java.Travel.service;

import com.java.Travel.controller.dto.AppRatingDTO;
import org.springframework.transaction.annotation.Transactional;

public interface AppRatingService {


    void deleteUserById(Long id);

    AppRatingDTO findUserById(Long id);

    void update(AppRatingDTO appRating);

    @Transactional
    boolean save(AppRatingDTO appRatingDTO);
}
