package com.companyname.appname.service;

import com.companyname.appname.entity.City;
import com.companyname.appname.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }

    public City getCityById(Long id){
        return null;
    }

    public void createCity(City city){
        cityRepository.save(city);
    }

    public void updateCity(Long id, City city){
        cityRepository.save(city);
    }

    public void deleteCity(City city){
        cityRepository.delete(city);
    }
}
