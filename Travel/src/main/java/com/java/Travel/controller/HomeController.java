package com.java.Travel.controller;


import com.java.Travel.controller.dto.ApiError;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.CountryService;
import com.java.Travel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
     @Autowired
    private UserService userService;
     @Autowired
    private CountryService countryService;

    public HomeController() {
    }

    public HomeController(UserService userService,
                          CountryService countryService) {
        this.userService = userService;
        this.countryService = countryService;
    }

    @GetMapping(value = "/home")
    public String getHomeView(Model model, @AuthenticationPrincipal CustomUserDetail currentUser) {
//        model.addAttribute("id", currentUser.getId());
        System.out.println("1");
        return "home/home";
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        /*model.addAttribute("countries", countryService.findAll(Sort.by("name").ascending()));*/
        System.out.println("2");
        return "index";
        /*return "waq";*/
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("3");
        return "login";
    }

    /*@GetMapping("/registration")
    public String registration() {
        return "registration";
    }*/

    @GetMapping("/registration")
    public String getSignUpView(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }


    @PostMapping(path = "/registration")
    public String registrationClient(@Valid @ModelAttribute("user") UserDTO client,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("user", client);
            model.addAttribute("apiError", apiError);
            return "registration";
        }

        userService.save(client, "ROLE_CLIENT");

        return "redirect:/";
    }


    @GetMapping("/403")
    public String error403() {
        return "statuscode/403";
    }


    @GetMapping("/MenuUser")
    public String MenuUser() {
        return "/home/MenuUser";
    }
    @GetMapping("/MenuAdmin")
    public String MenuAdmin() {
        return "/home/MenuAdmin";
    }
    @GetMapping("/MenuWorker")
    public String MenuWorker() {
        return "/home/MenuWorker";
    }



    @GetMapping("/showAppRating")
    public String showAppRating() {

        System.out.println("ааааааааааааааа");
        return "rating/showAppRating";
    }




}