<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>

<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			<h1>Hola</h1>
	</form>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

</body>
</html>