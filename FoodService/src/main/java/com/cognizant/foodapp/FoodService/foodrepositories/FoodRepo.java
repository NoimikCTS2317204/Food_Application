package com.cognizant.foodapp.FoodService.foodrepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.foodapp.FoodService.entities.FoodItems;


public interface FoodRepo extends JpaRepository<FoodItems, Long>{
	
	List<FoodItems> findByfoodName(String foodName);
	List<FoodItems>findByRetaurantName(String restaurantName);

}
