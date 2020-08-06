<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   <!-- Dentro to apache procure o lib para tag de jstl -->
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- c ta como prefixo da biblioteca jstl -->

	
	<c:set var="data" scope="page" value="${500*3 }"/>
	<c:out value="${data}" />

	<c : chose>
	
	
	</chose> :

	<p/>
	<p/>
	<p/>
	<p/>
	<form action="LoginServlet" method="post"> <!-- esse formulario procura pela servlet conforme ta no action -->
		
		Login :
		<input type="text" id="login" name="login">
		<br/>
		Senha:
		<input type="text" id="senha" name="senha">
		<br/>
		<input type="submit" value="logar">
	
	</form>
	
	
</body>
</html>