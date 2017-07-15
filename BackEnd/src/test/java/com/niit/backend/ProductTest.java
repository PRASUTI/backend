package com.niit.backend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.ProductDAO;
import com.niit.backend.model.Product;

public class ProductTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		
		Product product = (Product) context.getBean("product");
		
		
		product.setProductname("sai");
		product.setPrice(1000);
		product.setStock(100);
		product.setDescription("exclusive");
		product.setBrand("vl");
		product.setManufacturer("svv");
		product.setCategoryname("1vd");
		productDAO.saveOrUpdate(product);
}
}
