package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ReviewDao;
import com.app.dto.ApiResponse;
import com.app.dto.Converterdto;
import com.app.dto.Propertydto;
import com.app.dto.Reviewdto;
import com.app.pojos.Properties;
import com.app.pojos.Reviews;

@Service
@Transactional
public class ReviewsServImpl implements ReviewsServ {
	@Autowired
	public ReviewDao reviewDao;

	@Autowired
	public ModelMapper mapper;

	@Override
	public List<Reviewdto> getAllReview() {

		List<Reviewdto> ReviewsDtoList = new ArrayList<Reviewdto>();
		List<Reviews> reviews = reviewDao.findAll();
		ReviewsDtoList = Arrays.asList(mapper.map(reviews, Reviewdto[].class));
		return ReviewsDtoList;
	}

	@Override
	public ApiResponse addReview(Reviewdto review) {

		Converterdto converter = new Converterdto();
		Reviews rev = converter.toReviewsentity(review);
		Reviews prop = reviewDao.save(rev);

		return new ApiResponse("Review Added Successfully");
	}

	@Override
	public String deleteReview(Long id) {

		return null;
	}

}