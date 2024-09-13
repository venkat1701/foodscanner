package io.github.venkat1701.foodscannerbackend.comparator.implementations;

import io.github.venkat1701.foodscannerbackend.comparator.RestaurantComparator;
import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.model.Locality;
import io.github.venkat1701.foodscannerbackend.services.RestaurantService;
import io.github.venkat1701.foodscannerbackend.services.implementations.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class RestaurantComparatorImpl implements RestaurantComparator {

    private RestaurantService restaurantService;


    public RestaurantComparatorImpl(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public ResponseEntity<List<RestaurantDTO>> compareRestaurantsByPrice(String platformName) throws ExecutionException, InterruptedException {
        List<RestaurantDTO> restaurants = fetchRestaurantsByPlatform(platformName);
        if (restaurants == null) {
            return ResponseEntity.badRequest().build();  // Handle null scenario
        }

        List<RestaurantDTO> sortedRestaurants = restaurants.stream()
                .sorted(Comparator.comparingInt(RestaurantDTO::getCostForTwo))
                .collect(Collectors.toList());

        return ResponseEntity.ok(sortedRestaurants);
    }

    @Override
    public ResponseEntity<List<RestaurantDTO>> compareRestaurantsByRating(String platformName) throws ExecutionException, InterruptedException {
        List<RestaurantDTO> restaurants = fetchRestaurantsByPlatform(platformName);
        if (restaurants == null) {
            return ResponseEntity.badRequest().build();  // Handle null scenario
        }

        List<RestaurantDTO> sortedRestaurants = restaurants.stream()
                .sorted(Comparator.comparingDouble(RestaurantDTO::getStarRating).reversed())  // Sorted by rating in descending order
                .collect(Collectors.toList());

        return ResponseEntity.ok(sortedRestaurants);
    }

    @Override
    public ResponseEntity<List<RestaurantDTO>> compareRestaurantByLocality(Locality locality) {

        return ResponseEntity.ok(null);
    }

    private List<RestaurantDTO> fetchRestaurantsByPlatform(String platformName) throws ExecutionException, InterruptedException {
        if ("swiggy".equalsIgnoreCase(platformName)) {
            return restaurantService.getRestaurantsWithName("swiggy");
        }

        return null;
    }
}
