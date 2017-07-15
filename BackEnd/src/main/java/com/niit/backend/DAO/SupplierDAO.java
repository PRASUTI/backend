package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(String id);
	
	public Supplier getByName(String name);

	public void saveOrUpdate(Supplier supplier);

	public String delete(String id);

}

