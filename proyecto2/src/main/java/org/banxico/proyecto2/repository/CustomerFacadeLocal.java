package org.banxico.proyecto2.repository;

import java.util.List;
import org.banxico.proyecto2.entity.Customer;
import jakarta.ejb.Local;

@Local
public interface CustomerFacadeLocal {
	
	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(Integer id);
	public Customer findById(Integer id);
	public List<Customer> findAll();
	public List<Customer> findRange(int[] range);
	public int count();
}
