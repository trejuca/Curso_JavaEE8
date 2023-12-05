package org.banxico.proyecto2.repository;

import java.util.List;

import org.banxico.proyecto2.entity.City;

import jakarta.ejb.Local;

@Local
public interface CityFacadeLocal {
	public List<City> findAll();
}
