package com.niit.shoppingackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingackend.model.User;
import com.niit.shoppingbackend.dao.UserDAO;

public class UserTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingackend");
		context.refresh();
		System.out.println("Welcom User!!!!!!!!!!!!!!");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
		
		User user = (User) context.getBean("user");
		
		
		user.setUsername("prasuti");
		user.setPassword("123");
		user.setMobile("999");
		user.setEmail("prasuti1996@gmail.com");
		user.setAddress("Nehru Street, Cbe");
		user.setEnabled(true);
		userDAO.saveOrUpdate(user);
}
}