package com.java.Travel.controller;


import com.java.Travel.controller.dto.*;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Incidents")
public class IncidentController {
    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IncidentService incidentService;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetachmentService detachmentService;

    @GetMapping("/showMyIncidents")
    public String showIncident(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status, Model model, @AuthenticationPrincipal CustomUserDetail currUser) {
        List<IncidentDTO> incidentDTOList = incidentService.getOrdersByUserIdAndStatus(currUser.getId(), status);
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "withrole/client/myIncidents";
    }
    @GetMapping("/showIncidentsFalse")
    public String showIncidentFalse(/*@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status,*/ Model model /*, @AuthenticationPrincipal CustomUserDetail currUser*/) {
        List<IncidentDTO> incidentDTOList = incidentService.getIncidentsFalse("False");
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }
    @GetMapping("/showIncidentsTrue")
    public String showIncidentTrue(/*@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status,*/ Model model/*, @AuthenticationPrincipal CustomUserDetail currUser*/) {
        List<IncidentDTO> incidentDTOList = incidentService.getIncidentsTrue("True");
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }
    @GetMapping("/report")
    public String report(Model model){
        List<IncidentDTO> incidentDTOList = incidentService.findALL();
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "report/report";
    }

    /*@GetMapping("/showIncidents")
    public String showIncident(){
        return "Incident/showIncidents";
    }*/

    @PostMapping("/addI")
    public String addI(Long id, Model model){
        String incident = incidentService.getIncidentsReactionByID(id);
        model.addAttribute("incidentName", incident);
        model.addAttribute("incidentReact", incident);
        return "Incident/getReport";
    }
    @GetMapping("/showAllIncidents")
    public String showAllIncidents(Model model){
        List<IncidentDTO> incidentDTOList = incidentService.getIncidents();
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }


    @GetMapping("/addIncident")
    public String add(Model model) {
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categories", categoryDTOList.size() != 0 ? categoryDTOList : null);
        List<DetachmentDTO> detachmentDTOList = detachmentService.findAll();
        model.addAttribute("detachments", detachmentDTOList.size() != 0 ? detachmentDTOList : null);
        model.addAttribute("obj", new IncidentDTO());
        return "Incidents/PageIncidentAdd";
    }
    @PostMapping("/PageIncidentsAdd")
    public void addIncident(Model model, IncidentDTO obj) {
        incidentService.save(obj);
    }
    }

