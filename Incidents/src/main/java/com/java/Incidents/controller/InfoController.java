package com.java.Incidents.controller;



import com.java.Incidents.controller.dto.CompanyDTO;
import com.java.Incidents.service.servicesInterface.InfoService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/tour")
    public ModelAndView getTourView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("incident/incident");
        return modelAndView;
    }

    @GetMapping("/tour/data")
    public List<CompanyDTO> getIncidentData() {
        return infoService.getDataForIncident();
    }
}

