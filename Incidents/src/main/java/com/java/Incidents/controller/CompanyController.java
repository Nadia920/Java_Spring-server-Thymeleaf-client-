package com.java.Incidents.controller;

import com.java.Incidents.controller.dto.ApiError;
import com.java.Incidents.controller.dto.CompanyDTO;
import com.java.Incidents.exception.EditCompanyParametersExistException;
import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.Company;
import com.java.Incidents.service.servicesInterface.CompanyService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompanyController {


    private final static Logger LOGGER = LogManager.getLogger();

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public String showPage(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "name", required = false, defaultValue = " ") String name) {
        LOGGER.info("Get companies view, page: " + page);
        Page<Company> companyEntities;
        if (!name.equals(" ")) {
            LOGGER.info("Find companies with name: %" + name + '%');
            model.addAttribute("name", name);
            companyEntities = companyService.findAllByCriteria(PageRequest.of(page, 8, Sort.by("name").ascending()), name);
        } else {
            companyEntities = companyService.findAll(PageRequest.of(page, 8, Sort.by("name").ascending()));
        }
        model.addAttribute("companies", companyEntities.getTotalElements() == 0 ? null : companyEntities);
        model.addAttribute("currentPage", page);
        return "company/showCompanies";
    }

    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String getAddOrEditCompanyView(Model model, @PathVariable(value = "id") Optional<Long> id) throws EntityNotFoundException {
        LOGGER.info("Get add or edit company view. Company id: " + id);
        if (id.isPresent()) {
            CompanyDTO companyDTO = companyService.findOne(id.get());
            if (companyDTO != null) {
                model.addAttribute("company", companyDTO);
                model.addAttribute("ratingTypes", AppRating.values());
            } else {
                LOGGER.error("Company with id=" + id + " not found");
                throw new EntityNotFoundException("Company with id=" + id + " not found");
            }
            return "company/editCompany";
        } else {
            model.addAttribute("company", new CompanyDTO());
            model.addAttribute("ratingTypes", AppRating.values());
            return "company/editCompany";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable(value = "id") Long id) {
        LOGGER.info("Delete company by id: " + id);
        companyService.deleteById(id);
        return "redirect:/companies";
    }

    @PostMapping(path = "/edit")
    public String addOrEditCompany(@Valid @ModelAttribute("company") CompanyDTO company,
                                   BindingResult result,
                                   Model model) {
        LOGGER.info("Add or Edit company where companyDTO: " + company);
        if (result.hasErrors()) {
            LOGGER.error("Validation error");
            ApiError apiError = new ApiError();
            String message = "";
            for (FieldError str : result.getFieldErrors()) {
                message += str.getDefaultMessage();
                apiError.setMessage(message);
            }

            model.addAttribute("company", company);
            model.addAttribute("ratingTypes", AppRating.values());
            model.addAttribute("apiError", apiError);
            return "company/editCompany";
        }

        if (company.getId() != null) {

            if (companyService.getCompanyIdByName(company.getName()) != null
                    && companyService.getCompanyIdByName(company.getName()) != company.getId()) {
                LOGGER.error("Company with this name already exist, name: " + company.getName());
                throw new EditCompanyParametersExistException("Company_with_this_name_already_exist", company);
            }
            companyService.update(company);
        } else {
            if (companyService.getCompanyIdByName(company.getName()) != null) {
                LOGGER.error("Company with this name already exist, name: " + company.getName());
                throw new EditCompanyParametersExistException("Company_with_this_name_already_exist", company);
            }
            companyService.save(company);
        }
        return "redirect:/companies";
    }



    /*private final static Logger LOGGER = LogManager.getLogger();

    private BusStationService busStationService;
    private CountryService countryService;
    private CityService cityService;

    public BusStationController(BusStationService busStationService,
                                CountryService countryService,
                                CityService cityService) {
        this.busStationService = busStationService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getShowBusStationsView(Model model) {
        LOGGER.info("Get showBusStationsView: busStation/showBusStations.html");
        List<BusStationDTO> busStationDTOs = busStationService.findAll();
        model.addAttribute("busStations", busStationDTOs.size() == 0 ? null : busStationDTOs);
        return "busStation/showBusStations";
    }

    @GetMapping("/edit/{id}")
    public String getEditBusStationView(@PathVariable Long id, Model model) {
        LOGGER.info("Get editBusStationView: busStation/editBusStation");
        BusStationDTO busStationDTO = busStationService.findById(id);
        model.addAttribute("busStation", busStationDTO);
        return "busStation/editBusStation";
    }

    @PostMapping("/edit")
    public String editBusStation(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String code) {
        LOGGER.info("Update busStation where id: " + id + ", new name: " + name + ", new code: " + code);
        busStationService.updateBusStation(new BusStationDTO(id, name, code));
        return "redirect:/busStation";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusStation(@PathVariable Long id) {
        LOGGER.info("Delete busStation where id: " + id);
        busStationService.delete(id);
        return "redirect:/busStations";
    }

    @GetMapping("/add")
    public String getAddBusStationView(Model model) {
        LOGGER.info("Get addBusStation: busStation/addBusStation");
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities", new ArrayList<CityDTO>());

        return "busStation/addBusStation";
    }


    @GetMapping(value = "/countries/{id}")
    @ResponseBody
    public List<CityDTO> getCities(@PathVariable Long id) {
        LOGGER.info("Get cities where country id: " + id);
        return cityService.getCityListByCountry(id);
    }

    @PostMapping("/add")
    public String addBusStation(@RequestParam String name,
                                @RequestParam String code,
                                @RequestParam Long idCity) {
        LOGGER.info("Add busStation with name: " + name + ", code: " + code + ", idCity: " + idCity);
        busStationService.save(new BusStationDTO(name, code, idCity));
        return "redirect:/busStation";
    }*/


}
