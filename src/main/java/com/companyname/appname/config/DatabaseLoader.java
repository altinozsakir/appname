package com.companyname.appname.config;

import com.companyname.appname.entity.*;
import com.companyname.appname.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CityRepository cityRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository, RoleRepository roleRepository, CityRepository cityRepository, ProductRepository productRepository, CategoryRepository categoryRepository){
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception{

        Role role = new Role("ADMIN");
        roleRepository.save(role);
        Set Roles = new HashSet<Role>();
        Roles.add(role);
        User user = new User("springadmin","springadmin@gmail.com","6_h5077hks");
        user.setRoles(Roles);
        userRepository.save(user);


    }

}
