package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
		
	static String status = "Error to connect...";
	
	public static Connection getConnectionMySQL()
	{
		Connection connection = null;
		
		try{
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			
			String serverName = "localhost";
			String mydatabase = "tcc";
			String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase + "?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url,username,password);
			
			if(connection != null) {
				status = ("Connect with success!");
			}
			else {
				status = ("Error to connect!");
			}
			return connection;
		} catch(ClassNotFoundException e) {
			System.out.println("The specified driver was not found");
			return null;
		} catch(SQLException e) {
			
			System.out.println("Error to connect in the database");
			e.printStackTrace();
		}
		
		return connection;
	}
	public static String statusConection(){
		return status;
	}
	public static boolean CloseConnection(){
		try{
			GetConnection.getConnectionMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static Connection RestartConnection() {
		CloseConnection();
		return GetConnection.getConnectionMySQL();
	}
	
	public static String getStatus(){
		return status;
	}
}
