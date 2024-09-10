package io.github.venkat1701.foodscannerbackend.gson;

import com.google.gson.Gson;
import io.github.venkat1701.foodscannerbackend.gson.deserializer.Deserializer;
import io.github.venkat1701.foodscannerbackend.model.Food;
import io.github.venkat1701.foodscannerbackend.model.Restaurant;

import java.util.List;

public class FoodDeserializer implements Deserializer<Food> {
    private static final Gson gson = new Gson();

    @Override
    public List<Food> deserialize(String jsonData) {
        return List.of();
    }

    @Override
    public List<Restaurant> deserialize(String jsonData, String restaurantName) {
        return List.of();
    }
}
