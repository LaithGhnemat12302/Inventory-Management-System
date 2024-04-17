package com.example.demoo.controller;

import com.example.demoo.entity.Supplier;
import com.example.demoo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// __________________________________________________________________________________________________________
@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        if(supplier == null)
            throw new RuntimeException("The supplier with the id " + id + " doesn't exist");
        return supplier;
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/")
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/")
    public void updateSupplier(@RequestBody Supplier supplier) {
        supplierService.updateSupplier(supplier);
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable long id) {
        supplierService.deleteSupplier(id);
    }
}
