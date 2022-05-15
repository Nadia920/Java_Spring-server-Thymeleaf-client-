package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.AppRatingDTO;
import com.java.Travel.model.AppRating;
import com.java.Travel.model.FixedDetachmentsEntity;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.service.AppRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRatingServiceImpl implements AppRatingService {


    @Autowired
    private AppRatingRepository appRatingRepository;


    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public AppRatingDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(AppRatingDTO appRating) {

    }

    @Override
    public boolean save(AppRating obj){
        AppRating a = appRatingRepository.save(obj);
        if (a == null){
            return false;}
        else return true;
    }
    
    public AppRatingServiceImpl(AppRatingRepository appRatingRepository) {
        this.appRatingRepository = appRatingRepository;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
