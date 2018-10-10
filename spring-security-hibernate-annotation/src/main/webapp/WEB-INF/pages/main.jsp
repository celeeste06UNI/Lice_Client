<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LiceDQTool</title>
<title>Webdisenia .:. Ejemplo barra navegación</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">LiceDQTool</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Inicio</a></li>
			<li><a href="#">Usuarios</a></li>
			<li><a href="#">Organizaciones</a></li>
			<li><a href="#">Proyectos</a></li>
			<li><a href="#">Reglas de Negocio</a></li>
			<li><a href="#">Modelo de Datos</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">


			<li><a href="#">Cerrar Sesion</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Trabajo de Fin de Grado</h3>
		<p>Celeste López Garrido</p>
	</div>

</body>
<footer>
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
</footer>
</html>