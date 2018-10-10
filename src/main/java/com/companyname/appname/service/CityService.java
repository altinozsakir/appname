package com.companyname.appname.service;

import com.companyname.appname.entity.City;
import com.companyname.appname.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Collection<City> findAll(){
        return cityRepository.findAll();
    }

    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }

    public City createCity(City city){

        return cityRepository.save(city);
    }

    public City updateCity(City city){
        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }
}
