<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cp" value="${pageContext.request.contextPath}"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>vista previa</title>
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
						<li><a href="main/newCode">Regla</a></li>
						<li><a href="main/newCodeTable">Tabla</a></li>
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

		<div class="page-header">
			<div class="container">
				<h2>Vista previa del Código generado</h2>
				<p>Script Sql generado para la regla de negocio</p>
			</div>

		</div>
		<div class="container" align="left">
			<form:form action="${cp}/saveSql" method="POST">

				<div class="form-group">
					<textarea class="form-control" rows="7" id="regla" name="regla">${sql}</textarea>
				</div>
				&nbsp
				<div class="container" align="right">
					<button type="submit" class="btn btn-primary" name="ImprimirRu">Guardar</button>
				</div>

			</form:form>

			<%-- <a href="<c:url value='/guardar' />">Guardar</a> <input type="button"
				name="imprimir" value="Imprimir" onclick="window.print();"> --%>

		</div>
	</sec:authorize>
</body>
</html>