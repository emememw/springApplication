<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form action="newFunction" method="GET">
	<input type="submit" value="neue Funktion">
</form>

<ul>
<c:forEach items="${functions}" var="function">
	<li>
		<form action="editFunction/${function.id}" method="GET">
			${function.name}
			<input type="submit" value="bearbeiten">
		</form>
	</li>
</c:forEach>
</ul>