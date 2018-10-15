package com.companyname.appname.service;

import com.companyname.appname.entity.City;
import com.companyname.appname.entity.User;
import com.companyname.appname.repository.CityRepository;
import com.companyname.appname.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection<City> findAll(){
        return cityRepository.findAll();
    }

    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }

    public City createCity(City city){

        city.setCreatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());
        city.setUpdatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());
        return cityRepository.save(city);
    }

    public City updateCity(City city){

        city.setUpdatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());
        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }
}
