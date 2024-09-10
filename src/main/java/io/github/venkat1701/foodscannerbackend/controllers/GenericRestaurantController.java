package io.github.venkat1701.foodscannerbackend.controllers;

import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.services.implementations.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenericRestaurantController {

    private RestaurantServiceImpl restaurantServiceImpl;

    @Autowired
    public GenericRestaurantController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }


    /**
     * Retrieves a list of all Zomato restaurants.
     *
     * @return a list of Zomato restaurants
     */
    @GetMapping("/")
    public List<RestaurantDTO> getRestaurants() {
        return restaurantServiceImpl.getRestaurantsAvailable();
    }


    /**
     * Retrieves a list of restaurants from a given platform.
     *
     * @param plafName the name of the platform
     * @return a list of restaurants
     */
    @GetMapping("/{plafName}")
    public List<RestaurantDTO> getRestaurantsByPlatform(@PathVariable String plafName) {
        return restaurantServiceImpl.getRestaurantsWithName(plafName);
    }
}
