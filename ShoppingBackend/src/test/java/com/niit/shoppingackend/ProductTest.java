package com.niit.shoppingackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingackend.model.Product;
import com.niit.shoppingbackend.dao.ProductDAO;

public class ProductTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingackend");
		context.refresh();
		
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		
		Product product = (Product) context.getBean("product");
		
		
		product.setProductname("sai");
		product.setPrice("1000");
		product.setQuantity("10");
		product.setStock("100");
		product.setDescription("exclusive");
		product.setBrand("vl");
		product.setManufacturer("svv");
		product.setSupplier("1vd");
		productDAO.saveOrUpdate(product);
}
}