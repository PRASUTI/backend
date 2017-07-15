package com.niit.backend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CartDAO;
import com.niit.backend.model.Cart;

public class CartTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.*");
		context.refresh();
		
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		
		Cart cart = (Cart) context.getBean("cart");
		
		cart.setPrice(2000);
		cart.setProductName("Watch");
		cart.setQuantity(10);
		cart.setStatus("available");
		cart.setTotal(20);
		cartDAO.saveOrUpdate(cart);
}
}