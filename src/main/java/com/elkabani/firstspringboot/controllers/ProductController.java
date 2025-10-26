package com.elkabani.firstspringboot.controllers;


import com.elkabani.firstspringboot.dtos.ProductDto;
import com.elkabani.firstspringboot.mappers.ProductMapper;
import com.elkabani.firstspringboot.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.elkabani.firstspringboot.services.ProductService;
import com.elkabani.firstspringboot.entities.Product;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @GetMapping("/products")
    public List<ProductDto> getAllProducts(@RequestParam(name="categoryID",required = false)  int categoryId)
    {
        List<Product> products;
        if( categoryId !=0){
            products = productRepository.findByCategoryID(categoryId);
        }else{
            products = productRepository.findAll();
        }
        return products.stream().map(product -> productMapper.toDto(product)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
    {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        var createdProductDto = productMapper.toDto(product);
        return ResponseEntity.ok(createdProductDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,
                                                  @RequestBody ProductDto productDto)
    {
        var existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }
        productMapper.update(productDto, existingProduct);
        productRepository.save(existingProduct);
        var updatedProductDto = productMapper.toDto(existingProduct);
        return ResponseEntity.ok(updatedProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }


}
