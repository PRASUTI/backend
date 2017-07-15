package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Shippingaddress;

public interface ShippingaddressDAO {
	
	 public List<Shippingaddress> list();
	    
	    public List<Shippingaddress> list(String email);
		
		public Shippingaddress getByShippingAddress(String shippingaddress);
		
		public Shippingaddress getByeShippingId(String shippingId);
		
		public Shippingaddress getByUserName(String username);
		
		public Shippingaddress getByUserId(int userid);
		
		public void saveOrUpdate(Shippingaddress shippingaddress);
		
		public void delete(int shippingId);
		
		public void editShippingAddress(Shippingaddress shippingaddress);

		public void save(Shippingaddress shippingaddress);

		public void update(Shippingaddress shippingaddress);
		

}
