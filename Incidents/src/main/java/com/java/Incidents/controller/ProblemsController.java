package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.IncidentDTO;
import com.java.Incidents.controller.dto.OrderCreateUpdateDTO;
import com.java.Incidents.security.CustomUserDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class ProblemsController {
    @PostMapping(path = "/PageProblemsAdd")
    public String registrationClient(@Valid @ModelAttribute("user") ProblemDTO problem,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("user", incident);
            model.addAttribute("apiError", apiError);
            return "showProblems";
        }

        incidentService.save(incident, "ROLE_CLIENT");

        return "redirect:/";
    }

    @PostMapping(path = "/PageProblemsEdit")
    public String registrationClient(@Valid @ModelAttribute("Problems") ProblemDTO problem,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("user", incident);
            model.addAttribute("apiError", apiError);
            return "showProblems";
        }

        problemService.save(incident, "ROLE_CLIENT");

        return "redirect:/";
    }

    @PostMapping("/ProblemAdd")
    public String IncidentAdd(){
        return "PageProblemsAdd";
    }

    @PostMapping("/ProblemEdit")
    public String IncidentEdit(){
        return "PageProblemEdit";
    }


    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/ProblemDelete")
    @ResponseBody
    public OrderCreateUpdateDTO deleteTicketsOnTripByUser(@RequestBody OrderCreateUpdateDTO order, @AuthenticationPrincipal CustomUserDetail currUser) {
        order.setIdClient(currUser.getId());
        orderService.deleteTicketsOnTripByUSer(order);
        return order;
    }
}
