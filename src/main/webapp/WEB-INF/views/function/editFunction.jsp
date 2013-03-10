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
	
	<input type="submit" value="speichern">

</form:form>

