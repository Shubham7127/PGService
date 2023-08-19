package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.FacilitiesDao;
import com.app.dto.Converterdto;
import com.app.dto.Facilitiesdto;
import com.app.pojos.Facilities;
@Service
@Transactional
public class FacilitiesServImpl implements FacilitiesServ{

	@Autowired
	public FacilitiesDao facilitiesDao;
	
	@Autowired
	public ModelMapper mapper;
	
	@Override
	public Facilities addFacilities(Facilitiesdto facilities) {
	
		Converterdto dto=new Converterdto();
		  Facilities ctyo=dto.toFacilities(facilities);
		  Facilities fty=facilitiesDao.save(ctyo);
		return fty;
	}



	@Override
	public Facilitiesdto getById(Long id) {
		Facilities facilities=facilitiesDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		return mapper.map(facilities, Facilitiesdto.class);
	}



	@Override
	public Facilities updateFacilities(Facilitiesdto facilities) {
	
		Facilities fc=facilitiesDao.findById(facilities.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		Converterdto dto=new Converterdto();
		Facilities ctyo=dto.toFacilities(facilities);
		return facilitiesDao.save(ctyo);
	}

}
