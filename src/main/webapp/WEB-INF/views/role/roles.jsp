<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<ul>
<c:forEach items="${roles}" var="role">
	<li>${role.id}</li>
</c:forEach>
</ul>