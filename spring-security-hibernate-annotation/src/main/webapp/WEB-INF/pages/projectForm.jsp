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
<title>nuevo proyecto</title>
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
	<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
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
						<li><a href="viewOpenProject">Proyectos activos</a></li>
						<li><a href="viewCloseProject">Proyectos cerrados</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Modelo de Datos <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="viewUpload">Crear</a></li>
						<li><a href="viewDatamodel">Visualizar</a></li>
						<li><a href="deleteDataModel">Eliminar</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Reglas de Negocio <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newRule">Crear</a></li>
						<li><a href="#">Eliminar</a></li>
						<li><a href="#">Modificar</a></li>
					</ul></li>
				<li><a href="#">Catalogo</a></li>
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
				<h2>Nuevo Proyecto</h2>
			</div>
		</div>


		<div class="container" align="center">
			<form:form action="${cp}/saveProject" method="POST"
				modelAttribute="organization">
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Organización:</label>
					<div class="col-sm-10">
						<select class="form-control" name="organization" id="organization">
							<c:forEach var="organization" items="${organizationList}">
								<option value="${organization.id}">${organization.name_org}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Modelo de
						Datos:</label>
					<div class="col-sm-10">
						<select class="form-control" name="datamodel" id="datamodel">
							<c:forEach var="datamodel" items="${datamodelList}">
								<option value="${datamodel.id_datamodel}">${datamodel.database_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Consultor
						asociado:</label>
					<div class="col-sm-10">
						<select class="form-control" name="personal" id="personal">
							<c:forEach var="personal" items="${personalList}">
								<option value="${personal.id}">${personal.username}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2" align="right">Fecha
						de Inicio:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="start_date" required
							autocomplete="off" placeholder="yyyy/MM/dd">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2" align="right">Fecha
						de Fin Estimada:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="finish_date"
							required autocomplete="off" placeholder="yyyy/MM/dd">
					</div>
				</div>		
				&nbsp
				<div class="container" align="center">
					<button type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</form:form>
		</div>

		<%-- <div class="container" align="center">
			<form:form action="${cp}/saveOrganization" method="POST"
				modelAttribute="organization">
				<!-- 				<div class="form-group">
					<label class="control-label col-sm-2">id:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="id"
							placeholder="Introduzca el cif de la organización">
					</div>
				</div> -->
				<div class="form-group">
					<label class="control-label col-sm-2">CIF:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="cif"
							placeholder="Introduzca el cif de la organización">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2">Nombre:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name_org"
							placeholder="Introduzca el nombre de la organización">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2">Razón Social:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name_trade"
							placeholder="Introduzca la razón social">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2">Persona de Contacto:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name_contact"
							placeholder="Introduzca el nombre de la persona de contacto">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2">Rol del Contacto:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="role_contact"
							placeholder="Introduzca el rol de la persona de contacto">
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2">Teléfono de Contacto:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="telephone_contact"
							placeholder="Introduzca el teléfono de la persona de contacto">
					</div>
				</div>
				&nbsp
				<div class="container" align="center">
					<button type="submit" class="btn btn-primary">Guardar</button>
				</div>


			</form:form>
		</div> --%>
	</sec:authorize>
</body>
</html>