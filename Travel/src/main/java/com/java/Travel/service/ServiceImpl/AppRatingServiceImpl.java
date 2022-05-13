package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.AppRatingDTO;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.service.AppRatingService;
import org.springframework.stereotype.Service;

@Service
public class AppRatingServiceImpl implements AppRatingService {


    /*@Autowired*/
    private AppRatingRepository appRatingRepository;

    @Override
    public boolean save(AppRatingDTO appRatingDTO) {

        return true;
    }

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
}
