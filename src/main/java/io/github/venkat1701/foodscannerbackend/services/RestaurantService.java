package io.github.venkat1701.foodscannerbackend.services;

import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.model.Food;
import io.github.venkat1701.foodscannerbackend.model.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    Map<String, List<RestaurantDTO>> getRestaurantsAvailable();

    List<RestaurantDTO> getRestaurantsWithName(String name);

    List<Food> getFoodDetailsByRestaurant(Restaurant restaurant);

}
