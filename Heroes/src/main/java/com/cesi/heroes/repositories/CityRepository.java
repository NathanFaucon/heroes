package com.cesi.heroes.repositories;

import com.cesi.heroes.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
