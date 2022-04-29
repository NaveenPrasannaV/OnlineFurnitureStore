package com.cg.shopping.daoimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.shopping.dao.ProductDao;
import com.cg.shopping.entity.Product;
import com.cg.shopping.repository.ProductRepository;

@SpringBootTest
class ProductDaoImplTest {

	@InjectMocks
	ProductDao dao = new ProductDaoImpl();
	
	@Mock
	ProductRepository productRepo;
	
	Product product = new Product();
	List<Product> productList = new ArrayList<Product>();
	
	@BeforeEach
	void setUp() throws Exception 
	{
		product.setProductId(1);
		product.setProductName("Dove");
		product.setProductPrice(15.01);
		product.setProductQty(10);
		product.setProductDescription("Beauty");
		productList.add(product);
	}


	@Test
	void testGetByProductId() {
		when(productRepo.getById(product.getProductId())).thenReturn(product);
		assertEquals(product, dao.getByProductId(product.getProductId()));
		verify(productRepo).getById(product.getProductId());
	}
	
	@Test
	void testexistsByProductId() {
		when(productRepo.existsById(product.getProductId())).thenReturn(true);
		assertEquals(true, dao.existsByProductId(product.getProductId()));
		verify(productRepo).existsById(product.getProductId());
	}

	
	@Test
	void testfindByProductNameLike() {
		when(productRepo.findByProductNameIgnoreCaseContaining("D")).thenReturn(productList);
		assertEquals(productList, dao.findByProductNameLike("D"));
		verify(productRepo).findByProductNameIgnoreCaseContaining("D");
	}

}
