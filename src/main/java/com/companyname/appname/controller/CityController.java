package com.companyname.appname.controller;


import com.companyname.appname.entity.City;
import com.companyname.appname.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/cities")
    public List<City> getAllCity(){
        return cityService.getAllCities();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cities")
    public void createCity(@RequestBody City city){
        cityService.createCity(city);
    }

    @RequestMapping(method=RequestMethod.PUT,value = "/cities/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody City city){
        cityService.updateCity(id,city);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/cities/{id}")
    public void deleteProduct(@RequestBody City city){
        cityService.deleteCity(city);
    }



}
