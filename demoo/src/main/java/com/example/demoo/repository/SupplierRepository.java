package com.example.demoo.repository;

import com.example.demoo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** Spring recognize repositories by the fact that they extend one of the predefined Repository interfaces.
 JpaRepository has full API CrudRepository and PagingAndSortingRepository. So, basically, JpaRepository
 contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.*/
// __________________________________________________________________________________________________________
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
