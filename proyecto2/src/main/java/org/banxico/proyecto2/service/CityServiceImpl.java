package org.banxico.proyecto2.service;

import java.util.List;
import org.banxico.proyecto2.entity.City;
import org.banxico.proyecto2.repository.CityFacadeLocal;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class CityServiceImpl implements CityService {

	@Inject
	private CityFacadeLocal cityFacadeLocal;
	
	@Override
	public List<City> findAll() {
		return cityFacadeLocal.findAll();
	}

}
