package org.banxico.proyecto2.controller;

import java.io.Serializable;
import java.util.List;

import org.banxico.proyecto2.entity.Customer;
import org.banxico.proyecto2.service.CustomerService;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Setter
@Getter
public class CustomerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8547127012052329569L;

	@Inject
	private CustomerService customerService;
	
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private List<Customer> customersList;
	
	public String save() {
		Customer customer = new Customer();
		customer.setFirstName(getFirstName());
		customer.setLastName(getLastName());
		customer.setEmail(getEmail());
		customer.setStoreId(1);
		customer.setActive('1');
		customer.setAddressId(1);
		
		if (getCustomerId() != 0) {
			customer.setCustomerId(getCustomerId());
			customerService.update(customer);
			return "customer";
		}
		
		customerService.save(customer);
		return "customer";
	}
	
	public String delete(int id) {
		customerService.delete(id);
		return "customer";
	}
}
