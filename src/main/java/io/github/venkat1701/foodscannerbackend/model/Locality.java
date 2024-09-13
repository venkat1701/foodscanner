package io.github.venkat1701.foodscannerbackend.model;

import io.github.venkat1701.foodscannerbackend.utility.Pair;
import lombok.Data;

@Data
public class Locality {

    private String name;
    private String address;
    private String city;
    private String state;
    private Pair coordinates;
}
