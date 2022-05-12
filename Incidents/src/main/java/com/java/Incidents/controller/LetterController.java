package com.java.Incidents.controller;


import com.java.Incidents.controller.dto.*;
import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.service.servicesInterface.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class LetterController {


    private final static Logger LOGGER = LogManager.getLogger();

    private CountryService countryService;
    private CityService cityService;
    private CompanyService companyService;
    private EmailSender emailSender;
    private IncidentService incidentService;

    private List<CountryDTO> countryDTOList;
    private List<CompanyDTO> companyDTOList;

    public LetterController(CountryService countryService,
                          CityService cityService,
                          CompanyService companyService,
                          EmailSender emailSender,
                          IncidentService incidentService) {

        this.countryService = countryService;
        this.cityService = cityService;
        this.companyService = companyService;
        this.emailSender = emailSender;
        this.incidentService = incidentService;
    }

    @ModelAttribute("countries")
    public List<CountryDTO> getCountries() {
        countryDTOList = countryService.findAll(Sort.by("name").ascending());
        return countryDTOList;
    }

    @GetMapping("/countries")
    @ResponseBody
    public List<CountryDTO> getCountriesJson() {
        return countryDTOList;
    }

    @ModelAttribute("companies")
    public List<CompanyDTO> getCompanies() {
        companyDTOList = companyService.findAll();
        return companyDTOList;
    }

    @GetMapping("/companies")
    @ResponseBody
    public List<CompanyDTO> getCompaniesJson() {
        return companyDTOList;
    }

    @GetMapping("/create")
    public String getAddTripView(Model model) {
        model.addAttribute("trip", new IncidentDTO());
        return "trip/addTrip";
    }

    /*GetMapping("/edit/{id}")
    public String getEditTripView(@PathVariable Long id, Model model) {
        IncidentDTO incidentDTO = incidentService.getById(id);

        String dDeparture = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(tripDTO.getDepartureDate().getTime()));
        String dArrival = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(tripDTO.getArrivalDate().getTime()));

        model.addAttribute("id", incidentDTO.getId());
        model.addAttribute("countries_fr", incidentDTO.getBusStationDeparture().getCityDTO().getCountryDTO());
        model.addAttribute("soldTickets", incidentService.getNumberSoldTicketById(incidentDTO.getId()));
        return "trip/editTrip";
    }*/

    @GetMapping(value = "/countries/{id}")
    @ResponseBody
    public List<CityDTO> getCities(@PathVariable Long id) {
        return cityService.getCityListByCountry(id);
    }


    @GetMapping(value = "/companies/{id}")
    @ResponseBody
    public List<IncidentDTO> getBuses(@PathVariable Long id) {
        return companyService.findOne(id).getIncidentDTOList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IncidentCreateUpdateDTO addTrip(@RequestBody IncidentCreateUpdateDTO incidentDTO) {
        LOGGER.info("Create Trip where tripCreateUpdateDTO: " + incidentDTO);
        incidentService.addIncident(incidentDTO);
        return incidentDTO;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public IncidentCreateUpdateDTO editTrip(@PathVariable Long id, @RequestBody IncidentCreateUpdateDTO incidentDTO) {
        LOGGER.info("Edit trip where new tripCreateUpdateDTO: " + incidentDTO);
        incidentService.edit(incidentDTO);
        return incidentDTO;
    }


    @PreAuthorize("hasAnyRole('WORKER','ADMIN')")
    @GetMapping()
    public String getTripView(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status, Model model) {
        List<IncidentDTO> tripDTOList = incidentService.findAllByStatus(status);
        model.addAttribute("trips", tripDTOList.size() != 0 ? tripDTOList : null);
        return "withrole/showTrips";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/show/{id}")
    public String getShowTripViewByClient(@PathVariable Long id, Model model) {
        model.addAttribute("trip", incidentService.getById(id));
        return "trip/checkoutOrder";
    }

    @GetMapping("/canceled/{id}")
    public String canceledTrip(@PathVariable(name = "id") Long idTrip) {
        LOGGER.info("Cancel Trip where trip id: " + idTrip);
        incidentService.canceledIncident(idTrip);
        sendСancellationСonfirmToEmail(idTrip);
        return "redirect:/trip";
    }

    @GetMapping("/{id}/incidents")
    public String getTripTicketsSold(@PathVariable Long id, Model model) {
        model.addAttribute("incidents", incidentService.findAllByIncidentId(id));
        return "incident/showIncidents";
    }

    private void sendСancellationСonfirmToEmail(Long idTrip) {
        LOGGER.info("Send a cancellation email to all users");
        List<IncidentDTO> orderDTOList = incidentService.findAllByTripId(idTrip);
        orderDTOList.stream().forEach(a -> emailSender.sendСancellationСonfirmToEmail(a));
    }

    @GetMapping("/findTrips")
    public ModelAndView getTripByCriteria() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trip/showTrips");
        modelAndView.addObject("trips", null);
        modelAndView.addObject("rating", AppRating.values());
        modelAndView.addObject("tripCriteriaDTO", new IncidentCriteriaDTO());
        return modelAndView;
    }

    @PostMapping("/findTrips")
    public ModelAndView getTripByCriteria(@ModelAttribute("tripCriteriaDTO") IncidentCriteriaDTO incidentCriteriaDTO,
                                          @RequestParam(value = "companyChoice", required = false) Long companyChoice) {
        LOGGER.info("Get trips by criteria: " + incidentCriteriaDTO);
        ModelAndView modelAndView = new ModelAndView("trip/showTrips");
        modelAndView.addObject("picker1", incidentCriteriaDTO.getDepartureDate());
        modelAndView.addObject("city_from", cityService.findOne(incidentCriteriaDTO.getIdCityDeparture()));
        modelAndView.addObject("city_to", cityService.findOne(incidentCriteriaDTO.getIdCityArrival()));
        modelAndView.addObject("companyChoice", incidentCriteriaDTO.getIdCompany() == null ? null : companyService.findOne(incidentCriteriaDTO.getIdCompany()).getName());
        modelAndView.addObject("tripCriteriaDTO", incidentCriteriaDTO);

        List<IncidentDTO> tripDTOList = null;
        try {
            tripDTOList = incidentService.findTripsByCriteria(incidentCriteriaDTO);
        }
        catch (Exception e) {
            LOGGER.error("Parse dates error");
            e.printStackTrace();
        }
        /*
        catch (ParseException e) {
            LOGGER.error("Parse dates error");
            e.printStackTrace();
        }*/
        modelAndView.addObject("trips", tripDTOList.size() == 0 ? null : tripDTOList);
        return modelAndView;
    }

}
