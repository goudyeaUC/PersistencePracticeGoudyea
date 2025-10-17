package com.elkabani.firstspringboot.services;

import com.elkabani.firstspringboot.entities.Product;
import com.elkabani.firstspringboot.entities.Category;
import com.elkabani.firstspringboot.repositories.CategoryRepository;
import com.elkabani.firstspringboot.repositories.ProductRepository;
import com.elkabani.firstspringboot.repositories.ProfileRepository;
import com.elkabani.firstspringboot.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Console;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    @Transactional
    public Category createCategory(Category category) {

        return categoryRepository.save(category);

    }


}
