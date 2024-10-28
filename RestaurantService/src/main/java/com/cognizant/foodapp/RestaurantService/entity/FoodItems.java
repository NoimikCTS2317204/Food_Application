package com.cognizant.foodapp.RestaurantService.entity;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString



public class FoodItems {
	
	
    private Long foodId;
    private Long restaurantId;
    private String restaurantName;
    private String foodName;
    private String foodDescription;
    private Double foodPrice;
    private Integer foodQuantity;

}


