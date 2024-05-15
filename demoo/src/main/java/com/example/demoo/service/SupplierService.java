package com.example.demoo.service;

import com.example.demoo.controller.Valid;
import com.example.demoo.entity.Customer;
import com.example.demoo.repository.SupplierRepository;
import com.example.demoo.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class SupplierService implements SupplierServiceInterface{
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    // ______________________________________________________________________________________________________
    @Override
    public Optional<Supplier> getSupplierById(int id) {
        return supplierRepository.findById(id);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addSupplier(Supplier newSupplier) {
        supplierRepository.save(newSupplier);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateSupplier(Supplier updatedSupplier) {
        Optional<Supplier> suppliers = supplierRepository.findById(updatedSupplier.getId());

        if (suppliers.isPresent()) {
            Supplier supplier = suppliers.get();

            supplier.setName(updatedSupplier.getName());
            supplier.setAddress(updatedSupplier.getAddress());
            supplier.setEmail(updatedSupplier.getEmail());
            supplier.setPhone(updatedSupplier.getPhone());

            supplierRepository.save(supplier);
        } else
            throw new RuntimeException("Sorry, this supplier doesn't exist");
    }
    // ______________________________________________________________________________________________________
    public void updateSupplierPartially(Supplier updatedSupplier) {
        Optional<Supplier> existingSupplierOptional = supplierRepository.findById(updatedSupplier.getId());

        if (existingSupplierOptional.isPresent()) {
            Supplier supplier = existingSupplierOptional.get();

            if (updatedSupplier.getName() != null)
                supplier.setName(updatedSupplier.getName());
            if (updatedSupplier.getAddress() != null)
                supplier.setAddress(updatedSupplier.getAddress());
            if (updatedSupplier.getEmail() != null)
                supplier.setEmail(updatedSupplier.getEmail());
            if (updatedSupplier.getPhone() != null)
                supplier.setPhone(updatedSupplier.getPhone());
            supplierRepository.save(supplier);
        }
        else
            throw new RuntimeException("Sorry, this supplier doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteSupplier(int id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent())
            supplierRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
    }
}