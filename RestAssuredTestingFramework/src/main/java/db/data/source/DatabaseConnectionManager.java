package db.data.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {

	private static DatabaseConnectionManager connectionManagerInstance;
	private Connection conn;
	
	public static DatabaseConnectionManager getConnectionManagerInstance() {
		
		if (connectionManagerInstance==null) {
			connectionManagerInstance = new DatabaseConnectionManager();
		}
		return connectionManagerInstance;
	}

	public Connection getConn() {
		return conn;
	}

	public void connect() {
		//String url = prop.getProperty("SQL_URL");
		//String pass= prop.getProperty("SQL_PASS");
		//String   root = prop.getProperty("SQL_ROOT");
	        
		 try {
	            conn = (Connection)DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");
	            
	            if (conn!=null) {
	                System.out.println("successfully connected to database...");
	            }
	         
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("cannot connect to database...");
	        }
	}

	public void disconnectDB() throws SQLException{
		conn.close();
		System.out.println("Disconnected from database...");
	}
}
