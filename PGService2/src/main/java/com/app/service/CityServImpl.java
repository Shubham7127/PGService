package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CityDao;
import com.app.pojos.Cities;

@Service
@Transactional
public class CityServImpl implements CityServ {

	@Autowired
	private CityDao cityDao;
//	@Override
//	public List<Cities> getAllCities() {
//		System.out.println();
//		return cityDao.findAll();
//	}
	
	
	@Override
	public Cities addCity(Cities city) {

		return cityDao.saveAndFlush(city);
	}
	@Override
	public String deleteCities(Long id) {

		Cities city = cityDao.findById(id).orElseThrow();
		cityDao.deleteById(id);
		return "city Deleted";
	}
	@Override
	public Cities getById(Long id) {

		return cityDao.findById(id).orElseThrow();
	}

}
