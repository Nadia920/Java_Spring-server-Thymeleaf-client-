package com.java.Travel.controller;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.controller.dto.ProblemDTO;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.ProblemsEntity;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/problems")
public class ProblemsController {

    @Autowired
    private ProblemService problemService;
    @Autowired
    private DetachmentService detachmentService;

    @GetMapping(value = "/ProblemsAdd")
    public String getHelp(Model model) {
        List<DetachmentEntity> detachmentDTOList = detachmentService.findAll();
        model.addAttribute("detachments", detachmentDTOList.size() != 0 ? detachmentDTOList : null);
        model.addAttribute("obj", new ProblemsEntity());
        return "problems/ProblemsAdd";
    }

    @PostMapping(value = "/SendProblem")
    public String getSignUpView(ProblemsEntity problem, Model model) {
        System.out.println(problem);
        problemService.save(problem);
        return "redirect:/";
    }

}
