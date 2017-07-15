package com.niit.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.UserDAO;
import com.niit.backend.model.User;

public class UserTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingbackend");
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