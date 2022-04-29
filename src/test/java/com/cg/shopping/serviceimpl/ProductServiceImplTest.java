package com.cg.shopping.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.shopping.dao.ProductDao;
import com.cg.shopping.entity.Product;
import com.cg.shopping.exception.IllegalValueException;
import com.cg.shopping.exception.NullValueFieldException;
import com.cg.shopping.exception.UserSignInRequiredException;
import com.cg.shopping.model.ProductDTO;
import com.cg.shopping.service.ProductService;
import com.cg.shopping.service.UserService;
import com.cg.shopping.utils.ProductUtil;
import com.cg.shopping.validation.ShoppingValidation;

@SpringBootTest
class ProductServiceImplTest {

	@InjectMocks
	ProductService service = new ProductServiceImpl();
	
	@Mock
	UserService userService;
	@Mock
	ProductDao productDao;
	@Mock
	ProductUtil util;
	
	ProductDTO productdto = new ProductDTO();
	Product product = new Product();
	String adminEmail = "admin@shopadmin.com";
	
	@BeforeEach
	void setUp() throws Exception {
		product.setProductId(1);
		product.setProductName("Dove");
		product.setProductPrice(15.01);
		product.setProductQty(10);
		product.setProductDescription("Beauty");
		productdto.setProductId(1);
		productdto.setProductName("Dove");
		productdto.setProductPrice(15.01);
		productdto.setProductQty(10);
		productdto.setProductDescription("Beauty");
	}

	@Test
	void testAddProductToTable() throws UserSignInRequiredException, NullValueFieldException, IllegalValueException {
		when(userService.userSignInVerification()).thenReturn(true);
		when(ShoppingValidation.checkIsAdminSignIn(adminEmail)).thenReturn(true);
		when(ShoppingValidation.addProductValidation(productdto)).thenReturn(true);
		when(ProductUtil.convertToProduct(productdto)).thenReturn(product);
		doNothing().when(productDao).saveProduct(product);
		assertEquals("Product " + productdto.getProductName() + " Added Successfully into the DataBase", service.addProductToTable(productdto));
		
	}

}
