package io.github.venkat1701.foodscannerbackend.gson.deserializer;

import io.github.venkat1701.foodscannerbackend.model.Restaurant;

import java.util.List;

public interface Deserializer<T> {

    List<T> deserialize(String jsonData);

    List<Restaurant> deserialize(String jsonData, String restaurantName);
}
