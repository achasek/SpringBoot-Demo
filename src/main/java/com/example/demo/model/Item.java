package com.example.demo.model;

import jakarta.persistence.*;

// https://projectlombok.org/features/Data
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// the Entity annotation states that instantiations of this class should persist in the DataBase
@Entity
public class Item {
    // convention is private variables, but public constructors so other classes can construct instances of Item
    // lombok handles the public constructor methods tho, so we won't be seeing that here

    // ID annotation states this as the Primary Key of an entity
    // GeneratedValue annotation says that ID will be generated upon instantiation of this class by the DB (h2)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String image;
    private String sampleSensitiveInfo;

    // however, if we were not using lombok, setter and getters would look like this, and there would be a setter and getter for each key in the entity
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
}
