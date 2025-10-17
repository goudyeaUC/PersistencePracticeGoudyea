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
        System.out.println("saving category" + category.getName());
        return categoryRepository.save(category);

    }

    @Transactional
    public Product createProductInNewCategory(Product product, Category category)
    { categoryRepository.save(category);
        product.setCategory(category);
        System.out.println("saving product" + product.getName() + " in category " + category.getName());
        return productRepository.save(product);

    }

    @Transactional
    public Product createProductInExistingCategory(Product product, Category category) {
        product.setCategory(category);
        System.out.println("saving product" + product.getName() + " in category " + category.getName());
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        System.out.println("deleting product with id " + productId);
        productRepository.deleteById(productId);
    }
}
