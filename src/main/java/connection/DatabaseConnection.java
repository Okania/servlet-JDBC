package connection;

import java.sql.*;

public class DatabaseConnection {
	
	protected static Connection initDatabase() throws SQLException,ClassNotFoundException {
		
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String URL = "jdbc:mysql://localhost:3306/mytest";
	    String USER = "root";
	    String PASSWORD = "";
	    
	    
	    Class.forName(DRIVER);
	    
	    Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}
}
