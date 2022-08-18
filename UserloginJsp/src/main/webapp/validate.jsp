<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uname=request.getParameter("txtname");
String pword=request.getParameter("txtpword");
if(uname.equalsIgnoreCase("Rishitha")&&pword.equalsIgnoreCase("NR@1216@aa")){
	getServletContext().getRequestDispatcher("/validate2.jsp").forward(request, response);
	
}
else
{
	out.println("Invalid User or Password ");
	getServletContext().getRequestDispatcher("/Login.jsp").include(request,response);
	
}
//out.println("<a href='validate2.jsp?txtname= "+uname+" '>validate2</a>");


%>

</body>
</html>