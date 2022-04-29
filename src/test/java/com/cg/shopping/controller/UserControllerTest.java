package com.cg.shopping.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.shopping.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void testUserSignOut() throws Exception {
		Mockito.when(userService.userSignOut()).thenReturn("User Successfully signed out");

		mockMvc.perform(get("/signout")).andExpect(status().isOk())
				.andExpect(content().string(containsString("User Successfully signed out")));
	}

	@Test
	void testAddProductToCart() throws Exception {
		Mockito.when(userService.addProductToCart(1)).thenReturn("Product Added");

		mockMvc.perform(get("/addtocart/1")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Product Added")));
	}

	@Test
	void testremoveProductFromCart() throws Exception {
		Mockito.when(userService.removeProductFromCart(1)).thenReturn("Product Deleted");

		mockMvc.perform(delete("/removefromcart/1")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Product Deleted")));
	}

	@Test
	void testchangeProductQuantityInCart() throws Exception {
		Mockito.when(userService.changeProductQuantityInCart(1, 2)).thenReturn("Product Qty changed");

		mockMvc.perform(get("/qty/1/2")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Product Qty changed")));
	}
	
	@Test
	void testUserSignUp() throws Exception {

		mockMvc.perform(post("/signup")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.userEmail: ").value("naveen@gmail.com"))
				.andExpect(jsonPath("$.userName").value("Naveen"))
				.andExpect(jsonPath("$.userPassword").value("PAssword@123"))
				.andExpect(jsonPath("$.userConfirmPassword").value("PAssword@123"))
				.andExpect(jsonPath("$.userMobile").value("9865986598"))
				.andExpect(jsonPath("$.userGender").value("Male"));
	}
}
