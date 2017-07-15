package com.niit.backend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.SupplierDAO;
import com.niit.backend.model.Supplier;



public class SupplierTest {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingbackend");
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