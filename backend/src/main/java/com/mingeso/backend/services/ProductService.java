package com.mingeso.backend.services;

import com.mingeso.backend.models.Product;
import com.mingeso.backend.repositories.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin
@RestController
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product productNew){
        return productRepository.createProduct(productNew);
    }

    @GetMapping("/allproducts")
    public String getAllProducts() {
        return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //return productRepository.getAllProducts();
    }
    @GetMapping("/product/{code}")
    public List<Product> getProductByCode(@PathVariable Long code) {
        return productRepository.getProductByCode(code);
    }

    @DeleteMapping("/deleteproduct/{code}")
    public boolean deleteProduct(@PathVariable Long code){
        return productRepository.deleteProduct(code);
    }
}