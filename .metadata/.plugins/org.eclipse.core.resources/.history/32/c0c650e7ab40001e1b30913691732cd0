package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookingCartDao;
import com.app.dao.CartPropertiesDao;
import com.app.dao.PropertDao;
import com.app.dto.BookingCartdto;
import com.app.pojos.BookingCart;
import com.app.pojos.CartProperties;
import com.app.pojos.Properties;
import com.app.pojos.User;
@Service
@Transactional
public class BookingCartServImpl implements BookingCartServ{

	@Autowired
	public BookingCartDao cartDao;
	@Autowired
	public CartPropertiesDao cartPropertiesDao;
	@Autowired
	public PropertDao propertyDao;
	@Autowired
	public UserService userService;
	@Override
	public String addPropertiesToCart(Long userId, Long prodId) {
	
		User user = userService.getUserSById(userId);
		
		if(user.getMyCart()==null)
		{
			BookingCart newCart = new BookingCart();
			user.addCart(newCart);
		}
		
		BookingCart cart = cartDao.findByCartOwnerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		
		// cart found
				// get product details from property id
		
		Properties property=propertyDao.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		
		// Check if the cart already has the cart item for the same product id. If yes
				// simply incr the quantity , total price : update cart item : this part not yet done !
				// if not : create a cart item 
		
		CartProperties newItem=new CartProperties(cart,property);
		
		cart.getCartProperties().add(newItem);
		CartProperties savedItem= cartPropertiesDao.save(newItem);
		
		return "Property added in the BookingCart successfully";
	}

	@Override
	public List<BookingCartdto> getCartDetails() {
		List<BookingCartdto> l=cartDao.getAllCart();
		return l;
	}

	@Override
	public String deleteCartContents(Long userId) {

		return null;
	}
	

}
