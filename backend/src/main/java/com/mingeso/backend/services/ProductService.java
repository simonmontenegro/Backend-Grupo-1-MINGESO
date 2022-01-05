package com.mingeso.backend.services;

import com.mingeso.backend.models.*;
import com.mingeso.backend.repositories.*;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@ComponentScan
@CrossOrigin(origins = "*")
@RestController
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product/")
    public Product createProduct(@RequestBody Product productNew){
        return productRepository.createProduct(productNew);
    }

    @GetMapping("/allProducts/")
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/product/{code}")
    public List<Product> getAllProducts(@PathVariable Long code) {
        return productRepository.getProductByCode(code);
    }

    @DeleteMapping("/product/{code}")
    public boolean deleteProduct(@PathVariable Long code){
        return productRepository.deleteProduct(code);
    }
}