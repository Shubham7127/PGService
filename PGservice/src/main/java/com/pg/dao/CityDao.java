package com.pg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.pojo.Cities;

public interface CityDao extends JpaRepository<Cities, Long> {

	
}
