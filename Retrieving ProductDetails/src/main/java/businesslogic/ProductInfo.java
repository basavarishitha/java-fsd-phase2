package businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductInfo
 */
@WebServlet("/ProductInfo")
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int productid=Integer.parseInt(request.getParameter("txtid"));
		try {
			Connection con=DatabaseConnection.getMyConnection();
			String str="select * from product where productid=?";
			PreparedStatement ps =con.prepareStatement(str);
			ps.setInt(1, productid);
			ResultSet rs =ps.executeQuery();
			PrintWriter out=response.getWriter();
			if(rs.next()==false)
				out.println("No Product Record is found!!!");
			else
			{
				String Product_Name=rs.getString("productname");
				int Product_Price=rs.getInt("price");
				String Product_Quantity=rs.getString("quantity");
				out.println(Product_Name+"\t"+Product_Price +"\t" + Product_Quantity);
				
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
