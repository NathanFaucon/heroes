package com.cesi.heroes.services;

import com.cesi.heroes.domain.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City findById(Long id);
    void save(City city);
    void deleteById(Long id);
}
