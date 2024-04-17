package com.example.demoo.controller;

import com.example.demoo.entity.Product;
import com.example.demoo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// __________________________________________________________________________________________________________
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        Product product = productService.getProductById(id);
        if(product == null)
            throw new RuntimeException("The product with the id " + id + " doesn't exist");
        return product;
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
