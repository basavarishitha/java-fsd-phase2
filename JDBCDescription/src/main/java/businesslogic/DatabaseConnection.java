package businesslogic;
import java.sql.*;

public class DatabaseConnection {
	static Connection con=null;
	public static Connection getMyConnection(String dbURL, String user,String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,user,pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
