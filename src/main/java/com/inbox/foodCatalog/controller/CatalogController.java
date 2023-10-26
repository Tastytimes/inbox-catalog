package com.inbox.foodCatalog.controller;

import com.inbox.foodCatalog.dto.CatalogDto;
import com.inbox.foodCatalog.dto.FoodCatalog;
import com.inbox.foodCatalog.entity.Catalog;
import com.inbox.foodCatalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @PostMapping("/add-food")
    public ResponseEntity<CatalogDto> addCatalog(@RequestBody Catalog requestMap){
        CatalogDto dto = catalogService.addFoodCatalog(requestMap);
        return new ResponseEntity<CatalogDto>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/get-food-items")
    public ResponseEntity<FoodCatalog> getFoodItemsByRest(@RequestParam Integer restaurantId){
        FoodCatalog catalog = catalogService.fetchItemsByRestaurant(restaurantId);
        return new ResponseEntity<FoodCatalog>(catalog, HttpStatus.OK);
//        return new ResponseEntity<FoodCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
