package io.github.venkat1701.foodscannerbackend.controllers;

import io.github.venkat1701.foodscannerbackend.comparator.RestaurantComparator;
import io.github.venkat1701.foodscannerbackend.controllers.RestaurantComparatorController;
import io.github.venkat1701.foodscannerbackend.dto.RestaurantDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantComparatorController.class)
public class RestaurantComparatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantComparator restaurantComparator;

    @Test
    void givenJson_whenDeserialized_thenCheck_forSwiggy_isSortedOrNot() throws Exception {
        when(restaurantComparator.compareRestaurantsByPrice("swiggy"))
                .thenReturn(ResponseEntity.ok(Collections.emptyList()));  // returning empty list for now

        mockMvc.perform(get("/swiggy/sorted")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andDo(print());
    }
}
