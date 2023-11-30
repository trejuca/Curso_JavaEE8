package org.banxico.proyecto1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.banxico.proyecto1.entity.Actor;

public class ActorDao {

	public static void save(Actor actor) {
		
		String query = "INSERT INTO actor("
				+ "first_name, last_name)"
				+ "values(?, ?)";
		
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Actor> getAll() {
		
		String query = "SELECT * FROM actor";
		Connection connection = ConnectionUtil.getConnection();
		
		List<Actor> actores = new ArrayList<>();
		Actor actor = null;
		
		try {
			ResultSet rs = connection.createStatement().executeQuery(query);
			
			while(rs.next()) {
				actor = new Actor();
				actor.setActorId(rs.getInt("actor_id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				
				actores.add(actor);
			}
			
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actores;
	}
	
	public static void delete(Integer actorId) {
		
		String query = "DELETE FROM actor WHERE actor_id = ?";
		
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, actorId);
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update(Actor actor) {
		
		String query = "UPDATE actor SET "
				+ "first_name = ?, "
				+ "last_name = ? "
				+ "WHERE actor_id = ?";
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			statement.setInt(3, actor.getActorId());
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
