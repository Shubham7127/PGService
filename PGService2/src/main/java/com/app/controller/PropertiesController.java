package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Properties;
import com.app.service.PropertServ;

@RestController
@RequestMapping("/properties")
public class PropertiesController {

	@Autowired
	public PropertServ propertyServ;
	
	public PropertiesController() {
		System.out.println("propertiesControllerCalled");
	}
	@GetMapping("/city")
	public List<Properties> listOfProperties(@RequestParam String city){
		return propertyServ.getByCity(city);
	}
	
	
}
