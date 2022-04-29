package com.cg.shopping.daoimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.shopping.dao.OrdersDao;
import com.cg.shopping.entity.Orders;
import com.cg.shopping.repository.OrdersRepository;

@SpringBootTest
class OrdersDaoImplTest {
	
	@InjectMocks
	OrdersDao dao = new OrdersDaoImpl();
	
	@Mock
	OrdersRepository ordersRepo;
	
	Orders orders = new Orders();
	List<Orders> ordersList = new ArrayList<Orders>();
	Date date = new Date();
	
	@BeforeEach
	void setUp() throws Exception {
		orders.setOrderid(1);
		orders.setProductName("Himalaya");
		orders.setProductPrice(1500);
		orders.setProductQty(2);
		orders.setUserEmail("naveen@gmail.com");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		orders.setDate(date);
		ordersList.add(orders);
	}

	@Test
	void testGetAllOrdersByUserEmail() {
		when(ordersRepo.getByUserEmail(orders.getUserEmail())).thenReturn(ordersList);
		assertEquals(ordersList, dao.getAllOrdersByUserEmail(orders.getUserEmail()));
		verify(ordersRepo).getByUserEmail(orders.getUserEmail());
	}

}
