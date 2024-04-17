package com.example.demoo.service;

import com.example.demoo.repository.SupplierRepository;
import com.example.demoo.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Supplier getSupplierById(long id) {
        Optional<Supplier> suppliers = supplierRepository.findById(id);
        if(suppliers.isPresent())
            return suppliers.get();
        else
            throw new RuntimeException("Sorry, this supplier doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addSupplier(Supplier newSupplier) {
        Optional<Supplier> suppliers = supplierRepository.findById(newSupplier.getId());
        if (suppliers.isPresent())
            throw new RuntimeException("Sorry, the supplier with this id already exists");
        else
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
    @Override
    public void deleteSupplier(long id) {
        supplierRepository.deleteById(id);
    }
}
