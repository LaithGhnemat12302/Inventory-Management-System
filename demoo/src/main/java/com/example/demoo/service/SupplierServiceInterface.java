package com.example.demoo.service;

import com.example.demoo.entity.Supplier;
import java.util.List;
// __________________________________________________________________________________________________________
public interface SupplierServiceInterface {
    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(long id);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSupplier(long id);
}
