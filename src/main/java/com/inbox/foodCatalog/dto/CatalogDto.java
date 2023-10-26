package com.inbox.foodCatalog.dto;

import lombok.Data;

@Data
public class CatalogDto {

    private Integer id;
    private String itemName;
    private String Description;
    private boolean veg;
    private Number price;
    private Integer restaurant;
    private Integer quantity;

//    public boolean isVeg() { // Rename the getter method
//        return veg;
//    }
}
