<!DOCTYPE html>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"
	scope="request" />
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/SpringSecurity/main">LiceDQTool</a>
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
							<li><a href="main/newProject">Crear</a></li>
							<li><a href="main/viewOpenProject">Proyectos activos</a></li>
							<li><a href="main/viewCloseProject">Proyectos cerrados</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Modelo de Datos <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="main/viewUpload">Crear</a></li>
							<li><a href="main/viewDatamodel">Visualizar</a></li>
							<li><a href="main/deleteDataModel">Eliminar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Reglas de Negocio <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="main/newRule">Crear</a></li>
							<li><a href="main/viewRule">Visualizar</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Catalogo <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="main/newCatalogue">Crear</a></li>
							<li><a href="main/viewCatalogue">Eliminar/Modificar</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Generar codigo <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Regla</a></li>
							<li><a href="#">Tabla</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="${cp}/logout"><span
							class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a><span class="glyphicon glyphicon-user"> </span>
							${pageContext.request.userPrincipal.name}</a></li>
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

	<div class="container-fluid">
		<div class="jumbotron">

			<h1>Trabajo de Fin de Grado</h1>
			<p>Herramienta de soporte al ciclo de vida de la evaluación de la
				calidad de datos.</p>
			<!-- <h6>Celeste López Garrido</h6> -->
		</div>

	</div>
	<!-- 	<!-- Left-aligned
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4" >
				<div class="media-left">
					<img src="foto.jpg" class="media-object" style="width: 60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">Celeste López Garrido</h4>
					<p>Alumno</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="media-left">
					<img src="foto.jpg" class="media-object" style="width: 60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">Ismael Caballero</h4>
					<p>Director</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="media-left">
					<img src="foto.jpg" class="media-object" style="width: 60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">Fernando Gualo</h4>
					<p>Tutor</p>
				</div>
			</div>
		</div>

	</div>

 -->

</body>

</html>