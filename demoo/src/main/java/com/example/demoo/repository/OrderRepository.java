package com.example.demoo.repository;

import com.example.demoo.entity.Orderr;
import com.example.demoo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/** Spring recognize repositories by the fact that they extend one of the predefined Repository interfaces.
 JpaRepository has full API CrudRepository and PagingAndSortingRepository. So, basically, JpaRepository
 contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.*/
// __________________________________________________________________________________________________________
@Repository
public interface OrderRepository extends JpaRepository<Orderr, Integer> {
    @Query("SELECT o FROM Orderr o JOIN FETCH o.customer WHERE o.id = ?1")
    Orderr findOrderById(int id);
    void deleteById(int id);

    Orderr findTopByOrderByIdDesc();
}
