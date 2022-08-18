package businesslogic;

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
 * Servlet implementation class DisplayProductDetails
 */
@WebServlet("/DisplayProductDetails")
public class DisplayProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	 con= ProductDetails.getConnection();
	super.init();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			//Connection con= ProductDetails.getConnection();
			String str="select * from product";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(str);
			PrintWriter out=response.getWriter();
			while(rs.next()) {
				out.println(rs.getInt("productid")+"\t" +rs.getString("productname")+"\t"+rs.getFloat("price")+"\t"+rs.getString("quantity"));
				
			}
			
		}
		catch(Exception e)
		{
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
