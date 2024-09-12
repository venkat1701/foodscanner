package io.github.venkat1701.foodscannerbackend.services.implementations;

import io.github.venkat1701.foodscannerbackend.configurations.RestTemplateInstance;
import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import io.github.venkat1701.foodscannerbackend.model.Food;
import io.github.venkat1701.foodscannerbackend.model.Restaurant;
import io.github.venkat1701.foodscannerbackend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestTemplateInstance restTemplateInstance;

    @Autowired
    public RestaurantServiceImpl(RestTemplateInstance restTemplateInstance) {
        this.restTemplateInstance = restTemplateInstance;
    }

    /**
     * Retrieves a list of all Swiggy restaurants.
     *
     * @return a list of Swiggy restaurants
     */
    @Async
    public CompletableFuture<List<RestaurantDTO>> getSwiggyRestaurants() {
        String url = "http://localhost:3000/swiggy";
        ResponseEntity<List<RestaurantDTO>> response = restTemplateInstance.getRestTemplateInstance().exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDTO>>() {});
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Retrieves a list of all Zomato restaurants.
     *
     * @return a list of Zomato restaurants
     */
    @Async
    public CompletableFuture<List<RestaurantDTO>> getZomatoRestaurants() {
        String url = "http://localhost:3000/zomato";
        ResponseEntity<List<RestaurantDTO>> response = restTemplateInstance.getRestTemplateInstance().exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDTO>>() {});
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Retrieves a list of all Food Panda restaurants.
     *
     * @return a list of Food Panda restaurants
     */
    @Async
    public CompletableFuture<List<RestaurantDTO>> getFoodPandaRestaurants() {
        String url = "http://localhost:3000/foodpanda";
        ResponseEntity<List<RestaurantDTO>> response = restTemplateInstance.getRestTemplateInstance().exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDTO>>() {});
        return CompletableFuture.completedFuture(response.getBody());
    }

    /**
     * Retrieves a list of all Zomato restaurants.
     *
     * @return a list of Zomato restaurants
     */
    @Override
    public Map<String, List<RestaurantDTO>> getRestaurantsAvailable() {
        var future1 = getSwiggyRestaurants();
        var future2 = getZomatoRestaurants();
        var future3 = getFoodPandaRestaurants();

        CompletableFuture.allOf(future1, future2, future3).join();
        Map<String, List<RestaurantDTO>> map = new HashMap<>();
        map.put("zomato", future2.join());
        map.put("swiggy", future1.join());
        map.put("foodpanda", future3.join());
        return map;
    }



    /**
     * Retrieves a list of restaurants with the given name.
     *
     * @param name the name of the restaurant
     * @return a list of restaurants with the given name
     */
    @Override
    public List<RestaurantDTO> getRestaurantsWithName(String name) {
        String url = "http://localhost:3000/"+name;

        ResponseEntity<List<RestaurantDTO>> response = restTemplateInstance.getRestTemplateInstance()
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDTO>>() {});

        return response.getBody();
    }

    /**
     * Retrieves a list of food items available at a given restaurant.
     *
     * @param restaurant the restaurant to query
     * @return a list of food items available at the restaurant
     */
    @Override
    public List<Food> getFoodDetailsByRestaurant(Restaurant restaurant) {
        return List.of();
    }
}
