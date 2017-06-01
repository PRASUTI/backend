package com.niit.shoppingackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingackend.model.Supplier;
import com.niit.shoppingbackend.dao.SupplierDAO;



public class SupplierTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingackend");
		context.refresh();
		
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setName("Shree");
		supplier.setAddress("Cross cut road, Cbe");
		supplier.setPhonenumber("546");
		supplier.setEmailid("uiebuv@huf.com");
		supplierDAO.saveOrUpdate(supplier);
}
}