package com.cognizant.foodapp.FoodService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Food_Items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString






public class FoodItems {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private Long restaurantId;
    private String retaurantName;
    private String foodName;
    private String foodDescription;
    private Double foodPrice;
    private Integer foodQuantity;

}
