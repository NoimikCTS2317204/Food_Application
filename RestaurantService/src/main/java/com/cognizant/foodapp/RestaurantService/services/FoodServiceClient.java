package com.cognizant.foodapp.RestaurantService.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.foodapp.RestaurantService.entity.FoodItems;





@FeignClient(url="http://localhost:8082", value="FoodService-Client")
public interface FoodServiceClient {

    @GetMapping("/api/foodService/restaurant/{restaurantName}")
    List<FoodItems> getAllFoodItems(@PathVariable("restaurantName") String restaurantName);
}

