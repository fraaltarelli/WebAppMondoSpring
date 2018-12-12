<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Continenti</title>
</head>
<body>
	<div style="text-align: center;">
		<form action="runAggiornamentoForm">
			<input name="newcitta" type="submit" value="NuovaCitta"> <input
				name="idCitta" type="hidden" value="0"> <input
				name="countryCode" type="hidden" value=" ">
		</form>
		<br>


		<c:forEach items="${allcontinents}" var="continente">
			<a href="runNazioni?continente=${continente}"> ${continente} </a>
			<br>
		</c:forEach>
	</div>
</body>
</html>