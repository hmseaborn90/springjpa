package org.springjpa.springjpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springjpa.springjpa.entities.City;
import org.springjpa.springjpa.entities.Country;
import org.springjpa.springjpa.pojos.CityRequest;
import org.springjpa.springjpa.repositories.CityRepository;
import org.springjpa.springjpa.repositories.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired CityRepository cityRepository;
    @Autowired CountryRepository countryRepository;

    public CityService(){

    }

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public City getCity(String cityName){
        return cityRepository.findByCityName(cityName);
    }

    public City addCity(CityRequest cityRequest) {
        Country country = countryRepository.findById(cityRequest.country_id);
        City city = new City();
        city.setCityName(cityRequest.cityName);
        city.setCityCode(cityRequest.cityCode);
        city.setCountry(country);
        return cityRepository.save(city);
    }
}
