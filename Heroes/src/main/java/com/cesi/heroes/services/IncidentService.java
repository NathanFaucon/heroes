package com.cesi.heroes.services;

import com.cesi.heroes.domain.EIncident;
import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.domain.Incident;

import java.util.List;

public interface IncidentService {
    List<Incident> findAll();
    Incident findById(Long id);
    void save(Incident incident);
    void deleteById(Long id);

    List<Hero> getCloseHeroes(Long id);
}
