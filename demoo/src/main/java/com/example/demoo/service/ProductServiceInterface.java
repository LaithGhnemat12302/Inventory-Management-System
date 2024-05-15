package com.example.demoo.service;

import com.example.demoo.entity.Product;
import com.example.demoo.entity.ProductDTO;

import java.util.List;
// __________________________________________________________________________________________________________
public interface ProductServiceInterface {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int id);

    void addProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void updateProductPartially(ProductDTO productDTO);

    void deleteProduct(int id);
}
