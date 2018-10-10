package com.companyname.appname.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="cities")
public class City extends UserBaseEntity {
    @NotBlank
    @Size(max=40)
    private String name;

    public City(){

    }
    public City(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
