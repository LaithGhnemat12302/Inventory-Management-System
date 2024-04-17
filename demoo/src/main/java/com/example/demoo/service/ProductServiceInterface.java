package com.example.demoo.service;

import com.example.demoo.entity.Product;
import java.util.List;
// __________________________________________________________________________________________________________
public interface ProductServiceInterface {
    List<Product> getAllProducts();

    Product getProductById(long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long id);
}
