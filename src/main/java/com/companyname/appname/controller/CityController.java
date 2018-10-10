package com.companyname.appname.controller;


import com.companyname.appname.entity.City;
import com.companyname.appname.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {

    private final Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET, value = "/cities")
    public Collection<City> getAllCity(){
        return cityService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities/{id}")
    public ResponseEntity<?> getCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        return city.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cities")
    public ResponseEntity<City> createCity(@Valid @RequestBody City city) throws URISyntaxException {
        logger.info("Request to create city: {}", city);
        City result = cityService.createCity(city);
        return ResponseEntity.created(new URI("/api/cities/" + result.getId())).body(result);
    }

    @RequestMapping(method=RequestMethod.PUT,value = "/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @Valid @RequestBody City city){
        city.setId(id);
        logger.info("Request to update city : {}",city);
        City result = cityService.updateCity(city);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/cities/{id}")
    public ResponseEntity<?> deleteProduct(@RequestBody Long id){
        logger.info("Request to delete city: {}",id);
        cityService.deleteCity(id);
        return ResponseEntity.ok().build();
    }



}
