package com.khayal.springsecuritydatabase.service;

import com.khayal.springsecuritydatabase.model.Product;
import com.khayal.springsecuritydatabase.model.UserInfo;
import com.khayal.springsecuritydatabase.repository.ProductRepository;
import com.khayal.springsecuritydatabase.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private ProductRepository productRepository;

            public List<Product> getAllProducts(){

            return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){

        return productRepository.findById(id);
    }

}
