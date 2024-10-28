package com.cognizant.foodapp.FoodService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.foodapp.FoodService.entities.FoodItems;
import com.cognizant.foodapp.FoodService.services.FoodServices;

@RestController
@RequestMapping("/api/foodService")


@CrossOrigin("*")
public class FoodServiceController {

	@Autowired
	FoodServices foodServices;

	@PostMapping
    public ResponseEntity<FoodItems> addNewFoodItem(@RequestBody FoodItems foodItems) {
        FoodItems createdFoodItem = foodServices.AddFoodItem(foodItems);
        return new ResponseEntity<>(createdFoodItem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodItems>> getAllFoodItems() {
        List<FoodItems> foodItemsList = foodServices.getAllFoodItems();
        return new ResponseEntity<>(foodItemsList, HttpStatus.OK);
    }

    @GetMapping("/{foodName}")
    public ResponseEntity<List<FoodItems>> getFoodsByFoodName(@PathVariable String foodName) {
        List<FoodItems> foodItems = foodServices.getAllByFoodNames(foodName);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }
    
    @GetMapping("restaurant/{restaurantName}")
    public ResponseEntity<List<FoodItems>> getFoodsByRestaurantName(@PathVariable String restaurantName) {
    	
        List<FoodItems> foodItems = foodServices.getAllByRestaurantName(restaurantName);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }
    
    @GetMapping("/demo")
    public String helloWorld() {
    	return "Hello World";
    }
}
