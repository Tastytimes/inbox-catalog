package com.inbox.foodCatalog.service;

import com.inbox.foodCatalog.dto.CatalogDto;
import com.inbox.foodCatalog.dto.FoodCatalog;
import com.inbox.foodCatalog.dto.RestaurantDto;
import com.inbox.foodCatalog.entity.Catalog;
import com.inbox.foodCatalog.repo.CatalogRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogService {
    @Autowired
    CatalogRepo catalogRepo;

    @Autowired
    RestTemplate restTemplate;

    public CatalogDto addFoodCatalog(Catalog requestMap) {
       Catalog cat = catalogRepo.save(requestMap);
       CatalogDto dto = new CatalogDto();
        boolean veg = cat.isVeg();
       dto.setItemName(cat.getItemName());
       dto.setDescription(cat.getDescription());
       dto.setVeg(veg);
       dto.setPrice(cat.getPrice());
       dto.setRestaurant(cat.getRestaurant());
       dto.setQuantity(cat.getQuantity());
       dto.setId(cat.getId());
       return dto;
    }

    public FoodCatalog fetchItemsByRestaurant(Integer restaurantId) {
        List<Catalog> items = catalogRepo.findByRestaurant(restaurantId);
        RestaurantDto restDto = restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/rest-by-id/" + restaurantId, RestaurantDto.class);
        log.info("items {}", items);
        log.info("rest {}", restDto);
        FoodCatalog foods = new FoodCatalog();
        List<Catalog> newList = new ArrayList<>();
        newList.addAll(items);
//        for(Catalog cat: items) {
//            newList.add(cat);
//        }
        foods.setRestaurant(restDto);
        foods.setFoodItems(newList);
        return foods;
    }
}
