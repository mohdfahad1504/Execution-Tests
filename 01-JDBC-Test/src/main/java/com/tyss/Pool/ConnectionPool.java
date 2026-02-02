package com.tyss.Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/test_db?user=postgres&password=root";
	private static final int POOL_SIZE = 5;
	private static List<Connection> conList = new ArrayList<Connection>();
	
	static {
		for(int i = 1; i <= POOL_SIZE; i++) {
			conList.add(createConnection());
		}
	}
	
	private static Connection createConnection() {
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection giveConnection() {
		
		if(!conList.isEmpty()) {
			return conList.remove(0);
		} else {
			return createConnection();
		}
	}
	
	public static void submitConnection(Connection con) {
		if(conList.size() < POOL_SIZE) {
			conList.add(con);
		} else {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
