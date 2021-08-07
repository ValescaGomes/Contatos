package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	Connection getConnection() {
		try { 
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/listadecontatos?useTimezone=true&serverTimezone=UTC", "teste","Teste123456");
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}