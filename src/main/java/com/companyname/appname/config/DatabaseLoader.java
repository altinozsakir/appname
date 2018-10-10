package com.companyname.appname.config;

import com.companyname.appname.entity.City;
import com.companyname.appname.entity.Role;
import com.companyname.appname.entity.User;
import com.companyname.appname.repository.CityRepository;
import com.companyname.appname.repository.RoleRepository;
import com.companyname.appname.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CityRepository cityRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository, RoleRepository roleRepository, CityRepository cityRepository){
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Stream.of("Istanbul","Izmir","Denizli","Çorum").forEach(name -> cityRepository.save(new City(name)));

        Role role = new Role("ADMIN");
        roleRepository.save(role);
        Set Roles = new HashSet<Role>();
        Roles.add(role);
        User user = new User("admin","admin","springadmin","springadmin@gmail.com","6_h5077hks");
        user.setRoles(Roles);
        userRepository.save(user);


    }

}
