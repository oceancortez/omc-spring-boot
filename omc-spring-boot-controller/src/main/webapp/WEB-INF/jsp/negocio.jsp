<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP
Código Negócio: ${negocio.cdNgoco}

<hr>
JSP
negocios: 

<table border="1">
<tr>
	<th>Código Negócio</th>
	<th>Nome da CIA</th>
	<th>Código do Ramo</th>
	<th>Código da Apólice</th>
</tr>
<c:if test="${not empty negocios}">
	<c:forEach var="negocio" items="${negocios}">
	<tr>
		<td><span class="style10">${negocio.cdNgoco}</span></td>
		<td><span class="style10">${negocio.nmCia}</span></td>
		<td><span class="style10">${negocio.cdRamo}</span></td>
		<td><span class="style10">${negocio.cdApolice}</span></td>
		
	</tr>
	</c:forEach>
</c:if>
</table>
</body>
</html>