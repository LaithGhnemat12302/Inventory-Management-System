// This is the order entity that represents a table stored in the database.
package com.example.demoo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
// __________________________________________________________________________________________________________
@Data   /** Generates getters and setters for all fields, a useful toString method, and hashCode and equals
implementations that check all non-transient fields.*/

@AllArgsConstructor // Automatically generates a constructor with a parameter for each field in this class.
@NoArgsConstructor  // Generates a constructor with no parameter.
@Entity     // Specifies that this class is an entity and is mapped to a database table.

// Allows to specify the details of the table that will be used to persist the entity in the database.
@Table(name = "Order")
@Builder
// __________________________________________________________________________________________________________
public class Order {
    @Id     // Declare the primary key.

    /** Indicates that the persistence provider must assign primary keys for the entity using a database
    identity column.This means they are auto-incremented.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "total_cost", nullable = false)
    private double totalCost;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
