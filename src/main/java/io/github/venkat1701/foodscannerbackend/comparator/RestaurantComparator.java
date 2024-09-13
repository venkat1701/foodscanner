package io.github.venkat1701.foodscannerbackend.comparator;

import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.model.Locality;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface RestaurantComparator {

    ResponseEntity<List<RestaurantDTO>> compareRestaurantsByPrice(String platformName) throws ExecutionException, InterruptedException;

    ResponseEntity<List<RestaurantDTO>> compareRestaurantsByRating(String platformName) throws ExecutionException, InterruptedException;

    ResponseEntity<List<RestaurantDTO>> compareRestaurantByLocality(Locality locality);


}
