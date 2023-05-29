package com.cesi.heroes.services;

import com.cesi.heroes.domain.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> findAll();
    Hero findById(Long id);
    void save(Hero hero);
    void deleteById(Long id);
    boolean isInCity(Long id);
}
