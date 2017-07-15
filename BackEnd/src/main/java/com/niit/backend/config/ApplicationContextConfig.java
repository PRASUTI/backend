package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.DAO.AuthoritiesDAO;
import com.niit.backend.DAO.AuthoritiesDAOImpl;
import com.niit.backend.DAO.CartDAO;
import com.niit.backend.DAO.CartDAOImpl;
import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.DAO.CategoryDAOImpl;
import com.niit.backend.DAO.ProductDAO;
import com.niit.backend.DAO.ProductDAOImpl;
import com.niit.backend.DAO.ShippingaddressDAOImpl;
import com.niit.backend.DAO.SupplierDAO;
import com.niit.backend.DAO.SupplierDAOImpl;
import com.niit.backend.DAO.UserDAO;
import com.niit.backend.DAO.UserDAOImpl;
import com.niit.backend.model.Authorities;
import com.niit.backend.model.Cart;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Shippingaddress;
import com.niit.backend.model.Supplier;
import com.niit.backend.model.User;
import com.niit.backend.model.UserOrder;

@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Kart");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		/*sessionBuilder.addProperties(getHibernateProperties());*/
		
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		sessionBuilder.addAnnotatedClasses(Authorities.class);
		sessionBuilder.addAnnotatedClasses(UserOrder.class);
		sessionBuilder.addAnnotatedClasses(Shippingaddress.class);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
	
	@Autowired(required = true)	
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "SupplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "CartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "AuthoritiesDAO")
	public AuthoritiesDAO getAuthoritiesDAO(SessionFactory sessionFactory) {
		return new AuthoritiesDAOImpl(sessionFactory);
	}
	@Autowired(required = true)	
	@Bean(name = "ShippingaddressDAO")
	public ShippingaddressDAOImpl getShippingaddressDAO(SessionFactory sessionFactory) {
		return new ShippingaddressDAOImpl(sessionFactory);
	}
}