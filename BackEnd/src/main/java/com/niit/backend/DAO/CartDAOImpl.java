package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
	
	@Transactional
	public Cart getByCartId(int id){
		 Cart cart = (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
		 return cart;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public void deleteByCartId(int cartId) {
		// TODO Auto-generated method stub
		Cart cartToDelete = new Cart();
		cartToDelete.setId(cartId);
		sessionFactory.getCurrentSession().delete(cartToDelete);
	}

	public void deleteByCartName(String cartName) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByProductName(String productName) {
		// TODO Auto-generated method stub
		
	}


	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public Long getTotalAmount(String id) {
		String hql = "select sum(total) from Cart where emailid = " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		/*query.executeUpdate();
		return query.getFirstResult();*/   // Need to check
		Long sum = (Long) query.uniqueResult();
		return sum;
		
		

	}
	@Transactional
	public Cart getByUserandProduct(String emailid, String productid) {
		String hql = "from Cart where emailid= '" + emailid + "' and " + " productid ='" + productid+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()){
			return listCart.get(0);
		}
		return null;
	}
	@Transactional
	public boolean itemAlreadyExist(String emailid, String id) {
		String hql = "from Cart where emailid= '" + emailid + "' and " + " productId ='" + id+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

	public Cart getByEmailid(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<Cart> list(String emailid) {
		String hql = "from Cart where emailid=" + "'" + emailid + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();


		return list;
	}

	/*public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
