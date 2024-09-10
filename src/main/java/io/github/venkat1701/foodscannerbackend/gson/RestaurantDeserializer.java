package io.github.venkat1701.foodscannerbackend.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.venkat1701.foodscannerbackend.gson.deserializer.Deserializer;
import io.github.venkat1701.foodscannerbackend.model.Restaurant;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantDeserializer implements Deserializer<Restaurant> {

    private static final Gson gson = new Gson();

    /**
     * Maps a given JSON object to a Restaurant object.
     * <p>
     * The JSON object is expected to have the following fields:
     * <ul>
     * <li>{@code Restaurant_Name}: the name of the restaurant
     * <li>{@code URL}: the URL of the restaurant
     * <li>{@code Address}: the address of the restaurant
     * <li>{@code Star_Rating}: the rating of the restaurant
     * <li>{@code Phone_Number}: the phone number of the restaurant
     * <li>{@code Cost_for_two}: the cost for two people at the restaurant
     * <li>{@code Offer}: the offers provided by the restaurant
     * </ul>
     *
     * @param map the JSON object
     * @return the Restaurant object
     */
    private static Restaurant mapToRestaurant(Map<String, Object> map) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName((String) map.get("Restaurant_Name"));
        restaurant.setRestaurantUrl((String) map.get("URL"));
        restaurant.setRestaurantAddress((String) map.get("Address"));
        restaurant.setRestaurantRatings(Double.parseDouble(String.valueOf(map.get("Star_Rating"))));
        restaurant.setRestaurantContactNumber(parsePhoneNumber((String) map.get("Phone_Number")));
        restaurant.setRestaurantCostForTwo(((Number) map.get("Cost_for_two")).intValue());
        restaurant.setRestaurantOffers(List.of((String)map.get("Offer")));
        return restaurant;
    }

    /**
     * Parses a given phone number string and returns its numeric value.
     * <p>
     * The parsing is done by removing all non-digit characters from the string and then
     * converting the remaining characters to a long.
     * @param phoneNumber the phone number to parse
     * @return the numeric value of the phone number
     */
    private static long parsePhoneNumber(String phoneNumber) {
        return Long.parseLong(phoneNumber.replaceAll("[^\\d]", ""));
    }

    /**
     * Deserializes a given JSON string into a list of Restaurant objects.
     * <p>
     * The JSON string is expected to be a map where the key is the name of the restaurant
     * and the value is a list of JSON objects representing the restaurant.
     * <p>
     * The JSON object is expected to have the following fields:
     * <ul>
     * <li>{@code Restaurant_Name}: the name of the restaurant
     * <li>{@code URL}: the URL of the restaurant
     * <li>{@code Address}: the address of the restaurant
     * <li>{@code Star_Rating}: the rating of the restaurant
     * <li>{@code Phone_Number}: the phone number of the restaurant
     * <li>{@code Cost_for_two}: the cost for two people at the restaurant
     * <li>{@code Offer}: the offers provided by the restaurant
     * </ul>
     *
     * @param jsonData the JSON string to deserialize
     * @return the list of Restaurant objects
     */
    @Override
    public List<Restaurant> deserialize(String jsonData) {
        Type restaurantType = new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType();
        Map<String, List<Map<String, Object>>> restaurantMap = gson.fromJson(jsonData, restaurantType);
        return restaurantMap.values().stream().map(maps -> mapToRestaurant(maps.get(0))).toList();
    }

    /**
     * Deserializes a given JSON string into a list of Restaurant objects.
     * <p>
     * The JSON string is expected to be a map where the key is the name of the restaurant
     * and the value is a list of JSON objects representing the restaurant.
     * <p>
     * The JSON object is expected to have the following fields:
     * <ul>
     * <li>{@code Restaurant_Name}: the name of the restaurant
     * <li>{@code URL}: the URL of the restaurant
     * <li>{@code Address}: the address of the restaurant
     * <li>{@code Star_Rating}: the rating of the restaurant
     * <li>{@code Phone_Number}: the phone number of the restaurant
     * <li>{@code Cost_for_two}: the cost for two people at the restaurant
     * <li>{@code Offer}: the offers provided by the restaurant
     * </ul>
     *
     * @param jsonData the JSON string to deserialize
     * @param restaurantName the name of the restaurant to fetch
     * @return the list of Restaurant objects
     */
    @Override
    public List<Restaurant> deserialize(String jsonData, String restaurantName) {
        Type listType = new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType();
        Map<String, List<Map<String, Object>>> restaurantMap = gson.fromJson(jsonData, listType);
        return restaurantMap.get(restaurantName).stream().map(RestaurantDeserializer::mapToRestaurant).toList();
    }
}
