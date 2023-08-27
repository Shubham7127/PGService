package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Reviews;

public interface ReviewDao extends JpaRepository<Reviews, Long>{
	List<Reviews>findByPropertyId(Long propId);
}
