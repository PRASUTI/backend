package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Authorities;

public interface AuthoritiesDAO {
	
	public List<Authorities> list();
	
	public void save(Authorities authorities);

	public void update(Authorities authorities);
	
	public Authorities getEmail(String email);

}
