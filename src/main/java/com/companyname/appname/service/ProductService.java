package com.companyname.appname.service;

import com.companyname.appname.entity.Category;
import com.companyname.appname.entity.Product;
import com.companyname.appname.repository.ProductRepository;
import com.companyname.appname.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Optional<Product> findProductByCategories(long id) {
        return productRepository.findProductByCategories(id);
    }

    public Product createProduct(Product product) {
        // user authentication
        product.setCreatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());
        product.setUpdatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());

        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        // user authentication

        product.setUpdatedBy(userRepository.findByEmail("springadmin@gmail.com").get().getId());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
