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

import com.cg.shopping.dao.CartDao;
import com.cg.shopping.entity.Cart;
import com.cg.shopping.entity.Product;
import com.cg.shopping.entity.User;
import com.cg.shopping.repository.CartRepository;

@SpringBootTest
class CartDaoImplTest {

	@InjectMocks
	CartDao dao = new CartDaoImpl();
	
	@Mock
	CartRepository cartRepo;
	
	Cart cart = new Cart();
	List<Cart> cartList = new ArrayList<Cart>();
	User user = new User();
	List<Product> products = new ArrayList<Product>();
	
	@BeforeEach
	void setUp() throws Exception 
	{
		cart.setCartId(1);
		cart.setTotalCartPrice(1000);
		cart.setTotalProductQty(10);
		user.setUserEmail("naveen@gmail.com");
		cart.setUser(user);
		cart.setProductList(products);
		cartList.add(cart);
	}

	@Test
	void testFindCartByCartId() {
		when(cartRepo.getById(cart.getCartId())).thenReturn(cart);
		assertEquals(cart, dao.findCartByCartId(cart.getCartId()));
		verify(cartRepo).getById(cart.getCartId());
	}
	
	@Test
	void testfindAllCarts() {
		when(cartRepo.findAll()).thenReturn(cartList);
		assertEquals(cartList, dao.findAllCarts());
		verify(cartRepo).findAll();
	}
	
	@Test
	void testexistsByUserUserEmail() {
		when(cartRepo.existsByUserUserEmail(user.getUserEmail())).thenReturn(true);
		assertEquals(true, dao.existsByUserUserEmail(user.getUserEmail()));
		verify(cartRepo).existsByUserUserEmail(user.getUserEmail());
	}
	

	@Test
	void testfindCartByUserUserEmail() {
		when(cartRepo.findByUserUserEmail(user.getUserEmail())).thenReturn(cart);
		assertEquals(cart, dao.findCartByUserUserEmail(user.getUserEmail()));
		verify(cartRepo).findByUserUserEmail(user.getUserEmail());	
	}
	
	

}
