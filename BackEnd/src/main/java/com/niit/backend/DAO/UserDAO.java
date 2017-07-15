package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.User;



public interface UserDAO {
	
	public List<User> list();

	public User get(String userid);

	public void saveOrUpdate(User user);

	public void delete(String userid);

	public boolean isValidUser(String userid, String password);

	public User getByemail(String email);
}
