package org.banxico.proyecto1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase utilitaria para gestionar la conexion 
 * a la base de datos
 * 
 * @author jc
 */
public class ConnectionUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1/sakila";
	private static final String USER = "root";
	private static final String PASSWORD = "hola123";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error al conectarse a la base de datos");
		}
	}
}
