package io.github.venkat1701.foodscannerbackend.controllers;

import io.github.venkat1701.foodscannerbackend.comparator.RestaurantComparator;
import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class RestaurantComparatorController {
    private RestaurantComparator restaurantComparator;


    public RestaurantComparatorController(RestaurantComparator restaurantComparator) {
        this.restaurantComparator = restaurantComparator;
    }

    @GetMapping(value="/{plafName}/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RestaurantDTO>> getSortedRestaurants(@PathVariable String plafName) throws ExecutionException, InterruptedException {
        return restaurantComparator.compareRestaurantsByPrice(plafName);
    }
}
