package com.java.Incidents.controller;


import com.java.Incidents.controller.dto.CompanyDTO;
import com.java.Incidents.controller.dto.CountryDTO;
import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.model.Incidents;
import com.java.Incidents.model.Questions;
import com.java.Incidents.security.CustomUserDetail;
import com.java.Incidents.service.QuestionServiceInterfImpl;
import com.java.Incidents.service.servicesInterface.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import com.java.Incidents.controller.dto.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/Questions")
public class QuestionsController {

    QuestionService questionService;

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/PageQuestionsAdd")
    public String getShowTripViewByClient() {
        return "PageQuestionsAdd";
    }

    @PostMapping(path = "/PageQuestionsAdd")
    public String registrationClient(@Valid @ModelAttribute("Questions") QuestionDTO questions,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("Questions", questions);
            model.addAttribute("apiError", apiError);
            return "showQuestions";
        }

        questionService.save(questions);

        return "redirect:/";
    }

}

/*@Controller
@RequestMapping(value = "/")
public class QuestionsController extends AbstractController<TypePatternQuestions.Question, QuestionServiceInterfImpl> {
    private final static Logger LOGGER = LogManager.getLogger();


    private IncidentService IncidentService;
    private CountryService countryService;
    private CityService cityService;
    private CompanyService companyService;
    private EmailSender emailSender;
    private QuestionService questionService;

    private List<QuestionDTO> questionDTOList;

    public QuestionsController(IncidentService IncidentService,
                              CountryService countryService,
                              CityService cityService,
                              CompanyService companyService,
                              EmailSender emailSender, IncidentService incidentService) {
        super(questionService);
        super(questionDTOList);
        this.IncidentService = IncidentService;
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


    @GetMapping("/edit/{id}")
    public String getEditTripView(@PathVariable Long id, Model model) {
        IncidentDTO incidentDTO = IncidentService.getById(id);


        model.addAttribute("id", incidentDTO.getId());
        model.addAttribute("countries_fr", incidentDTO.getBusStationDeparture().getCityDTO().getCountryDTO());
        model.addAttribute("countries_to", incidentDTO.getBusStationArrival().getCityDTO().getCountryDTO());
        return "trip/editTrip";
    }

    @GetMapping(value = "/countries/{id}")
    @ResponseBody
    public List<CityDTO> getCities(@PathVariable Long id) {
        return cityService.getCityListByCountry(id);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IncidentCreateUpdateDTO addTrip(@RequestBody IncidentCreateUpdateDTO tripDTO) {
        LOGGER.info("Create Trip where tripCreateUpdateDTO: " + tripDTO);
        IncidentService.addIncident(incidentDTO);
        return incidentDTO;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public IncidentCreateUpdateDTO editIncident(@PathVariable Long id, @RequestBody IncidentCreateUpdateDTO tripDTO) {
        LOGGER.info("Edit trip where new tripCreateUpdateDTO: " + incidentDTO);
        IncidentService.edit(incidentDTO);
        return incidentDTO;
    }


    @PreAuthorize("hasAnyRole('WORKER','ADMIN')")
    @GetMapping()
    public String getTripView(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") IncidentStatus status, Model model) {
        List<IncidentDTO> tripDTOList = IncidentService.findAllByStatus(status);
        model.addAttribute("trips", tripDTOList.size() != 0 ? tripDTOList : null);
        return "withrole/showIncidents";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/show/{id}")
    public String getShowTripViewByClient(@PathVariable Long id, Model model) {
        model.addAttribute("trip", IncidentService.getById(id));
        return "trip/checkoutOrder";
    }

    @GetMapping("/canceled/{id}")
    public String canceledTrip(@PathVariable(name = "id") Long idTrip) {
        LOGGER.info("Cancel Trip where trip id: " + idTrip);
        IncidentService.canceledTrip(idTrip);
        sendСancellationСonfirmToEmail(idTrip);
        return "redirect:/trip";
    }

    @GetMapping("/{id}/orders")
    public String getTripTicketsSold(@PathVariable Long id, Model model) {
        model.addAttribute("orders", incidentService.findAllByTripId(id));
        return "order/showOrdersOnTrip";
    }

    private void sendСancellationСonfirmToEmail(Long idTrip) {
        LOGGER.info("Send a cancellation email to all users");
        List<IncidentDTO> incidentDTOList = incidentService.findAllByTripId(idTrip);
        incidentDTOList.stream().forEach(a -> emailSender.sendСancellationСonfirmToEmail(a));
    }

    @GetMapping("/findTrips")
    public ModelAndView getTripByCriteria() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trip/showTrips");
        modelAndView.addObject("trips", null);
        modelAndView.addObject("rating", Rating.values());
        modelAndView.addObject("tripCriteriaDTO", new TripCriteriaDTO());
        return modelAndView;
    }

    @PostMapping("/findTrips")
    public ModelAndView getTripByCriteria(@ModelAttribute("tripCriteriaDTO") TripCriteriaDTO tripCriteriaDTO,
                                          @RequestParam(value = "companyChoice", required = false) Long companyChoice) {
        LOGGER.info("Get trips by criteria: " + tripCriteriaDTO);
        ModelAndView modelAndView = new ModelAndView("trip/showTrips");
        modelAndView.addObject("picker1", tripCriteriaDTO.getDepartureDate());
        modelAndView.addObject("city_from", cityService.findOne(tripCriteriaDTO.getIdCityDeparture()));
        modelAndView.addObject("city_to", cityService.findOne(tripCriteriaDTO.getIdCityArrival()));
        modelAndView.addObject("companyChoice", tripCriteriaDTO.getIdCompany() == null ? null : companyService.findOne(tripCriteriaDTO.getIdCompany()).getName());
        modelAndView.addObject("tripCriteriaDTO", tripCriteriaDTO);

        List<IncidentDTO> tripDTOList = null;
        try {
            tripDTOList = IncidentService.findTripsByCriteria(tripCriteriaDTO);
        } catch (ParseException e) {
            LOGGER.error("Parse dates error");
            e.printStackTrace();
        }
        modelAndView.addObject("trips", tripDTOList.size() == 0 ? null : tripDTOList);
        return modelAndView;
    }

    @PostMapping(path = "/PageIncidentsAdd")
    public String registrationClient(@Valid @ModelAttribute("user") IncidentDTO incident,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("user", incident);
            model.addAttribute("apiError", apiError);
            return "showIncidents";
        }

        incidentService.save(incident, "ROLE_CLIENT");

        return "redirect:/";
    }

    @PostMapping(path = "/PageIncidentsEdit")
    public String registrationClient(@Valid @ModelAttribute("Incident") IncidentDTO incident,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }
            model.addAttribute("incidents", incident);
            model.addAttribute("apiError", apiError);
            return "showIncidents";
        }


        questionService.save(questionDTOList, "ROLE_CLIENT");

        return "redirect:/";
    }

    @PostMapping("/IncidentAdd")
    public String IncidentAdd(){
        return "PageIncidentsAdd";
    }

    @PostMapping("/IncidentEdit")
    public String IncidentEdit(){
        return "PageIncidentEdit";
    }


    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/IncidentDelete")
    @ResponseBody
    public IncidentCreateUpdateDTO deleteTicketsOnTripByUser(@RequestBody IncidentCreateUpdateDTO incident, @AuthenticationPrincipal CustomUserDetail currUser) {
        incident.setIdClient(currUser.getId());
        /*QuestionService.deleteTicketsOnTripByUSer(incident);
        return incident;
    }

    @Override
    public ResponseEntity<Incidents> save(Incidents entity) {
        return null;
    }

    @Override
    public ResponseEntity<TypePatternQuestions.Question> save(TypePatternQuestions.Question entity) {
        return null;
    }
}*/
