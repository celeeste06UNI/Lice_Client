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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modelo de datos</title>
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
						<li><a href="main/newProject">Crear</a></li>
						<li><a href="#">Proyectos activos</a></li>
						<li><a href="#">Proyectos cerrados</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Modelo de Datos <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="main/viewUpload">Crear</a></li>
						<li><a href="main/viewDatamodel">Visualizar</a></li>
						<li><a href="#">Eliminar</a></li>
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
				<h2>Modelo de Datos</h2>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<h4 align="center">Modelo de datos</h4>
					<c:forEach var="datamodel" items="${datamodelList}">
						<a align="center" class="list-group-item"
							href="<c:url value='/viewTable?id_datamodel=${datamodel.id_datamodel}' />">${datamodel.database_name}</a>
					</c:forEach>
				</div>
				<div class="col-sm-4">
					<h4 align="center">Tablas</h4>
					<div class="list-group">
						<c:forEach var="tableDatamodel" items="${datamodelDecriptList}">
							<a align="center" class="list-group-item"
								href="<c:url value='/viewAttribute?table_name=${tableDatamodel}' />">${tableDatamodel}</a>
							<%-- <a href="#" class="list-group-item">${tableDatamodel}</a> --%>
						</c:forEach>
					</div>
				</div>
				<div class="col-sm-4">
					<h4 align="center">Atributos</h4>
					<div class="list-group">
						<c:forEach var="attribute" items="${attributes}">
							<a align="center" class="list-group-item" href="#">${attribute}</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</sec:authorize>
</body>

</html>