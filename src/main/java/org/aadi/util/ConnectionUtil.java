package org.aadi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	static {

		try {
			Class.forName("org.postgresql.Driver"); //for MySQL, use driver as "com.mysql.cj.jdbc.Driver"
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}

	}

	public static Connection createDBConnection(String dbUrl, String username, String password) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}