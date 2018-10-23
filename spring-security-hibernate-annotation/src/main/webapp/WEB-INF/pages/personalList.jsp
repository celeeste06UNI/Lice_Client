<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eliminar usuario</title>
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
						<li><a href="newEmployee">Crear</a></li>
						<li><a href="viewEmployee">Eliminar/Editar</a></li>
					</ul></li>
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

		<div class="page-header">
			<div class="container">
				<h2>Eliminar/Editar Usuario</h2>
			</div>

		</div>
		<div class="container" align="left">
		<table class = "table table-hover">
		<p>Busque el usuario que desee y pulse "Eliminar" o "Editar" en el caso que quiera cambiar algún dato</p>
			<!-- <th>Id</th> -->
			<th>Nombre de Usuario</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Dirección</th>
			<th>Teléfono</th>
			<th>Acción</th>

			<c:forEach var="employee" items="${listPersonal}">
				<tr>
					<%-- <td>${employee.id}</td> --%>
					<td>${employee.username}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="<c:url value='/updateEmployee?id=${employee.id}&username=${employee.username}' />">Editar</a>
					- <a href="<c:url value='/deleteEmployee?id=${employee.id}&username=${employee.username}' />">Eliminar</a></td>

				</tr>
			</c:forEach>
		</table>
		</div>
	</sec:authorize>

	<%-- <div align="center">
		<h1>Employee List</h1>
		
		<table border="1">
			<th>Id</th>
			<th>Username</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listPersonal}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.username}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="<c:url value='/editEmployee?name=${employee.name}' />">Edit</a>
					<a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/deleteEmployee?name=${employee.name}">Delete</a>
						<a href="<c:url value='/deleteEmployee?id=${employee.id}&username=${employee.username}' />">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="newEmployee">here</a>
		</h4>
	</div> --%>
</body>

</html>