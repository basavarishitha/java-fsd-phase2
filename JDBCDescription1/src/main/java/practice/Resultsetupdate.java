package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultsetupdate
 */
@WebServlet("/Resultsetupdate")
public class Resultsetupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultsetupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try {
			Connection con = DatabaseConnection.getMyConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT S.* FROM student S");
			out.println("Before Changes All Records...<br>");
			out.println("Rollno  Name<br>");
			while (rs.next()) {
				out.println(rs.getInt(1) + "      " + rs.getString(2) + "<br>");
				
			}
			rs.moveToInsertRow();
			rs.updateInt("rollno", 16);
			rs.updateString("name", "Kareena");
			rs.updateInt("marks", 50);
			rs.insertRow();
			rs.absolute(2);
			rs.updateString("name", "Seetha");
			rs.updateRow();
			out.println("After Changes All Records...<br>");
			rs.beforeFirst();
			while (rs.next()) {
				out.println(rs.getInt(1) + "      " + rs.getString(2) + "<br>");
			}
		}
			catch(Exception e) {
				out.println(e);
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
