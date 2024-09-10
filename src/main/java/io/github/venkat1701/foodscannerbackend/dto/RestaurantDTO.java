package io.github.venkat1701.foodscannerbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RestaurantDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("Restaurant_Name")
    private String restaurantName;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("City")
    private String city;

    @JsonProperty("Star_Rating")
    private double starRating;

    @JsonProperty("Cuisines")
    private String cuisines;

    @JsonProperty("Phone_Number")
    private String phoneNumber;

    @JsonProperty("Offer")
    private String offer;

    @JsonProperty("Cost_for_two")
    private int costForTwo;
}
