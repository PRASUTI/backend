package com.niit.shoppingbackend.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingackend.model.User;
import com.niit.shoppingbackend.dao.UserDAO;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	@Transactional
	public void delete(String id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}
	
	
	
	@Transactional
	public boolean isValidUser(String id, String password) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
		
	}

	


	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>)
			sessionFactory.getCurrentSession()
			.createCriteria(User.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;

		
	}



	@Transactional
	public User get(String id) {
		return null;
		// TODO Auto-generated method stub
		
		
	}
}
