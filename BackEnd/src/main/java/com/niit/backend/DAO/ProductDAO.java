package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Product;

public interface ProductDAO {
	public List<Product> list();

	public Product get(String id);
	
	public Product getId(String id);

	public void saveOrUpdate(Product product);

	public void delete(String id);
	
	public List<Product> getFilterProductList();
}
