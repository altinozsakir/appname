package com.companyname.appname.controller;


import com.companyname.appname.entity.Product;
import com.companyname.appname.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<Product> getAllProduct(){
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @JsonIgnore
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) throws URISyntaxException {
        logger.info("Request to create Product {}", product);
        Product result = productService.createProduct(product);
        return ResponseEntity.created(new URI("/api/products/" + result.getId())).body(result);
    }

    @JsonIgnore
    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @Valid @RequestBody Product product) {
        product.setId(id);
        logger.info("Request to update Product {}", product);
        Product result = productService.updateProduct(product);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public ResponseEntity<Product> deleteProduct(@RequestBody long id) {
        logger.info("Request to delete Product {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
