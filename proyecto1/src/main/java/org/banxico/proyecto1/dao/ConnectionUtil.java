package org.banxico.proyecto1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase utilitaria para gestionar la conexion 
 * a la base de datos
 * 
 * @author jc
 */
public class ConnectionUtil {

	private static final String URL = 
			"jdbc:sqlite:C:\\bases\\DB.Browser.for.SQLite-3.12.2-win64\\sakila.db";
	
	//private static final String USER = "sa";
	//private static final String PASSWORD = "hola123.";
	
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from actor");
		
		while(rs.next()) {
			System.out.println(rs.getString("first_name") + ", " + rs.getString("last_name"));
		}
	}
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error al conectarse a la base de datos");
		}
	}
}
