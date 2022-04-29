package com.cg.shopping.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {

	Cart cart = new Cart();
	User user = new User();
	List<Product> products = new ArrayList<Product>();
	
	@BeforeEach
	void setUp() throws Exception {
		cart.setCartId(1);
		cart.setTotalCartPrice(1000);
		cart.setTotalProductQty(10);
		user.setUserEmail("naveen@gmail.com");
		cart.setUser(user);
		cart.setProductList(products);
	}

	@Test
	void testGetCartId() {
		assertEquals(1, cart.getCartId());
	}

	@Test
	void testGetTotalCartPrice() {
		assertEquals(1000, cart.getTotalCartPrice());
	}

	@Test
	void testGetTotalProductQty() {
		assertEquals(10, cart.getTotalProductQty());
	}
	
	@Test
	void testGetUser() {
		assertEquals(user, cart.getUser());
	}
	
	@Test
	void testProductList() {
		assertEquals(products, cart.getProductList());
	}

}
