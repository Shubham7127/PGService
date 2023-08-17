package com.pg.service;

import java.util.List;

import com.pg.pojo.Properties;

public interface PropertServ {

	public List<Properties> getByCity(String City);	
}
