package org.banxico.proyecto2.repository;

import org.banxico.proyecto2.entity.City;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CityFacade extends AbstractFacade<City>
	implements CityFacadeLocal {

	@PersistenceContext
	private EntityManager em;
	
	public CityFacade() {
		super(City.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
