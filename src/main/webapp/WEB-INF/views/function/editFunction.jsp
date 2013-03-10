<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${errors!=null}">
	<c:forEach items="${errors}" var="error">
		<p>Fehler: ${error.defaultMessage}</p>
	</c:forEach>
</c:if>

<c:if test="${function.id!=null}">
	<form
		action="${pageContext.request.contextPath}/deleteFunction/${function.id}"
		method="POST">
		<input type="submit" value="löschen">
	</form>
</c:if>

<form:form action="${pageContext.request.contextPath}/saveFunction"
	method="POST" commandName="function">
	
	<form:hidden path="id"/>
	
	<label>Name:</label>
	<form:input path="name" />
	
	<label>Beschreibung:</label>
	<form:input path="description"/>
	
	<br>
	<br>
	
	<table border="1">
		<tr>
			<th>Typ</th>
			<th>Default-Wert</th>
			<th>Editierbar</th>
		</tr>
		<tr>
			<td>Lesen</td>
			<td><form:checkbox path="readableByDefault"/></td>
			<td><form:checkbox path="readableEditable"/></td>
		</tr>
		<tr>
			<td>Schreiben</td>
			<td><form:checkbox path="writeableByDefault"/></td>
			<td><form:checkbox path="writeableEditable"/></td>
		</tr>
		<tr>
			<td>Löschen</td>
			<td><form:checkbox path="deleteableByDefault"/></td>
			<td><form:checkbox path="deleteableEditable"/></td>
		</tr>
		<tr>
			<td>Deaktivieren</td>
			<td><form:checkbox path="deactivateableByDefault"/></td>
			<td><form:checkbox path="deactivateableEditable"/></td>
		</tr>
	</table>
	
	<br>
	
	<input type="submit" value="speichern">

</form:form>

