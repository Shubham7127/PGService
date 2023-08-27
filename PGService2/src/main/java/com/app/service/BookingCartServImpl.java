package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookingCartDao;
import com.app.dao.CartPropertiesDao;
import com.app.dao.PropertDao;
import com.app.dao.UserDao;
import com.app.dto.BookingCartdto;
import com.app.dto.CartProperitesdto;
import com.app.pojos.BookingCart;
import com.app.pojos.CartProperties;
import com.app.pojos.Properties;
import com.app.pojos.User;

@Service
@Transactional
public class BookingCartServImpl implements BookingCartServ {

	@Autowired
	public BookingCartDao cartDao;
	@Autowired
	public CartPropertiesDao cartPropertiesDao;
	@Autowired
	public PropertDao propertyDao;
	@Autowired
	public UserService userService;
	@Autowired
	public UserDao userDao;
	@Autowired
	public ModelMapper mapper;

	@Override
	public String addPropertiesToCart(Long propId, Long userId) {

		User user = userService.getUserSById(userId);

		if (user.getMyCart() == null) {
			BookingCart newCart = new BookingCart();
			user.addCart(newCart);
		}

		BookingCart cart = cartDao.findByCartOwnerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));

		// cart found
		// get product details from property id

		Properties property = propertyDao.findById(propId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));

		// Check if the cart already has the cart item for the same product id. If yes
		// simply incr the quantity , total price : update cart item : this part not yet
		// done !
		// if not : create a cart item

		CartProperties newItem = new CartProperties(cart, property);

		cart.getCartProperties().add(newItem);
		CartProperties savedItem = cartPropertiesDao.save(newItem);

		return "Property added in the BookingCart successfully";
	}

	@Override
	public Set<CartProperitesdto> getCartDetails(Long userId) {

		User user = userDao.findById(userId).orElseThrow();

		BookingCart cart = cartDao.findByCartOwnerId(user.getId()).orElseThrow();

		

		List<CartProperties> pr = cartPropertiesDao.findByMyCartId(cart.getId());

		System.out.println(cartPropertiesDao.findByMyCartId(cart.getId()));

		Set<CartProperitesdto> cpdto = new HashSet<CartProperitesdto>();

//		Map<Long, Properties> map = new HashMap<>();

		for (CartProperties c : pr) {

			Properties prop=new Properties(c.getProperties().getId(),c.getProperties().getName(),c.getProperties().getAddress(),c.getProperties().getGender(),c.getProperties().getRent());
			cpdto.add(new CartProperitesdto(prop));
		}

		return cpdto;
	}

	@Override
	public String deleteCartContents(Long userId) {

		return null;
	}

}
