package com.niit.shoppingackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingackend.model.Cart;
import com.niit.shoppingbackend.dao.CartDAO;

public class CartTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingackend");
		context.refresh();
		
		CartDAO cartDAO = (CartDAO) context.getBean("CartDAO");
		
		Cart cart = (Cart) context.getBean("cart");
		
		cart.setPrice("2000");
		cart.setProductName("Watch");
		cart.setQuantity("10");
		cart.setStatus("available");
		cart.setTotal("20");
		cartDAO.saveOrUpdate(cart);
}
}