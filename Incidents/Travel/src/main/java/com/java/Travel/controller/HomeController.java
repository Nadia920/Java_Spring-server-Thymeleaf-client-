package com.java.Travel.controller;

import com.java.Travel.controller.dto.ApiError;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.model.AppRating;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.AppRatingService;
import com.java.Travel.service.CompanyService;
import com.java.Travel.service.CountryService;
import com.java.Travel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private CountryService countryService;

    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private AppRatingService addRatingService;

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
        return "home/home";
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        /*model.addAttribute("countries", countryService.findAll(Sort.by("name").ascending()));*/
        return "index";
        /*return "waq";*/
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*@GetMapping("/registration")
    public String registration() {
        return "registration";
    }*/
    @GetMapping("/registration")
    public String getSignUpView(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("companies", companyService.findAll());
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registrationClient(@Valid @ModelAttribute("user") UserEntity client,
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
        System.out.println("hello from controller");
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

        return "rating/showAppRating";
    }
     
    @GetMapping("/AppRating/add")
    public String addAppRating(Model model) {
        model.addAttribute("obj", new AppRating());
        return "rating/addRating";
    }
    
    @PostMapping("/add/rating")
    public String addAppRating(AppRating obj) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userService.findByLogin1(userInfo.getUsername());
        obj.setUserEntity(user);
        addRatingService.save(obj);
        return "rating/addRating";
    }
   
}
