package com.app.service;

import com.app.dto.Facilitiesdto;
import com.app.pojos.Facilities;

public interface FacilitiesServ {

	public Facilities addFacilities(Facilitiesdto facilities);
	
	public Facilities updateFacilities(Facilitiesdto  facilities);
	
	public Facilitiesdto getById(Long id);
	public String deleteFacility(Long id);
	
}
