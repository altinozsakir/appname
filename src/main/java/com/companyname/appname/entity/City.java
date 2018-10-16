package com.companyname.appname.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="cities")
public class City extends UserBaseEntity {
    @NotBlank
    @Size(min=3, max=50)
    private String name;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="country_id")
    private Country country;

		@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "city")
    private List<County> counties;

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
