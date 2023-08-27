package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.pojos.Properties;

@Repository
public interface PropertDao extends JpaRepository<Properties, Long> {

	List<Properties> findByGender(String gender);
	
	
}
