package com.mingeso.backend.repositories;

import com.mingeso.backend.models.Product;
import java.util.List;

public interface ProductRepository {
    public Product createProduct(Product ProductNew);
    public List<Product> getAllProducts();
    public List<Product> getProductByCode(Long code);
    public Boolean deleteProduct(Long code);

}