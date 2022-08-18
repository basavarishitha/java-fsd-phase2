<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Program to print 5 times</title>
</head>
<body>
<form action="User.jsp">
<input type="text" name="txtnum" required>
<input type="submit">
</form>
<%
	String snum= request.getParameter("txtnum");
if(snum!=null){
	int num=Integer.parseInt(snum);
	for(int i=1;i<=5;i++){
		out.println(num*i+"<br>");
	}
}

	

%>


</body>
</html>