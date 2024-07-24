package org.springjpa.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springjpa.springjpa.entities.City;

@Repository
public interface CityRepository  extends JpaRepository<City,Long> {

    City findByCityName(String cityName);
}
