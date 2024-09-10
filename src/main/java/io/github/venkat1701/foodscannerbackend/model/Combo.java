package io.github.venkat1701.foodscannerbackend.model;


import lombok.Data;

@Data
public class Combo {
    private long comboId;
    private String comboName;
    private String comboDescription;
    private int comboPrice;
    private String comboCategory;


}
