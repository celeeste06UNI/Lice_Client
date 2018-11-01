<!DOCTYPE html>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">LiceDQTool</a>
				</div>
				<ul class="nav navbar-nav">
					<!-- <li class="active"><a href="#">Home</a></li> -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Usuarios <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="main/newEmployee">Crear</a></li>
							<li><a href="main/viewEmployee">Eliminar/Editar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Organizaciones <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="main/newOrganization">Crear</a></li>
							<li><a href="main/viewOrganization">Eliminar/Editar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Proyectos <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Modelo de Datos <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Reglas de Negocio <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">LiceDQTool</a>
				</div>
				<ul class="nav navbar-nav">
					<!-- <li class="active"><a href="#">Home</a></li> -->
					<!-- 					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Usuarios <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li> -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Organizaciones <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Proyectos <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Modelo de Datos <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Reglas de Negocio <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Crear</a></li>
							<li><a href="#">Eliminar</a></li>
							<li><a href="#">Modificar</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</sec:authorize>


	<div class="jumbotron">
		<div class="container">
			<h1>Trabajo de Fin de Grado</h1>
			<p>Herramienta de soporte al ciclo de vida de la evaluación de la
				calidad de datos.</p>
			<h6>Celeste López Garrido</h6>
		</div>

	</div>



</body>
</html>