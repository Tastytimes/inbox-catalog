package com.inbox.foodCatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private String description;
    private boolean veg;
    private Integer price;
    private Integer restaurant;
    private Integer quantity;

//    public boolean isVeg() { // Rename the getter method
//        return veg;
//    }
}
