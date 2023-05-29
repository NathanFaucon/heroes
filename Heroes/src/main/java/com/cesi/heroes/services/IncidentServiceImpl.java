package com.cesi.heroes.services;

import com.cesi.heroes.domain.EIncident;
import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.domain.Incident;
import com.cesi.heroes.repositories.HeroRepository;
import com.cesi.heroes.repositories.IncidentRepository;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {
    private final IncidentRepository incidentRepository;
    private final HeroRepository heroRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository, HeroRepository heroRepository) {
        this.incidentRepository = incidentRepository;
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Incident> findAll() {
        return (List<Incident>) incidentRepository.findAll();
    }


    @Override
    public Incident findById(Long id) {
        return incidentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Incident incident) {
        incidentRepository.save(incident);
    }

    @Override
    public void deleteById(Long id) {
        incidentRepository.deleteById(id);
    }

    @Override
    public List<Hero> getCloseHeroes(Long id) {
        Boolean canHandle = false;
        double distance = 0;
        ArrayList<Hero> closeHeroes = new ArrayList<Hero>();
        List<Hero> heroes = (List<Hero>) heroRepository.findAll();
        if (incidentRepository.findById(id)!=null) {
            Optional<Incident> incident = incidentRepository.findById(id);
            for (Hero hero:heroes) {
                canHandle=false;
                ArrayList<EIncident> incidents = new ArrayList<EIncident>();
                incidents.add(hero.getIncident1());
                incidents.add(hero.getIncident2());
                incidents.add(hero.getIncident3());
                if (incidents.contains(incident.get().getType())){
                    canHandle=true;
                };
                distance = Math.sqrt(Math.pow(incident.get().getLatitude()-hero.getLatitude(), 2)+Math.pow(incident.get().getLongitude()-hero.getLongitude(), 2));
                if (distance<=50 && canHandle){
                    closeHeroes.add(hero);
                }
            }
        }
        return closeHeroes;
    }
}
