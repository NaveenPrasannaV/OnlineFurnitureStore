package com.cg.shopping.daoimpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.shopping.dao.UserDao;
import com.cg.shopping.entity.Cart;
import com.cg.shopping.entity.User;
import com.cg.shopping.repository.UserRepository;
@SpringBootTest
class UserDaoImplTest {
	
	@InjectMocks
	UserDao dao = new UserDaoImpl();
	@Mock
	UserRepository userRepo;
	
	User user = new User();
	
	@BeforeEach
	void setUp() throws Exception 
	{
		user.setUserEmail("naveen@gmail.com");
		user.setUserGender("male");
		user.setUserMobile("9865986598");
		user.setUserName("Naveeen");
		user.setUserPassword("PAssword@123");
		Cart cart = new Cart();
		cart.setCartId(1);
		user.setCart(cart);
	}

	@Test
	void testGetByEmailId() {
		when(userRepo.getById(user.getUserEmail())).thenReturn(user);
		dao.getByEmailId(user.getUserEmail());
		verify(userRepo).getById(user.getUserEmail());
	}

}
