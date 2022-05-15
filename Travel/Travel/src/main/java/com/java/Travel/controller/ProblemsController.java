package com.java.Travel.controller;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.controller.dto.ProblemDTO;
import com.java.Travel.controller.dto.UserDTO;
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

@Controller
@RequestMapping(value = "/problems")
public class ProblemsController {
    /*@Autowired*/
    private ProblemService problemService;
    @Autowired
    private DetachmentService detachmentService;

    @GetMapping(value = "/ProblemsAdd")
    public String getHelp(Model model) {
        List<DetachmentDTO> detachmentDTOList = detachmentService.findAll();
        model.addAttribute("detachment", detachmentDTOList.size() != 0 ? detachmentDTOList : null);
        return "problems/ProblemsAdd";
    }

    @GetMapping(value = "/ SendProblem")
    public void getSignUpView(@RequestBody ProblemDTO problemDTO, Model model) {
        ProblemsEntity problemsEntity = new ProblemsEntity(problemDTO);
    }
}
