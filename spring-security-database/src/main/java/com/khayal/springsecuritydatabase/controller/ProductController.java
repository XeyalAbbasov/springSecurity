package com.khayal.springsecuritydatabase.controller;

import com.khayal.springsecuritydatabase.model.Product;
import com.khayal.springsecuritydatabase.model.UserInfo;
import com.khayal.springsecuritydatabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController{

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome to Main page";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Product>  getProductById(@PathVariable Integer id){

        return productService.getProductById(id);
    }
}
