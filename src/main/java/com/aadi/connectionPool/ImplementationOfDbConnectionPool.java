package com.aadi.connectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.aadi.util.ConnectionUtil;

public class ImplementationOfDbConnectionPool {
	
	private List<Connection> availableConnections = new ArrayList<>();
	private List<Connection> occupiedConnections = new ArrayList<>();
	
	public static ImplementationOfDbConnectionPool getDbConnectionPool(String dbUrl, String username, String password, int initialCapacity) {
		return new ImplementationOfDbConnectionPool(dbUrl,username,password,initialCapacity);
		
	}
	
	private ImplementationOfDbConnectionPool(String dbUrl, String username, String password, int initialCapacity) {
		for(int i=0; i<initialCapacity; i++) {
			try {
				this.availableConnections.add(ConnectionUtil.createDBConnection(dbUrl,username,password));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection retrieveConnection() {
		Connection connection = null;
		if(availableConnections.isEmpty()) {
			System.out.println("No Connection Available.");
		}else {
			connection = availableConnections.get(0);
			occupiedConnections.add(connection);
			availableConnections.remove(0);
			System.out.println("Connection Received.");
		}
		return connection;
	}

	public boolean release(Connection connection) {
		availableConnections.add(connection);
		boolean isRemoved = occupiedConnections.remove(connection);
		System.out.println("Connection Released : "+isRemoved);
		return isRemoved;
	}
	
	public void printStatsOnConsole() {
		System.out.println("Available Connections = " + availableConnections.size());
		System.out.println("Connections are in use = " + occupiedConnections.size());
	}
	
}