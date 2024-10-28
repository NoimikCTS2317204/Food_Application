package com.cognizant.foodapp.RestaurantService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.foodapp.RestaurantService.entity.RestaurantEntity;
import com.cognizant.foodapp.RestaurantService.services.FoodServiceClient;
import com.cognizant.foodapp.RestaurantService.services.RestaurantServices;

@RestController
@RequestMapping("/api/restaurantService")

public class RestaurantControllers {
	@Autowired
	RestaurantServices restaurantServices;

	@Autowired
	FoodServiceClient foodServiceClient;

	@PostMapping
	public ResponseEntity<RestaurantEntity> addRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
		RestaurantEntity createdRestaurant = restaurantServices.AddRestaurant(restaurantEntity);
		return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<RestaurantEntity>> getAllRestaurantEntity() {
		List<RestaurantEntity> restaurants = restaurantServices.getAllRestaurantDetails();
		return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}

	@GetMapping("/{restaurantName}")
	public ResponseEntity<RestaurantEntity> getRestaurantByName(@PathVariable String restaurantName) {
		RestaurantEntity restaurant = restaurantServices.getByName(restaurantName);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
	
	@GetMapping("/helloworld")
	public String getHelloWorld() {
		return foodServiceClient.getHelloWorld();
	}
}
