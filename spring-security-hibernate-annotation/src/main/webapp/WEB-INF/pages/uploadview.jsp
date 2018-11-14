<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cp" value="${pageContext.request.contextPath}"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload Files</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<li><a href="newOrganization">Crear</a></li>
						<li><a href="viewOrganization">Eliminar/Editar</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Proyectos <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newProject">Crear</a></li>
						<li><a href="#">Proyectos activos</a></li>
						<li><a href="#">Proyectos cerrados</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Modelo de Datos <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="viewUpload">Crear</a></li>
						<li><a href="viewDatamodel">Visualizar</a></li>
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
				<h2>Nuevo Modelo de Datos</h2>
			</div>
		</div>
		<div class="container" align="center">
			<form action="${cp}/upload" method="post"
				enctype="multipart/form-data">

				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Sistema
						gestos de Base de Datos:</label>
					<div class="col-sm-10">
						<select class="form-control" name="sistemabbdd" id="sistemabbdd">
							<option value="mysql">MySql</option>
							<option value="sqlserver">SQLServer</option>
							<option value="oracle">Oracle</option>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2" align="right">Version:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="version"
							placeholder="Introduzca el nombre">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2" align="right">Archivo:</label>
					<div class="col-sm-10">
						<input type="file" name="files" multiple>
					</div>
				</div>
				&nbsp
				<div class="container" align="center">
					<input type="submit" class="btn btn-primary" value="Upload Files"></input>
				</div>
				<!-- <input type="file" name="files" multiple> 
				<input type="submit" class="btn btn-primary" value="Upload Files"></input> -->
			</form>
		</div>
	</sec:authorize>


	<%-- 	<form action="${cp}/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple> <input type="submit"
			value="Upload Files"></input>
	</form> --%>

</body>
</html>