package com.app.dto;


import org.springframework.stereotype.Component;

import com.app.pojos.Cities;
import com.app.pojos.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class Propertydto {
	private Long id;
	private String name;
	private String description;
	private String address;
	private Gender gender;
	private double rent;
	private	float ratingClean;
	private float ratingFood;
	private float ratingSafety;
	private Long city_id;
}
