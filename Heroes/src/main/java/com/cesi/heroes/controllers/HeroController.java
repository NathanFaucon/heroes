package com.cesi.heroes.controllers;

import com.cesi.heroes.domain.City;
import com.cesi.heroes.domain.EIncident;
import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.repositories.HeroRepository;
import com.cesi.heroes.services.CityService;
import com.cesi.heroes.services.CityServiceImpl;
import com.cesi.heroes.services.HeroService;
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
import java.util.Set;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private final HeroService heroService;
    private final CityService cityService;
    private final IncidentService incidentService;

    public HeroController(HeroService heroService, CityService cityService, IncidentService incidentService) {
        this.heroService = heroService;
        this.cityService =  cityService;
        this.incidentService = incidentService;
    }

    @GetMapping
    public String getHeroes(Model model){
        model.addAttribute("heroes", heroService.findAll());
        return "heroList";
    }

    @GetMapping("/create")
    public String createHeroForm(Model model){
        model.addAttribute("hero", new Hero());
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "createHero";
    }

    @PostMapping("/create")
    public String createHero(@Validated Hero hero, BindingResult result, Model model){
        if(result.hasErrors() || (hero.getIncident1() == EIncident.Aucun && hero.getIncident2() == EIncident.Aucun && hero.getIncident3() == EIncident.Aucun)){
            List<City> cities = cityService.findAll();
            model.addAttribute("cities", cities);
            return "createHero";
        }
        heroService.save(hero);
        return "redirect:/heroes";
    }

    @GetMapping("/edit/{id}")
    public String editHeroForm(@PathVariable("id") Long id, Model model){
        Hero heroFound = heroService.findById(id);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        if (heroFound!=null){
            model.addAttribute("hero", heroFound);
            return "editHero";
        } else {
            return "redirect:/heroes";
        }
    }

    @PostMapping("edit/{id}")
    public String editHero(@PathVariable("id") Long id, @Validated Hero hero, BindingResult result, Model model){
        if(result.hasErrors() || (hero.getIncident1() == EIncident.Aucun && hero.getIncident2() == EIncident.Aucun && hero.getIncident3() == EIncident.Aucun)){
            List<City> cities = cityService.findAll();
            model.addAttribute("cities", cities);
            return "edithero";
        }
        hero.setId(id);
        heroService.save(hero);
        return "redirect:/heroes";
    }

    @GetMapping("/delete/{id}")
    public String deleteHero(@PathVariable("id") Long id){
        heroService.deleteById(id);
        return "redirect:/heroes";
    }
}
