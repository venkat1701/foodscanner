package io.github.venkat1701.foodscannerbackend.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    private long foodId;
    private String foodName;
    private double foodPrice;
    private List<Combo> foodCombos;
}
