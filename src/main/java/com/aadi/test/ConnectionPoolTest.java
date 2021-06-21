package com.aadi.test;

import java.sql.Connection;

import com.aadi.connectionPool.ImplementationOfDbConnectionPool;

public class ConnectionPoolTest {

	public static void main(String[] args) {
		ImplementationOfDbConnectionPool dbConnectionPool = ImplementationOfDbConnectionPool
			.getDbConnectionPool("jdbc:postgresql://localhost:5432/test", "postgres", "root", 10);  
		//use "jdbc:mysql://localhost:3306/test" as dbUrl, and username,password according to your MySQL datasource details.
		
		Connection con1 = dbConnectionPool.retrieveConnection();
		@SuppressWarnings("unused")
		Connection con2 = dbConnectionPool.retrieveConnection();
		dbConnectionPool.printStatsOnConsole();
		dbConnectionPool.release(con1);
		dbConnectionPool.printStatsOnConsole();
	}
	
}