package com.cesi.heroes.services;

import com.cesi.heroes.domain.Hero;
import com.cesi.heroes.repositories.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> findAll() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Hero findById(Long id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Hero hero) {
        heroRepository.save(hero);
    }

    @Override
    public void deleteById(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public boolean isInCity(Long id){
        List<Hero> heroes = findAll();
        for (Hero hero: heroes) {
            if (hero.getCity().getId()==id)
            {
                return true;
            }
        }
        return false;
    }
}
