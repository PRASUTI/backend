package com.niit.shoppingackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingackend.model.Category;
import com.niit.shoppingbackend.dao.CategoryDAO;

public class CategoryTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingackend");
		context.refresh();
		System.out.println("Welcom User!!!!!!!!!!!!!!");
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
		
		Category category = (Category) context.getBean("category");
	
		category.setName("Clothes");
		category.setDescription("branded materials available");
	
		categoryDAO.saveOrUpdate(category);
}
}