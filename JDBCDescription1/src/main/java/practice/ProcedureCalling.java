package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcedureCalling
 */
@WebServlet("/ProcedureCalling")
public class ProcedureCalling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcedureCalling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int rollno=Integer.parseInt(request.getParameter("txtrollno"));
		try {
			Connection con = DatabaseConnection.getMyConnection();
			CallableStatement stmt = con.prepareCall("{call getRecord(?,?,?)}");
			stmt.setInt(1, rollno);
			stmt.registerOutParameter(2,Types.VARCHAR);
			stmt.registerOutParameter(3, Types.INTEGER);
			stmt.execute();
			PrintWriter out=response.getWriter();
			out.println("<table border=2>");
			out.println("<tr><th>Rollno</th><th>Name</th><th>Marks</th></tr>");
			out.println("<tr>");
			out.print("<td>" + rollno + "</td>");
			out.print("<td>" + stmt.getString(2) + "</td>");
			out.print("<td>" + stmt.getInt(3) + "</td>");
			out.println("</tr>");
			out.println("</table>");

			 con.close();
			
		}
		catch(Exception e) {
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
