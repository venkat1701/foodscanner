package io.github.venkat1701.foodscannerbackend.deserializer;

import io.github.venkat1701.foodscannerbackend.gson.RestaurantDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
public class RestaurantDeserializerTest {

    @Autowired
    private RestaurantDeserializer restaurantDeserializer;


    @Test
    public void givenJson_whenDeserialized_thenCheck_forSwiggy() throws Exception{
        String jsonData = new String(Files.readAllBytes(Paths.get("C:\\Users\\krish\\Projects\\foodscannerbackend\\src\\main\\resources\\dummy_data.json")));
        System.out.println(restaurantDeserializer.deserialize(jsonData));
    }
}
