package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.QuestionDTO;
import com.java.Incidents.controller.dto.TestDTO;
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
@RequestMapping("/test")
public class TestController {

    @GetMapping("Tests")
    String showtest(){return "Tests";}

    @GetMapping("TestMoments")
    String showtestMoments(){return "TestMoments";}

    @GetMapping("TestDiffIncident")
    String showtestDiffIncident(){return "TestDiffIncident";}

    @PostMapping(path = "/TestDiffIncident")
    public String registrationClient(@Valid @ModelAttribute("Tests") TestDTO test,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("Tests", test);
            model.addAttribute("apiError", apiError);
            return "index";
        }

        /*result.save(test);*/

        return "redirect:/";
    }
}
