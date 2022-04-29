package com.cg.shopping.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdersTest {

	Orders orders = new Orders();
	
	@BeforeEach
	void setUp() throws Exception {
		orders.setOrderid(1);
		orders.setProductName("Table");
		orders.setProductPrice(1500);
		orders.setProductQty(10);
		orders.setUserEmail("naveen@gmail.com");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		orders.setDate(date);
	}

	@Test
	void testGetOrderid() {
		assertEquals(1, orders.getOrderid());
	}

	@Test
	void testGetUserEmail() {
		assertEquals("naveen@gmail.com", orders.getUserEmail());
	}

	@Test
	void testGetProductName() {
		assertEquals("Table", orders.getProductName());
	}

	@Test
	void testGetProductQty() {
		assertEquals(10, orders.getProductQty());
	}

	@Test
	void testGetProductPrice() {
		assertEquals(1500, orders.getProductPrice());
	}

}
