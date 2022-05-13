package com.java.Travel.controller;

import com.java.Travel.controller.dto.*;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.EmployeeEntity;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.CompanyService;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.EmployeeService;
import com.java.Travel.service.FixedDetachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/detachment")
public class DetachmentController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FixedDetachmentsService fixedDetachmentsService;
    @Autowired
    private DetachmentService detachmentsService;
    @Autowired
    private CompanyService compamyService;
    @GetMapping("/addDetachment")
    public String addDetachment(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status, Model model, @AuthenticationPrincipal CustomUserDetail currUser) {
        List<EmployeeEntity> employeeDTOList = employeeService.getEmployeesWithOutDetachment();
        List<EmployeeEntity> all =employeeService.findAll();
        for(EmployeeEntity e: all){
            if(e.getDetachment().equals("NO")) {
                employeeDTOList.add(e);
            }
        }
        model.addAttribute("employees", employeeDTOList.size() != 0 ? employeeDTOList : null);
        return "Detachment/addDetachment";
    }
    @GetMapping("/readyDetachment")
    public void readyDetachment(@RequestParam(name="employee")Long[] ids, Model model){
        //DetachmentEntity detachmentEntity = new DetachmentEntity(detachmentDTO);
        for(Long id:ids){
            System.out.println(id);
        }
    }
    @GetMapping("/showFixedDetachments")
    public String readyDetachment(FixedDetachmentsDTO fixedDetachmentsDTO, Model model){
        List<FixedDetachmentsDTO> fixedDetachmentsDTOList = fixedDetachmentsService.getFixedDetachments();
        model.addAttribute("detachments", fixedDetachmentsDTOList.size() != 0 ? fixedDetachmentsDTOList : null);
        return "Detachment/showDetachment";
    }
    @GetMapping("/Detachment/showDetachment")
    public String showDetachment(){
        return "Detachment/showDetachment";
    }

    @GetMapping("/AddFixDetachment")
    public String addFixDetachment(Model model){
        System.out.println("45");
        List<DetachmentDTO> detachmentsDTOList = detachmentsService.findAll();
        model.addAttribute("detachments", detachmentsDTOList.size() != 0 ? detachmentsDTOList : null);
        List<CompanyDTO> companyDTOList = compamyService.findAll();
        model.addAttribute("company", companyDTOList.size() != 0 ? companyDTOList : null);
        FixedDetachmentsDTO fix = new FixedDetachmentsDTO();
        model.addAttribute("obj", fix);
        return "/FixedDetachment/AddFixedDetachment";
    }


    @PostMapping("/AddFix")
    public void addFix(FixedDetachmentsDTO obj){
        fixedDetachmentsService.save(obj);
    }


}
