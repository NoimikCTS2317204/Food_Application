package com.cognizant.foodapp.RestaurantService.restaurantRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.foodapp.RestaurantService.entity.RestaurantEntity;

public interface RestaurantRepo extends JpaRepository<RestaurantEntity, Long> {
	   Optional<RestaurantEntity> findByRestaurantName(String restaurantName);
}
