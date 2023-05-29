package com.cesi.heroes.bootstrap;

import com.cesi.heroes.domain.City;
import com.cesi.heroes.domain.EIncident;
import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.domain.Incident;
import com.cesi.heroes.repositories.CityRepository;
import com.cesi.heroes.repositories.HeroRepository;
import com.cesi.heroes.repositories.IncidentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.HashSet;

@Component
public class BootstrapData implements CommandLineRunner {
    private final HeroRepository heroRepository;
    private final IncidentRepository incidentRepository;
    private final CityRepository cityRepository;

    public BootstrapData(HeroRepository heroRepository, IncidentRepository incidentRepository, CityRepository cityRepository) {
        this.heroRepository = heroRepository;
        this.incidentRepository = incidentRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*City gotham = new City();
        gotham.setNom("Gotham");
        cityRepository.save(gotham);
        Hero hero = new Hero();
        hero.setName("Batman");
        hero.setCity(gotham);
        hero.setPhone("0123456589");
        hero.setLongitude(0.0);
        hero.setLatitude(0.0);
        Hero heroSaved =heroRepository.save(hero);
        HashSet<EIncident> incidents = new HashSet<EIncident>();
        incidents.add(EIncident.Accident_aerien);

        heroRepository.save(heroSaved);
        */


    }
}
