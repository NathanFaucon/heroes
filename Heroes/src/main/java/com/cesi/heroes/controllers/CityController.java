package com.cesi.heroes.controllers;

import com.cesi.heroes.domain.City;
import com.cesi.heroes.services.CityService;
import com.cesi.heroes.services.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
@RequestMapping("/cities")
public class CityController {
    public final CityService cityService;
    public final HeroService heroService;

    public CityController(CityService cityService, HeroService heroService) {
        this.cityService = cityService;
        this.heroService = heroService;
    }

    @GetMapping
    public String getCities(Model model){
        model.addAttribute("cities", cityService.findAll());
        return "cityList";
    }

    @GetMapping("/create")
    public String createCityForm(Model model){
        model.addAttribute("city", new City());
        return "createCity";
    }

    @PostMapping("/create")
    public String createCity(@Validated City city, BindingResult result){
        if(result.hasErrors()){
            return "createCity";
        }
        cityService.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/edit/{id}")
    public String editCityForm(@PathVariable("id") Long id, Model model){
        City cityFound = cityService.findById(id);
        if (cityFound!=null){
            model.addAttribute("city", cityFound);
            return "editCity";
        } else {
            return "redirect:/cities";
        }
    }

    @PostMapping("edit/{id}")
    public String editCity(@PathVariable("id") Long id, @Validated City city, BindingResult result){
        if(result.hasErrors()){
            return "editCity";
        }
        city.setId(id);
        cityService.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        if(!heroService.isInCity(id)){
            cityService.deleteById(id);
            return "redirect:/cities";
        }else{
            //JOptionPane.showMessageDialog(null, "Héro rattaché à cette ville");
            return "redirect:/cities";
        }
    }
}
