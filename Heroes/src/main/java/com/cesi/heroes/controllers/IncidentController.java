package com.cesi.heroes.controllers;

import com.cesi.heroes.domain.City;
import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.domain.Incident;
import com.cesi.heroes.services.CityService;
import com.cesi.heroes.services.IncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/incidents")
public class IncidentController {
    private final IncidentService incidentService;
    private final CityService cityService;

    public IncidentController(IncidentService incidentService, CityService cityService) {
        this.incidentService = incidentService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getIncidents(Model model){
        model.addAttribute("incidents", incidentService.findAll());
        return "incidentList";
    }

    @GetMapping("/create")
    public String createIncidentForm(Model model){
        model.addAttribute("incident", new Incident());
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "createIncident";
    }

    @PostMapping("/create")
    public String createIncident(@Validated Incident incident, BindingResult result){
        if(result.hasErrors()){
            return "createIncident";
        }
        incidentService.save(incident);
        return "redirect:/incidents";
    }

    @GetMapping("/edit/{id}")
    public String editIncidentForm(@PathVariable("id") Long id, Model model){
        Incident incidentFound = incidentService.findById(id);
        if(incidentFound!=null){
            List<City> cities = cityService.findAll();
            model.addAttribute("cities", cities);
            model.addAttribute("incident", incidentFound);
            return "editIncident";
        } else {
            return "redirect:/incidents";
        }
    }

    @PostMapping("/edit/{id}")
    public String editIncident(@PathVariable("id") Long id, @Validated Incident incident, BindingResult result){
        if(result.hasErrors()){
            return "editIncident";
        }
        incident.setId(id);
        incidentService.save(incident);
        return "redirect:/incidents";
    }

    @GetMapping("/delete/{id}")
    public String deleteIncident(@PathVariable("id") Long id){
        incidentService.deleteById(id);
        return "redirect:/incidents";
    }

    @GetMapping("/resolve/{id}")
    public String resolveIncident(@PathVariable("id") Long id, Model model){
        List<Hero> closeHeroes = incidentService.getCloseHeroes(id);
        model.addAttribute("closeHeroes", closeHeroes);
        return "resolveIncidents";
    }
}
