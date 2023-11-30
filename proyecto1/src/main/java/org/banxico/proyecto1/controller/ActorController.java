package org.banxico.proyecto1.controller;

import java.util.List;

import org.banxico.proyecto1.dao.ActorDao;
import org.banxico.proyecto1.entity.Actor;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActorController extends HttpServlet {

	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		listAll(request, response);
		delete(request, response, 1);
	}
	
	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		listAll(request, response);
	}
	
	private void listAll(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		// Spring DI Dependency Injection
		// Java Dependency Injection -> EE
		// Esto no se debe hacer, lo de la linea 33
		// ActorDao actorDao = new ActorDao();
		
		List<Actor> actors = ActorDao.getAll();
		request.setAttribute("actorsList", actors);
	}
	
	private void delete(
			HttpServletRequest request,
			HttpServletResponse response,
			Integer id) {
		ActorDao.delete(id);
	}
	
	private void save(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		Actor actor = new Actor();
		actor.setFirstName(request.getParameter("firstName"));
		actor.setLastName(request.getParameter("lastName"));
		
		ActorDao.save(actor);
	}
}
