<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="index.jsp">
<input type="text" name="txtuser" required>
<input type="text" name="txtpword" required>
<input type="submit">
</form>
<%
String user=request.getParameter("txtuser");
String password=request.getParameter("txtpword");
if(user!=null && password!=null){
	boolean result = validate(user,password);
	if(result == true)
		out.println("Welcome" +user);
	else
		out.println("Invalid User name and Password");
}
%>
<%! boolean validate(String user,String password){
	if(user.equalsIgnoreCase("Rishi") && password.equals("rishi@123"))
		return true;
	else
		return false;
}
	%>


</body>
</html>