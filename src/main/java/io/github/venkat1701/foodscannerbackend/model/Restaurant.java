package io.github.venkat1701.foodscannerbackend.model;

import lombok.Data;

import java.util.List;


@Data
public class Restaurant {
    private String restaurantName;
    private long restaurantID;
    private String restaurantAddress;
    private double restaurantRatings;
    private long restaurantContactNumber;
    private String restaurantTimings;
    private int restaurantCostForTwo;
    private List<String> restaurantOffers;
    private String restaurantUrl;
}
