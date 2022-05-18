package com.java.Travel.service;

import com.java.Travel.controller.dto.AppRatingDTO;
import com.java.Travel.model.AppRating;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppRatingService {

    List<AppRating> findAll();

    void deleteUserById(Long id);

    AppRatingDTO findUserById(Long id);

    void update(AppRatingDTO appRating);

    @Transactional
    boolean save(AppRating obj);


}
