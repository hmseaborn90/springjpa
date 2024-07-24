package org.springjpa.springjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springjpa.springjpa.entities.City;
import org.springjpa.springjpa.pojos.CityRequest;
import org.springjpa.springjpa.services.CityService;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    CityService cityService;

    @GetMapping("sayhello")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("getcities")
    public List<City> getCities(){
        return  cityService.getCities();
    }

    @PostMapping("addcity")
    @ResponseStatus(HttpStatus.CREATED)
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @GetMapping("getcity")
    public City getCity(String cityName){
        return cityService.getCity(cityName);
    }

    @PostMapping("savecity")
    public City addCity(@RequestBody CityRequest cityRequest){
        return cityService.addCity(cityRequest);
    }
}
