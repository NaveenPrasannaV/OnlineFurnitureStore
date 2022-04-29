package com.cg.shopping.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	Product product = new Product();
	@BeforeEach
	void setUp() throws Exception {
		product.setProductId(1);
		product.setProductName("Table");
		product.setProductPrice(15.01);
		product.setProductQty(10);
		product.setProductDescription("Furniture");
	}

	@Test
	void testGetProductId() {
		assertEquals(1, product.getProductId());
	}

	@Test
	void testGetProductName() {
		assertEquals("Table", product.getProductName());
	}

	@Test
	void testGetProductDescription() {
		assertEquals("Furniture", product.getProductDescription());
	}

	@Test
	void testGetProductPrice() {
		assertEquals(15.01, product.getProductPrice());
	}

	@Test
	void testGetProductQty() {
		assertEquals(10, product.getProductQty());
	}

}
