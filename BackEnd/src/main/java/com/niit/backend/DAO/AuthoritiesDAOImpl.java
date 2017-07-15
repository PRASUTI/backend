package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Authorities;

@Repository("AuthoritiesDAO")
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AuthoritiesDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<Authorities> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void save(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
	}

	@Transactional
	public void update(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(authorities);
	}

	@Transactional
	public Authorities getEmail(String email) {
		// TODO Auto-generated method stub
		String hql = "from Authorities where email ='" + email + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Authorities> listAuthorities = (List<Authorities>) (query).list();

		if (listAuthorities != null && !listAuthorities.isEmpty()) {
			return listAuthorities.get(0);
		}

		return null;
	}


}
