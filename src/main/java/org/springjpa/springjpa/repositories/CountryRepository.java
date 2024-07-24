package org.springjpa.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springjpa.springjpa.entities.City;
import org.springjpa.springjpa.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findById(int id);
}
