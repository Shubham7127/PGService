package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PropertDao;
import com.app.pojos.Properties;

@Service
@Transactional
public class PropertServImpl implements PropertServ{

	
	@Autowired
	private PropertDao propertyDao;

	@Override
	public List<Properties> getByCity(String city) {

		return propertyDao.findByName(city);
	}

	

}
