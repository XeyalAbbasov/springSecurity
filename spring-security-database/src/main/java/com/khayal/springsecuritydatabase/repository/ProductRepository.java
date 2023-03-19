package com.khayal.springsecuritydatabase.repository;

import com.khayal.springsecuritydatabase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
