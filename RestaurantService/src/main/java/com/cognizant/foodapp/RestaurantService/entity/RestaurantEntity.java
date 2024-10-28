package com.cognizant.foodapp.RestaurantService.entity;

import java.util.List;

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
@Table(name="Question")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhNo;
    private String restaurantEmail;
    
    
    transient private List<FoodItems> foodItems;
}
