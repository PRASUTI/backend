package com.niit.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.model.Category;

public class CategoryTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.backend");
		context.refresh();
		System.out.println("Welcom User!!!!!!!!!!!!!!");
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		Category category = (Category) context.getBean("category");
	
		category.setName("Clothes");
		category.setDescription("branded materials available");
	
		categoryDAO.saveOrUpdate(category);
}
}
