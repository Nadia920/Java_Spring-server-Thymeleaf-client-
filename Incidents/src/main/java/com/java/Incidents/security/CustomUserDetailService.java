package com.java.Incidents.security;


import com.java.Incidents.model.User;
import com.java.Incidents.service.servicesInterface.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService extends User implements UserDetailsService{

    @Autowired
    private UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }
    public CustomUserDetailService() {

    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByLogin(login);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser
                .map(CustomUserDetail::new).get();
    }
}
