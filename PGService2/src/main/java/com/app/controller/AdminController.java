package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.Facilitiesdto;
import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;
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
	public Properties addProperty(@RequestBody Propertydto property) {
	
		return propertyServ.addProperty(property);
	}
	
	@PutMapping("/property/update")
	public Properties updateProperty(@RequestBody Propertydto property) {
		
		return propertyServ.updateProperty(property);
	}
	@PostMapping("/facilities/addfacilities")
	public Facilities addFacilities(@RequestBody Facilitiesdto facilities ) {
		return facilitiesServ.addFacilities(facilities);
	}
	
	@PutMapping("/facilities/edit")
	public Facilities updateFacilities(@RequestBody Facilitiesdto facilities ) {
		
		return facilitiesServ.updateFacilities(facilities);
	} 
	
	@DeleteMapping("/facilties/delete/{id}")
	public String deleteFacilites(@PathVariable Long id) {
		return facilitiesServ.deleteFacility(id);
	}
}
