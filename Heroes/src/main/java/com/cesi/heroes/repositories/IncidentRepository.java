package com.cesi.heroes.repositories;

import com.cesi.heroes.domain.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
