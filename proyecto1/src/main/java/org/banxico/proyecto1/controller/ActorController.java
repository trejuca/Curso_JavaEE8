package org.banxico.proyecto1.controller;

import java.io.IOException;
import java.util.List;

import org.banxico.proyecto1.dao.ActorDao;
import org.banxico.proyecto1.entity.Actor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/actores")
public class ActorController extends HttpServlet {

	public static int ELIMINAR_ACTOR = 1;
	public static int CARGAR_ACTOR = 2;
	public static int ACTUALIZAR_ACTOR = 3;
	public static int GUARDAR_ACTOR = 4;
	
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		Integer tipoOperacion = 0;
		Integer id = 0;
		
		if (request.getParameter("tipoOperacion") != null) {
			tipoOperacion = Integer.parseInt(request.getParameter("tipoOperacion"));
		}
		
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		if (tipoOperacion == ELIMINAR_ACTOR) {
			delete(request, response, id);
		} else if (tipoOperacion == CARGAR_ACTOR) {
			loadActor(request, response, id);
		}
		
		listAll(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		Integer tipoOperacion = 0;
		
		if (request.getParameter("tipoOperacion") != null) {
			tipoOperacion = Integer.parseInt(request.getParameter("tipoOperacion"));
		}
		save(request, response, tipoOperacion);
		listAll(request, response);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
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
			HttpServletResponse response,
			Integer tipoOperacion) {
		
		Actor actor = new Actor();
		actor.setFirstName(request.getParameter("firstName"));
		actor.setLastName(request.getParameter("lastName"));
		
		if (tipoOperacion == GUARDAR_ACTOR) {
			ActorDao.save(actor);
		} else if (tipoOperacion == ACTUALIZAR_ACTOR) {
			actor.setActorId(Integer.parseInt(request.getParameter("id")));
			ActorDao.update(actor);
		}
	}
	
	private void loadActor(
			HttpServletRequest request,
			HttpServletResponse response,
			Integer id) {
		request.setAttribute("actor", ActorDao.findById(id));
	}
}
