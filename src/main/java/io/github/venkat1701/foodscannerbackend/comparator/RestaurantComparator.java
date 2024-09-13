package io.github.venkat1701.foodscannerbackend.comparator;

import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.model.Locality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantComparator {

    ResponseEntity<List<RestaurantDTO>> compareRestaurantsByPrice(String platformName);

    ResponseEntity<List<RestaurantDTO>> compareRestaurantsByRating(String platformName);

    ResponseEntity<List<RestaurantDTO>> compareRestaurantByLocality(Locality locality);


}
