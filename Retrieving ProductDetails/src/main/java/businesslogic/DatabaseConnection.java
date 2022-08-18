package businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	static Connection con=null;
	public static Connection getMyConnection() {
		try{   
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/practice";
			String user = "root";
			String password = "NR@1216@aa";
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
	}
}