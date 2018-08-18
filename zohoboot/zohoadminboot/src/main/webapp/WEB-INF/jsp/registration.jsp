<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body topmargin="2">
	<h1>Hello new Registration</h1>
	<form:form action="userregistration" method="post"
		modelAttribute="registrationMap">
		
		<table border="3" align="center" cellpadding="2" cellspacing="2" background="pink" >
		<tr>
			<td> Email			: <form:input path="email" /></td>
		</tr>
		<tr>
			<td> password 			: <form:password path="password" /></td>
		</tr>
		<tr>					  					  		
			<td> firstname			: <form:input path="firstname" /></td>
		</tr>
		<tr>					  					  		
			<td> Lastname  			: <form:input path="lastname" /></td>
		</tr>
		<tr>					  					  		
			<td> Mobile no 			: <form:input path="mobileno" /></td>
		</tr>					  					  		
					<tr><td> <input type="submit" value="submit" /></td></tr>											 
	
	</table>
	</form:form>
</body>
</html>