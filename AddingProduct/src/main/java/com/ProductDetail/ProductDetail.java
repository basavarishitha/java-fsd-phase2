package com.ProductDetail;

import java.io.IOException;


import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int price = Integer.parseInt(request.getParameter("txtprice"));
		String name = request.getParameter("txtName");
		//put values in an object
		Products prod = new Products();
		prod.setPrice(price);
		prod.setName(name);
		
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
		//open connection
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//save object as record
		int i=(Integer)session.save(prod);
		session.getTransaction().commit();
		
		session.close();
		PrintWriter out = response.getWriter();
		if (i > 0)
			out.println("Record inserted");
		else
			out.println("Record not inserted");
	}
	

}
