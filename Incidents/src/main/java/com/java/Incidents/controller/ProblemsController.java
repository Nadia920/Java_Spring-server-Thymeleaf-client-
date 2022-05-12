package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.IncidentCreateUpdateDTO;
import com.java.Incidents.controller.dto.ProblemDTO;
import com.java.Incidents.controller.dto.QuestionDTO;
import com.java.Incidents.security.CustomUserDetail;
import com.java.Incidents.service.servicesInterface.ProblemService;
import com.java.Incidents.service.servicesInterface.QuestionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/problems")
public class ProblemsController {
    ProblemService problemService;

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/ProblemsAdd")
    public String getProblemAdd() {
        return "PageProblemsAdd";
    }

    @PostMapping(path = "/ProblemsAdd")
    public String registrationClient(@Valid @ModelAttribute("Problems") ProblemDTO problems,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("Problems", problems);
            model.addAttribute("apiError", apiError);
            return "showProblems";
        }

        problemService.save(problems);

        return "PageProblemsAdd";
    }
    /*@PostMapping(path = "/PageProblemsAdd")
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
    public IncidentCreateUpdateDTO deleteTicketsOnTripByUser(@RequestBody IncidentCreateUpdateDTO incident, @AuthenticationPrincipal CustomUserDetail currUser) {
        incident.setIdClient(currUser.getId());
        incidentService.deleteTicketsOnTripByUSer(order);
        return order;
    }*/
}
