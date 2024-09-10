package io.github.venkat1701.foodscannerbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantsDTO {
    @JsonProperty("restaurants")
    private List<RestaurantDTO> restaurants;
}
