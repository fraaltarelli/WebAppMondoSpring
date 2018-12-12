<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">

		<a href="runContinenti">
			<button>ritorna ai continenti</button> <br>
		</a> <br>

		<form action="runSalvaCitta">
			<table width="75%" border="1" align="center">
				<tr>
					<th width="34%">Seleziona la Nazione:</th>
					<th with="22%">Digita il nome della citta</th>
					<th with="22%">Digita il nome del distretto</th>
					<th with="22%">Digita il numero di abitanti</th>
				</tr>
			</table>

			<table width="75%" border="1" align="center">
				<tr>
					<td width="34%"><select name="countrycode">

							<c:forEach items="${allNations}" var="nazione">
								<c:choose>
									<c:when test="${nazione.code == cittaDaModificare.countryCode}">
										<option value="${nazione.code}" selected>${nazione.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${nazione.code}">${nazione.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>

					<td width="22%"><input name="nomecittainserito" type="text"
						value="${cittaDaModificare.name}"></td>

					<td width="22%"><input name="nomedistrettoinserito"
						type="text" value="${cittaDaModificare.district}"></td>
					<td width="22%"><input name="popolazioneinserita"
						type="number" min="0" value="${cittaDaModificare.population}">
					</td>



				</tr>

			</table>

			<input name="id" type="hidden" value="${cittaDaModificare.id}">

			<br> <input name="SalvaCitta" type="submit" value="Salva Citta">

		</form>

	</div>


</body>
</html>