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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestTemplateInstance restTemplateInstance;

    @Autowired
    public RestaurantServiceImpl(RestTemplateInstance restTemplateInstance) {
        this.restTemplateInstance = restTemplateInstance;
    }

    /**
     * Retrieves a list of all Zomato restaurants.
     *
     * @return a list of Zomato restaurants
     */
    @Override
    public List<RestaurantDTO> getRestaurantsAvailable() {
        String url = "http://localhost:3000/zomato";
        ResponseEntity<List<RestaurantDTO>> response = restTemplateInstance.getRestTemplateInstance()
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDTO>>() {});

        return response.getBody();
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
