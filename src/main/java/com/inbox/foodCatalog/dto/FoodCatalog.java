package com.inbox.foodCatalog.dto;

import com.inbox.foodCatalog.entity.Catalog;
import lombok.Data;

import java.util.List;

@Data
public class FoodCatalog {

    private List<Catalog> foodItems;

    private RestaurantDto restaurant;
}
