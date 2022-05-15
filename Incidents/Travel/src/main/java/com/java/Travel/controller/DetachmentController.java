package com.java.Travel.controller;

import com.java.Travel.controller.dto.*;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.EmployeeEntity;
import com.java.Travel.model.FixedDetachmentsEntity;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.CompanyService;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.EmployeeService;
import com.java.Travel.service.FixedDetachmentsService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

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
    public String addDetachment(Model model, @AuthenticationPrincipal CustomUserDetail currUser) {
        List<EmployeeEntity> employeeDTOList = new ArrayList<>();
        List<EmployeeEntity> all = employeeService.findAll();
        for (EmployeeEntity e : all) {
            if (e.getDetachment().equals("NO")) {
                employeeDTOList.add(e);
            }
        }
        model.addAttribute("employees", employeeDTOList.size() != 0 ? employeeDTOList : null);
        DetachmentEntity obj = new DetachmentEntity();
        model.addAttribute("obj", obj);
        return "Detachment/addDetachment";
    }

    @GetMapping("/readyDetachment")
    public void readyDetachment(@RequestParam(name = "employee") Long[] ids, Model model) {
        //DetachmentEntity detachmentEntity = new DetachmentEntity(detachmentDTO);
        for (Long id : ids) {
            System.out.println(id);
        }
    }

    @GetMapping("/showFixedDetachments")
    public String readyDetachment(FixedDetachmentsDTO fixedDetachmentsDTO, Model model) {
        List<FixedDetachmentsDTO> fixedDetachmentsDTOList = fixedDetachmentsService.getFixedDetachments();
        model.addAttribute("detachments", fixedDetachmentsDTOList.size() != 0 ? fixedDetachmentsDTOList : null);
        return "Detachment/showDetachment";
    }

    @GetMapping("/Detachment/showDetachment")
    public String showDetachment() {
        return "Detachment/showDetachment";
    }

    @GetMapping("/AddFixDetachment")
    public String addFixDetachment(Model model) {
        List<DetachmentEntity> l = detachmentsService.all();
        model.addAttribute("detachments", l.size() != 0 ? l : null);
        List<CompanyDTO> companyDTOList = compamyService.findAll();
        model.addAttribute("companies", companyDTOList.size() != 0 ? companyDTOList : null);
        model.addAttribute("obj", new FixedDetachmentsEntity());
        return "/FixedDetachment/AddFixedDetachment";
    }
    @PostMapping("/chooseDetachment")
    public void chooseDetachment(DetachmentEntity obj) {
        System.out.println(obj);
        detachmentsService.save(obj);
    }
    @PostMapping("/AddFix")
    public String addFix(FixedDetachmentsEntity obj) {
        System.out.println(obj.getCompanyEntity().getId() + " " + obj.getDetachmentEntity().getId());
        DetachmentEntity d = detachmentsService.findById(obj.getDetachmentEntity().getId());
        CompanyEntity c = compamyService.findById(obj.getCompanyEntity().getId());
        Set<FixedDetachmentsEntity> a = d.addFixedDetachments(obj);
        Set<FixedDetachmentsEntity> b = c.addFixedDetachments(obj);
        d.setFixedDetachments(a);
        c.setFixedDetachments(b);
        System.out.println(a.isEmpty());
        detachmentsService.save(d);
        compamyService.save(c);
        obj.setId(1L);
        obj.setDetachmentEntity(d);
        obj.setCompanyEntity(c);
        System.out.println(obj.getId() + " " + obj.getCompanyEntity().getId() + " " + obj.getDetachmentEntity().getId());
        fixedDetachmentsService.save(obj);
        return "redirect:/";
    }

}
