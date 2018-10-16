package com.companyname.appname.repository;

import com.companyname.appname.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



public interface ProductRepository extends JpaRepository<Product, Long> {

	 Optional<Product> findProductByCategories(Long categoryId);
	 Optional<Product> findById(Long id);
	 Optional<Product> findByName(String name);

}
