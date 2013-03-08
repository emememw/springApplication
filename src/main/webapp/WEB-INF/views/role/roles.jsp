<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<ul>
<c:forEach items="${roles}" var="role">
	
		<li>
			<form action="" method="GET">
				${role.id} 
				<input type="submit" value="bearbeiten">
			</form>
		</li>
</c:forEach>
</ul>