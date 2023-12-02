package org.banxico.proyecto2.service;

import java.util.List;

import org.banxico.proyecto2.entity.Customer;
import org.banxico.proyecto2.repository.CustomerFacadeLocal;

import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Named;

@Model
public class CustomerServiceImpl implements CustomerService {

	@EJB
	private CustomerFacadeLocal customerFacadeLocal;
	
	@Override
	public void save(Customer customer) {
		customerFacadeLocal.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerFacadeLocal.update(customer);
	}

	@Override
	public void delete(Integer id) {
		customerFacadeLocal.delete(id);
	}

	@Override
	public Customer findById(Integer id) {
		return customerFacadeLocal.findById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerFacadeLocal.findAll();
	}

	@Override
	public List<Customer> findRange(int[] range) {
		return customerFacadeLocal.findRange(range);
	}

	@Override
	public int count() {
		return customerFacadeLocal.count();
	}

}
