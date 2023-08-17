package com.pg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.pojo.Properties;

public interface PropertDao extends JpaRepository<Properties, Long> {

		public List<Properties> findByName(String city);
}
