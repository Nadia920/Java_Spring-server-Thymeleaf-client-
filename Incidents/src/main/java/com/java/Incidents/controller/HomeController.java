package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.security.CustomUserDetail;
import com.java.Incidents.service.servicesInterface.CountryService;
import com.java.Incidents.service.servicesInterface.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class HomeController {


    private UserService userService;
    private CountryService countryService;

    public HomeController(UserService userService,
                          CountryService countryService) {
        this.userService = userService;
        this.countryService = countryService;
    }

    @GetMapping(value = "/home")
    public String getHomeView(Model model, @AuthenticationPrincipal CustomUserDetail currentUser) {
        model.addAttribute("id", currentUser.getId());
        return "home/home";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("countries", countryService.findAll(Sort.by("name").ascending()));
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize("hasAnyRole('ADMIN, WORKER')")
    @GetMapping("/login")
    public String loginA() {
        return "menuAdmin";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/login")
    public String loginC() {
        return "menuClient";
    }

    @GetMapping(value = "/registration")
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


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @GetMapping("/MenuAdmin")
    public String MenuAdmin() { return "MenuAdmin"; }

    @GetMapping("/MenuClient")
    public String MenuClient() {
        return "home/MenuClient";
    }

    @GetMapping("/AppRating")
    public String AppRating() {
        return "company/AppRating";
    }

    @GetMapping("/Admin")
    public String Admin() {
        return "home/Admin";
    }

    @GetMapping("/Category")
    public String Category() {
        return "company/Category";
    }

    @GetMapping("/Client")
    public String Client() {
        return "company/Client";
    }

    @GetMapping("/showDetachment")
    public String Detachment() {
        return "showDetachment";
    }

    @GetMapping("/showFixedDetachments")
    public String FixedDetachments() {
        return "showFixedDetachments";
    }

    @GetMapping("/GivingCompany")
    public String GivingCompany() {
        return "company/GivingCompany";
    }

    @GetMapping("/showIncidents")
    public String Incidents() {
        return "showIncidents";
    }

    @GetMapping("/Problems")
    public String Problems() {
        return "company/Problems";
    }

    @GetMapping("/Questions")
    public String Questions() {
        return "company/Questions";
    }

    @GetMapping("/ReceivingCompany")
    public String ReceivingCompany() {
        return "company/ReceivingCompany";
    }

    @GetMapping("/staff")
    public String staff() {
        return "company/staff";
    }

    @GetMapping("/TestDiffIncident")
    public String TestDiffIncident() {
        return "company/TestDiffIncident";
    }

    @GetMapping("/TestMoments")
    public String TestMoments() {
        return "company/TestMoments";
    }

    @GetMapping("/Tests")
    public String Tests() {
        return "company/Tests";
    }

    @GetMapping("/TestsResults")
    public String TestsResults() {
        return "company/TestsResults";
    }









}
