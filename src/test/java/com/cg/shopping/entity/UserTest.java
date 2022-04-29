package com.cg.shopping.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	User user = new User();
	@BeforeEach
	void setUp() throws Exception {
		user.setUserEmail("naveen@gmail.com");
		user.setUserGender("Male");
		user.setUserMobile("9865986598");
		user.setUserName("Naveen");
		user.setUserPassword("PAssword@123");
		Cart cart = new Cart();
		cart.setCartId(1);
		user.setCart(cart);
	}

	@Test
	void testGetUserEmail() {
		assertEquals("naveen@gmail.com", user.getUserEmail());
	}

	@Test
	void testGetUserName() {
		assertEquals("Naveen", user.getUserName());
	}

	@Test
	void testGetUserPassword() {
		assertEquals("PAssword@123", user.getUserPassword());
	}

	@Test
	void testGetUserMobile() {
		assertEquals("9865986598", user.getUserMobile());
	}

	@Test
	void testGetCart() {
		assertEquals(1, user.getCart().getCartId());
	}

	@Test
	void testGetUserGender() {
		assertEquals("Male", user.getUserGender());
	}

}
