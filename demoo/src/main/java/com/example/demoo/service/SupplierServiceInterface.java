package com.example.demoo.service;

import com.example.demoo.entity.Customer;
import com.example.demoo.entity.Supplier;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

// __________________________________________________________________________________________________________
public interface SupplierServiceInterface {
    List<Supplier> getAllSuppliers();

    Optional<Supplier> getSupplierById(int id);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void updateSupplierPartially(Supplier supplier);

    void deleteSupplier(int id);
}
