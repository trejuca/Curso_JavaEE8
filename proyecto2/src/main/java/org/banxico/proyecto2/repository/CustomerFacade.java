package org.banxico.proyecto2.repository;

import org.banxico.proyecto2.entity.Customer;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class CustomerFacade extends AbstractFacade<Customer>
	implements CustomerFacadeLocal {

	@PersistenceContext
	private EntityManager em;
	
	public CustomerFacade() {
		super(Customer.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public void save(Customer entity) {
		entity.setCustomerId(super.findMax("Customer.findMax") + 1);
		entity.getAddress().setAddressId(super.findMax("Address.findMax") + 1);
		super.save(entity);
	}
}
