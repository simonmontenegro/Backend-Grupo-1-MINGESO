package com.mingeso.backend.repositories;

import com.mingeso.backend.models.Product;
import java.util.List;

public interface ProductRepository {
    Product createProduct(Product ProductNew);
    List<Product> getAllProducts();
    List<Product> getProductByCode(Long code);
    Boolean deleteProduct(Long code);
    Long lastCode();

}