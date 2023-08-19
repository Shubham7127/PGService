package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ApiResponse;
import com.app.dto.Citiesdto;
import com.app.dto.Facilitiesdto;
import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.Cities;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;
import com.app.service.CityServ;
import com.app.service.FacilitiesServ;
import com.app.service.PropertServ;
import com.app.service.UserService;
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public UserService userservice;
	
	@Autowired
	public PropertServ propertyServ;
	
	@Autowired
	private FacilitiesServ facilitiesServ;
	
	@Autowired
	private CityServ cityService;
	
	@GetMapping("/user")
	public List<UserDto> listAllUsers(){
		System.out.println("in listUsers");
		return userservice.getAllusers();
	}

	@DeleteMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userservice.deleteUser(id);
	}
		
	@PostMapping("/property/addproperty")
	public ResponseEntity<?> addProperty(@RequestBody Propertydto property) {
	
		return ResponseEntity.ok(propertyServ.addProperty(property));
	}
	
	@PutMapping("/property/update")
	public Properties updateProperty(@RequestBody Propertydto property) {
		
		return propertyServ.updateProperty(property);
	}
	@PostMapping("/facilities/addfacilities")
	public ResponseEntity<?> addFacilities(@RequestBody Facilitiesdto facilities ) {
		return ResponseEntity.ok(facilitiesServ.addFacilities(facilities));
	}
	
	@PutMapping("/facilities/edit")
	public Facilities updateFacilities(@RequestBody Facilitiesdto facilities ) {
		
		return facilitiesServ.updateFacilities(facilities);
	} 
	
	@DeleteMapping("/facilties/delete/{id}")
	public String deleteFacilites(@PathVariable Long id) {
		return facilitiesServ.deleteFacility(id);
	}
	
	@PostMapping("/cities/add")
	public  ResponseEntity<?> addCity(@RequestBody Citiesdto city) {
	
		return ResponseEntity.ok(cityService.addCity(city));
	}
	
	@DeleteMapping("/cities/delete/{id}")
	public String city(@PathVariable Long id) {
		return cityService.deleteCities(id);
	}
	
	@PutMapping("/cities/edit")
	public Cities updateCity(@RequestBody Citiesdto ct) {
		
		return cityService.updateCity(ct);
	}
}
