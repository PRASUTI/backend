package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingackend.model.Category;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(String id);

	public void saveOrUpdate(Category category);

	public void delete(String id);

	public Category getByName(String name);



}
