package com.cg.shopping.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.shopping.entity.User;
import com.cg.shopping.exception.EmailAlreadyExistException;
import com.cg.shopping.exception.IllegalValueException;
import com.cg.shopping.exception.NullValueFieldException;
import com.cg.shopping.exception.PasswordLengthMismatchException;
import com.cg.shopping.exception.PasswordMismatchException;
import com.cg.shopping.exception.PasswordWithNoDigitException;
import com.cg.shopping.exception.PasswordWithNoSplCharException;
import com.cg.shopping.model.ProductDTO;
import com.cg.shopping.model.UserDTO;

@SpringBootTest
class ShoppingValidationTest {

	
	UserDTO userdto = new UserDTO();
	ProductDTO productdto = new ProductDTO();
	
	@BeforeEach
	void setUp() throws Exception {
		userdto.setUserEmail("naveen@gmail.com");
		userdto.setUserGender("Male");
		userdto.setUserMobile("9865986598");
		userdto.setUserName("Naveen");
		userdto.setUserPassword("PAssword@123");
		userdto.setUserConfirmPassword("PAssword@123");
		
		productdto.setProductName("Dove");
		productdto.setProductPrice(15.01);
		productdto.setProductQty(10);
		productdto.setProductDescription("Beauty");
	}

	@Test
	void testSignUpValidation() throws NullValueFieldException, PasswordMismatchException, PasswordLengthMismatchException, PasswordWithNoSplCharException, PasswordWithNoDigitException, EmailAlreadyExistException {
		assertEquals(true, ShoppingValidation.signUpValidation(userdto.getUserName(), userdto.getUserEmail(), userdto.getUserPassword(), userdto.getUserConfirmPassword(), userdto.getUserMobile(), userdto.getUserGender()));
	}

	@Test
	void testPasswordValidation() throws PasswordLengthMismatchException, PasswordWithNoSplCharException, PasswordWithNoDigitException {
		assertEquals(true, ShoppingValidation.passwordValidation(userdto.getUserPassword()));
	}

	@Test
	void testAddProductValidation() throws NullValueFieldException, IllegalValueException {
		assertEquals(true, ShoppingValidation.addProductValidation(productdto));
	}

	@Test
	void testSearchProductValidation() throws NullValueFieldException {
		assertEquals(true, ShoppingValidation.searchProductValidation(productdto.getProductName()));

	}

	@Test
	void testCheckIsAdminSignIn() {
		assertEquals(true, ShoppingValidation.checkIsAdminSignIn("adam@shopadmin.com"));
		assertEquals(false, ShoppingValidation.checkIsAdminSignIn("adam@gmail.com"));

	}

}
