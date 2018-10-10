package com.companyname.appname.repository;

import com.companyname.appname.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CityRepository extends JpaRepository<City,Long> {

    Optional<City> findById(Long id);
}
