package com.java.Travel.controller;

import com.java.Travel.controller.dto.*;
import com.java.Travel.model.CategoryEntity;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.IncidentLog;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.security.CustomUserDetail;
import com.java.Travel.service.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/Incidents")
public class IncidentController {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IncidentService incidentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetachmentService detachmentService;
    @Autowired
    private UserService userService;
     @Autowired
    private IncidentLogService incidentLogService;
    


    @GetMapping("/showIncidentsFalse")
    public String showIncidentFalse(/*@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status,*/Model model /*, @AuthenticationPrincipal CustomUserDetail currUser*/) {
        List<IncidentsEntity> incidentDTOList = incidentService.getIncidentsFalse("False");
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }

    @GetMapping("/showIncidentsTrue")
    public String showIncidentTrue(/*@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status,*/Model model/*, @AuthenticationPrincipal CustomUserDetail currUser*/) {
        List<IncidentsEntity> incidentDTOList = incidentService.getIncidentsTrue("True");
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }

    @GetMapping("/report")
    public String report(Model model) {
        List<IncidentsEntity> incidentDTOList = incidentService.findALL();
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "report/report";
    }

    /*@GetMapping("/showIncidents")
    public String showIncident(){
        return "Incident/showIncidents";
    }*/
    @PostMapping("/addI")
    public String addI(@RequestParam(name="idReportIncident")Long id, Model model) {
        IncidentsEntity incident = incidentService.findById(id);
        model.addAttribute("incidentName", incident.getIncidentName());
        model.addAttribute("incidentReact", incident.getReaction());
        return "report/getReport";
    }

    @GetMapping("/showAllIncidents")
    public String showAllIncidents(Model model) {
        List<IncidentsEntity> incidentDTOList = incidentService.findALL();
        model.addAttribute("incidents", incidentDTOList.size() != 0 ? incidentDTOList : null);
        return "Incidents/showIncidents";
    }

    @GetMapping("/addIncident")
    public String add(Model model) {
        List<CategoryEntity> categoryDTOList = categoryService.findAll();
        model.addAttribute("categories", categoryDTOList.size() != 0 ? categoryDTOList : null);
        List<DetachmentEntity> detachmentDTOList = detachmentService.findAll();
        model.addAttribute("detachments", detachmentDTOList.size() != 0 ? detachmentDTOList : null);
        model.addAttribute("obj", new IncidentsEntity());
        return "Incidents/PageIncidentAdd";
    }

    @PostMapping("/PageIncidentsAdd")
    public String addIncident(Model model, IncidentsEntity obj) {
        incidentService.save(obj);
        return "redirect:/";
    }
   
    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "search") String a) {

        List<IncidentsEntity> list = incidentService.findIncidentName(a);
        model.addAttribute("incidents", list);
        return "Incidents/showIncidents";
    }
    
    @GetMapping("/showIncidentLog")
    public String showAllIncidentLogs(Model model) {
        List<IncidentLog> incidentList = incidentLogService.findALL();
        model.addAttribute("incidentLogs", incidentList.size() != 0 ? incidentList : null);
        return "Incidents/showIncidentLog";
    }

    @GetMapping("/addIncidentLog")
    public String addLog(Model model) {
        List<CategoryEntity> categoryDTOList = categoryService.findAll();
        model.addAttribute("categories", categoryDTOList.size() != 0 ? categoryDTOList : null);
        model.addAttribute("userEntities", userService.findAll());
        model.addAttribute("obj", new IncidentLog());
        return "Incidents/PageIncidentLogAdd";
    }


    @PostMapping(value = "/saveNewInLog", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addLog(@RequestBody MultiValueMap<String, String> values) {
//      
        System.out.println(values);
//        incidentLogService.save(incidentLog);
        return "redirect:/";
    }

    @GetMapping("/searchLog")
    public String searchLog(Model model, @RequestParam(name = "search") String a) {

        List<IncidentLog> list = incidentLogService.findIncidentName(a);
        model.addAttribute("incidents", list);
        return "Incidents/showIncidents";
    }
    
}
