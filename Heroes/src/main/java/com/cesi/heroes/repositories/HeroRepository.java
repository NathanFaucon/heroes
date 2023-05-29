package com.cesi.heroes.repositories;

import com.cesi.heroes.domain.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {
}
