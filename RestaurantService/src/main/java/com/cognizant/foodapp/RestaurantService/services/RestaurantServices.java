package com.cognizant.foodapp.RestaurantService.services;

import java.util.List;


import com.cognizant.foodapp.RestaurantService.entity.RestaurantEntity;



public interface RestaurantServices {
	
	RestaurantEntity AddRestaurant(RestaurantEntity restaurantEntity);
	List<RestaurantEntity> getAllRestaurantDetails();
	RestaurantEntity getByName(String restaurantName);
	

}
