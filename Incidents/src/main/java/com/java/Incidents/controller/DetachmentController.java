package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.FixedDetachmentsDTO;
import com.java.Incidents.controller.dto.ProblemDTO;
import com.java.Incidents.service.servicesInterface.FixedDetachmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/detachments")
public class DetachmentController {
    FixedDetachmentsService  fixedDetachmentsService;
    @GetMapping("/chooseDetachment")
    public String chooseDetachment(@Valid @ModelAttribute("FixedDetachments") FixedDetachmentsDTO fixedDetachments,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("FixedDetachments", fixedDetachments);
            model.addAttribute("apiError", apiError);
            return "showProblems";
        }

        fixedDetachmentsService.save(fixedDetachments);

        return "redirect:/";
    }
    @GetMapping("/showDetachment")
    public String showDetachment(){
        return "showDetachment";
    }


}
