package com.cognizant.foodapp.FoodService.services;

import java.util.List;
import java.util.Optional;

import com.cognizant.foodapp.FoodService.entities.FoodItems;

public interface FoodServices {
	FoodItems AddFoodItem(FoodItems foodItems);
	List<FoodItems> getAllFoodItems();
	List<FoodItems> getAllByFoodNames(String foodName);
	List<FoodItems> getAllByRestaurantName(String restaurantName);

}
