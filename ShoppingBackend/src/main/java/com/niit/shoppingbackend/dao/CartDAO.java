package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingackend.model.Cart;

public interface CartDAO {
	public List<Cart> list();

	public Cart get(String id);

	
	public String delete(int id);
	
	public int getTotalAmount(String id);

	public void saveOrUpdate(Cart cart);
}
