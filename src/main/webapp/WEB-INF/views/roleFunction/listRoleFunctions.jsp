<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Rolle: ${role.id}</h1>

<form:form action="${pageContext.request.contextPath}/saveRoleFunctions" method="POST" commandName="role"> 
	<table border="1">
		<tr>
			<th>Funktion</th>
			<th>Aufruf</th>
			<th>Lesen</th>
			<th>Schreiben</th>
			<th>Löschen</th>
			<th>Deaktivieren</th>
		</tr>
		<c:forEach items="${role.roleFunctions}" var="roleFunction" varStatus="index">
			<tr>
				<td>${roleFunction.function.description}</td>
				<td>${roleFunction.function.name}</td>
				<td><form:checkbox path="roleFunctions[${index.index}].readable" disabled="${!roleFunction.function.readableEditable}"/></td>
				<td><form:checkbox path="roleFunctions[${index.index}].writeable" disabled="${!roleFunction.function.writeableEditable}"/></td>
				<td><form:checkbox path="roleFunctions[${index.index}].deleteable" disabled="${!roleFunction.function.deleteableEditable}"/></td>
				<td><form:checkbox path="roleFunctions[${index.index}].deactivateable" disabled="${!roleFunction.function.deactivateableEditable}"/>
				<form:hidden path="roleFunctions[${index.index}].id"/></td>
			</tr>
		</c:forEach>
</table>

<form:hidden path="id"/>
<input type="submit" value="speichern">

</form:form>
