package com.example.demoo.service;

import com.example.demoo.entity.Supplier;
import com.example.demoo.repository.ProductRepository;
import com.example.demoo.entity.Product;
import com.example.demoo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class ProductService implements ProductServiceInterface{
    private final ProductRepository productRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // ______________________________________________________________________________________________________
    @Override
    public Product getProductById(long id) {
        Optional<Product> products = productRepository.findById(id);
        if(products.isPresent())
            return products.get();
        else
            throw new RuntimeException("Sorry, this product doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addProduct(Product newProduct) {
        Optional<Product> products = productRepository.findById(newProduct.getId());
        if (products.isPresent())
            throw new RuntimeException("Sorry, the product with this id already exists");
        else
            productRepository.save(newProduct);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateProduct(Product updatedProduct) {
        Optional<Product> products = productRepository.findById(updatedProduct.getId());

        if (products.isPresent()) {
            Product product = products.get();

            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            product.setProductionDate(updatedProduct.getProductionDate());
            product.setExpirationDate(updatedProduct.getExpirationDate());
            product.setQuantity(updatedProduct.getQuantity());

            Optional<Supplier> suppliers = supplierRepository.findById(updatedProduct.getSupplier().getId());
            if (suppliers.isPresent())
                product.setSupplier(suppliers.get());
            else
                throw new RuntimeException("Invalid supplier is for this product");
            productRepository.save(product);
        } else
            throw new RuntimeException("Sorry, this product doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
