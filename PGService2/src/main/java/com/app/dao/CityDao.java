package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cities;

public interface CityDao extends JpaRepository<Cities, Long> {

	
}
