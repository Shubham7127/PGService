package com.app.service;

import java.util.List;

import com.app.pojos.Cities;

public interface CityServ {

	//public List<Cities>getAllCities();
	
	public Cities getById(Long id);
	public Cities addCity(Cities city);
	
	public String deleteCities(Long id);
}
