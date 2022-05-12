package com.java.Incidents.controller;


import com.java.Incidents.controller.dto.IncidentCreateUpdateDTO;
import com.java.Incidents.controller.dto.IncidentDTO;
import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.security.CustomUserDetail;
import com.java.Incidents.service.servicesInterface.EmailSender;
import com.java.Incidents.service.servicesInterface.IncidentService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/orders")
public class OrderController {
    private final static Logger LOGGER = LogManager.getLogger();

    private IncidentService incidentService;
    private EmailSender emailSender;

    public OrderController(IncidentService orderService,
                           EmailSender emailSender) {
        this.incidentService = incidentService;
        this.emailSender = emailSender;
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/checkout")
    @ResponseBody
    public IncidentDTO addTicket(@RequestBody IncidentCreateUpdateDTO incidentDTO, @AuthenticationPrincipal CustomUserDetail currentUser) {
        LOGGER.info("Buy Trip tickets. Order: " + incidentDTO + ", Client with login: " + currentUser.getLogin());
        incidentDTO.setIdClient(currentUser.getId());
        return incidentService.add(incidentDTO);

    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/client")
    public String getOrdersByUser(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status, Model model, @AuthenticationPrincipal CustomUserDetail currUser) {
        List<IncidentDTO> orderDTOList = incidentService.getOrdersByUserIdAndStatus(currUser.getId(), status);
        model.addAttribute("orders", orderDTOList.size() != 0 ? orderDTOList : null);
        return "withrole/client/myTrips";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/return/{id}")
    public String getOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("order", incidentService.findById(id));
        return "order/returnTickets";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/return")
    @ResponseBody
    public IncidentCreateUpdateDTO deleteTicketsOnTripByUser(@RequestBody IncidentCreateUpdateDTO incident, @AuthenticationPrincipal CustomUserDetail currUser) {
        incident.setIdClient(currUser.getId());
        incidentService.deleteTicketsOnTripByUSer(incident);
        return incident;
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/{id}/moreTickets")
    public String getTakeMoreTicketsView(@PathVariable Long id, Model model) {
        model.addAttribute("incident", incidentService.findById(id));
        return "incident/takeMoreTickets";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/{id}/moreTickets")
    @ResponseBody
    public IncidentDTO takeMoreTickets(@RequestBody IncidentCreateUpdateDTO order, @AuthenticationPrincipal CustomUserDetail currUser) {
        order.setIdClient(currUser.getId());
        return incidentService.takeMoreTickets(order);
    }

    @PostMapping("/sendСonfirmPurchaseToEmail")
    @ResponseBody
    public IncidentDTO sendСonfirmPurchaseToEmail(@RequestBody IncidentDTO incidentDTO, @AuthenticationPrincipal CustomUserDetail currUser) {
        LOGGER.info("Send Сonfirm Purchase To Email. Order: " + incidentDTO);
        emailSender.sendСonfirmPurchaseToEmail(incidentDTO);
        return incidentDTO;
    }


}
