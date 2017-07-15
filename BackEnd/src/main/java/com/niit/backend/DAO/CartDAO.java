package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Cart;

public interface CartDAO {
	public List<Cart> list();
	public List<Cart> list(String email);
	public Cart getByCartId(int id);

	public Cart get(String id);
	
	public Cart getByEmailid(String email);
	
	/*public String delete(int id);*/
	
	public Long getTotalAmount(String id);

	public void saveOrUpdate(Cart cart);
	
	public Cart getByUserandProduct(String userid, String id);

	public boolean itemAlreadyExist(String emailId, String id);

	public void deleteByCartId(int cartId);
	
	

}