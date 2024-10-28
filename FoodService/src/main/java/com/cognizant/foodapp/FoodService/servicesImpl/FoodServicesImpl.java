package com.cognizant.foodapp.FoodService.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.foodapp.FoodService.entities.FoodItems;
import com.cognizant.foodapp.FoodService.foodrepositories.FoodRepo;
import com.cognizant.foodapp.FoodService.services.FoodServices;




@Service

public class FoodServicesImpl implements FoodServices{
	
	@Autowired
	FoodRepo foodRepo;

	@Override
	public FoodItems AddFoodItem(FoodItems foodItems) {
		// TODO Auto-generated method stub
		return foodRepo.save(foodItems);
	}

	@Override
	public List<FoodItems> getAllFoodItems() {
		// TODO Auto-generated method stub
		return foodRepo.findAll();
	}

	public List<FoodItems> getAllByFoodNames(String foodName) {
        List<FoodItems> foodItems = foodRepo.findByfoodName(foodName);
        if (foodItems.isEmpty()) {
            throw new RuntimeException("No Such Directory Found");
        }
        return foodItems;
    }

	
	public List<FoodItems> getAllByRestaurantName(String restaurantName) {
        List<FoodItems> foodItems = foodRepo.findByRetaurantName(restaurantName);
        if (foodItems.isEmpty()) {
            throw new RuntimeException("No Such Directory Found");
        }
        return foodItems;
    }

}
