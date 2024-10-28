package com.cognizant.foodapp.RestaurantService.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.foodapp.RestaurantService.entity.FoodItems;
import com.cognizant.foodapp.RestaurantService.entity.RestaurantEntity;
import com.cognizant.foodapp.RestaurantService.restaurantRepository.RestaurantRepo;
import com.cognizant.foodapp.RestaurantService.services.FoodServiceClient;
import com.cognizant.foodapp.RestaurantService.services.RestaurantServices;


@Service

public class RestaurantServiceimpl implements RestaurantServices {
	
	@Autowired
	private RestaurantRepo restaurantRepo ;
	
	
	@Autowired
	FoodServiceClient foodServiceClient;

	
	@Override
	public RestaurantEntity AddRestaurant(RestaurantEntity restaurantEntity) {
		// TODO Auto-generated method stub
	    // Check if a restaurant with the same name already exists
	    Optional<RestaurantEntity> existingRestaurant = restaurantRepo.findByRestaurantName(restaurantEntity.getRestaurantName());
	    
	    if (existingRestaurant.isPresent()) {
	        // If the restaurant name already exists, return null or handle it as needed
	        return null;
	    } else {
	        // If the restaurant name does not exist, save the new restaurant
	        return restaurantRepo.save(restaurantEntity);
	    }
	
	}


	


	@Override
	public List<RestaurantEntity> getAllRestaurantDetails() {
		List<RestaurantEntity> restaurants = restaurantRepo.findAll();
		
		List<RestaurantEntity> newRestaurants = restaurants.stream().map(restaurant -> {
		    restaurant.setFoodItems(foodServiceClient.getAllFoodItems(restaurant.getRestaurantName()));
		    return restaurant; // Ensure the modified restaurant is returned
		}).collect(Collectors.toList());
		System.out.println(newRestaurants);
		return newRestaurants;


	}


	@Override
	public RestaurantEntity getByName(String restaurantName) {
		// TODO Auto-generated method stub
		  RestaurantEntity restaurentRepo= restaurantRepo.findByRestaurantName(restaurantName).orElseThrow(()->new RuntimeException("No Question Found"));
		  restaurentRepo.setFoodItems(foodServiceClient.getAllFoodItems(restaurentRepo.getRestaurantName()));
		  
		  return restaurentRepo;
	}






}
