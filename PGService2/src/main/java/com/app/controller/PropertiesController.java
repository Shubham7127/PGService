package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.Citiesdto;
import com.app.dto.Propertydto;
import com.app.pojos.Cities;
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
	
	@GetMapping("/{cityName}")
    public List<Propertydto> getPropertiesByCityName(@PathVariable String cityName) {
        return propertyServ.getPropertiesByCityName(cityName);
    }
	
	@PostMapping
	public Properties addProperty(@RequestBody Propertydto property) {
	
		return propertyServ.addProperty(property);
	}
	
	@PutMapping
	public Properties updateProperty(@RequestBody Propertydto property) {
		
		return propertyServ.updateProperty(property);
	}
}
