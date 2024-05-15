package com.example.demoo.service;

import com.example.demoo.entity.ProductDTO;
import com.example.demoo.entity.Supplier;
import com.example.demoo.repository.ProductRepository;
import com.example.demoo.entity.Product;
import com.example.demoo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class ProductService implements ProductServiceInterface{
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductDTO p = new ProductDTO();
            p.setId(product.getId());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setDescription(product.getDescription());
            p.setProductionDate(product.getProductionDate());
            p.setExpirationDate(product.getExpirationDate());
            p.setQuantity(product.getQuantity());
            p.setSupplierId(product.getSupplier().getId());
            productDTOs.add(p);
        }
        return productDTOs;
    }
    // ______________________________________________________________________________________________________
    @Override
    public ProductDTO getProductById(int id) {
        List<Product> products = productRepository.findAll();

        for(Product product : products){
            if(product.getId() == id) {
                ProductDTO p = new ProductDTO();
                p.setId(product.getId());
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setProductionDate(product.getProductionDate());
                p.setExpirationDate(product.getExpirationDate());
                p.setQuantity(product.getQuantity());
                p.setSupplierId(product.getSupplier().getId());
                return p;
            }
        }
        throw new RuntimeException("Sorry, this product doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addProduct(ProductDTO productDTO) {
        productDTO.setId(productRepository.findTopByOrderByIdDesc().getId() + 1);

        Product newProduct = new Product();
        newProduct.setId(productDTO.getId());
        newProduct.setName(productDTO.getName());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setProductionDate(productDTO.getProductionDate());
        newProduct.setExpirationDate(productDTO.getExpirationDate());
        newProduct.setQuantity(productDTO.getQuantity());

        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        newProduct.setSupplier(supplier);
        productRepository.save(newProduct);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateProduct(ProductDTO productDTO) {
        Optional<Product> products = productRepository.findById(productDTO.getId());

        if (products.isPresent()) {
            Product product = products.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setProductionDate(productDTO.getProductionDate());
            product.setExpirationDate(productDTO.getExpirationDate());
            product.setQuantity(productDTO.getQuantity());

            Optional<Supplier> suppliers = supplierRepository.findById(productDTO.getSupplierId());
            if (suppliers.isPresent()) {
                product.setSupplier(suppliers.get());
                productRepository.save(product);
            }
            else
                throw new RuntimeException("Invalid supplier for this product");
        }
        else
            throw new RuntimeException("Sorry, this product doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateProductPartially(ProductDTO productDTO) {
        Optional<Product> products = productRepository.findById(productDTO.getId());

        if (products.isPresent()) {
            Product product = products.get();
            if(productDTO.getName() != null)
                product.setName(productDTO.getName());
            if(productDTO.getPrice() != 0)
                product.setPrice(productDTO.getPrice());
            if(productDTO.getDescription() != null)
                product.setDescription(productDTO.getDescription());
            if(productDTO.getProductionDate() != null)
                product.setProductionDate(productDTO.getProductionDate());
            if(productDTO.getExpirationDate() != null)
                product.setExpirationDate(productDTO.getExpirationDate());
            if(productDTO.getQuantity() != 0)
                product.setQuantity(productDTO.getQuantity());

            if(productDTO.getSupplierId() != 0) {
                Optional<Supplier> suppliers = supplierRepository.findById(productDTO.getSupplierId());
                if (suppliers.isPresent())
                    product.setSupplier(suppliers.get());
                else
                    throw new RuntimeException("Invalid supplier for this product");
            }
            productRepository.save(product);
        }
        else
            throw new RuntimeException("Sorry, this product doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
