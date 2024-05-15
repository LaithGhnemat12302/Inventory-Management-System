// This is the customer entity that represents a table stored in the database.
package com.example.demoo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

// __________________________________________________________________________________________________________
@Data
/** Generates getters and setters for all fields, a useful toString method, and hashCode and equals
implementations that check all non-transient fields.*/

@AllArgsConstructor // Automatically generates a constructor with a parameter for each field in this class.
@NoArgsConstructor  // Generates a constructor with no parameter.
@Entity     // Specifies that this class is an entity and is mapped to a database table.

// Allows to specify the details of the table that will be used to persist the entity in the database.
@Table(name = "Customer",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
@Builder
// __________________________________________________________________________________________________________
public class Customer {
    @Id     // Declare the primary key.

    /** Indicates that the persistence provider must assign primary keys for the entity using a database
    identity column.This means they are auto-incremented.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "phone")
    private String phone;
}
