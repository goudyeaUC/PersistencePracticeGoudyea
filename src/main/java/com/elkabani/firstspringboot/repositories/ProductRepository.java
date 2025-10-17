package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}