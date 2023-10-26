package com.inbox.foodCatalog.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private Integer id;
    private String name;
    private String city;
    private String description;
}
