package com.example.demoo.controller;

import com.example.demoo.entity.Product;
import com.example.demoo.entity.ProductDTO;
import com.example.demoo.entity.Supplier;
import com.example.demoo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        productService.updateProduct(productDTO);
    }
    // ______________________________________________________________________________________________________
    @PatchMapping("/updateProduct/{id}")
    public void updateProductPartially(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        productService.updateProductPartially(productDTO);
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
