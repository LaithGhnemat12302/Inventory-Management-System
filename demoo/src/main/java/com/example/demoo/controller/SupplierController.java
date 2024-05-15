package com.example.demoo.controller;

import com.example.demoo.entity.Customer;
import com.example.demoo.entity.Supplier;
import com.example.demoo.service.ResourceNotFoundException;
import com.example.demoo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    /**
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        if (suppliers.isEmpty())
            return ResponseEntity.notFound().build(); // Return 404 Not Found if no suppliers are found
        else
            return ResponseEntity.ok(suppliers); // Return 200 OK with the list of suppliers
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        Optional<Supplier> supplierOptional = supplierService.getSupplierById(id);
        if (supplierOptional.isPresent())
            return ResponseEntity.ok(supplierOptional.get()); // Return 200 OK with the supplier if it exists
        else
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the supplier doesn't exist
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/addSupplier")
    public ResponseEntity<Void> addSupplier(@Valid @RequestBody Supplier supplier) {
        if (supplier.getName() != null && supplier.getAddress() != null &&
            supplier.getEmail() != null && supplier.getPhone() != null){
            supplierService.addSupplier(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // Return 201 for successfully created
        }
        else
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity<Void> updateSupplier(@PathVariable int id, @Valid @RequestBody Supplier supplier){
        if (supplier.getName() == null || supplier.getAddress() == null ||
                supplier.getEmail() == null || supplier.getPhone() == null)
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
        else {
            supplier.setId(id);
            try {
                supplierService.updateSupplier(supplier);
                return ResponseEntity.ok().build(); // Return 200 OK for successfully updated
            } catch (RuntimeException e) {
                // Return 404 Not Found if the supplier with the given id does not exist
                return ResponseEntity.notFound().build();
            }
        }
    }
    // ______________________________________________________________________________________________________
//    @PatchMapping("/updateSupplier/{id}")
//    public ResponseEntity<Void> updateSupplierPartially(@PathVariable int id, @RequestBody Supplier supplier) {
//        supplier.setId(id);
//        supplierService.updateSupplierPartially(supplier);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PatchMapping("/updateSupplier/{id}")
    public ResponseEntity<Void> updateSupplierPartially(@PathVariable int id,
                                   @Valid @RequestBody Supplier supplier, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
        else {
            supplier.setId(id);
            try {
                supplierService.updateSupplierPartially(supplier);
                return ResponseEntity.ok().build(); // Return 200 OK for successfully updated
            } catch (RuntimeException e) {
                // Return 404 Not Found if the supplier with the given id does not exist
                return ResponseEntity.notFound().build();
            }
        }
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int id) {
        try {
            supplierService.deleteSupplier(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if supplier doesn't exist
        }
    }
}
