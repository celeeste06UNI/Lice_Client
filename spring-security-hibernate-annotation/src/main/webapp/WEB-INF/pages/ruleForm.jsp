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
<title>nueva regla</title>
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
				<h2>Nueva Regla</h2>
			</div>

		</div>
		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Informacion principal</strong>
				</h4>
				<form:form action="${cp}/selectProject" method="GET">
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Proyecto:</label>
						<div class="col-sm-10">
							<select class="form-control" name=project id="project">
								<c:forEach var="project" items="${projectList}">
									<option value="${project.id}">${project.proj_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				&nbsp
				<div class="form-group">
						<label class="control-label col-sm-2" align="right">Numero
							de atributos:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="numberAt" required
								autocomplete="off" placeholder="Nº de atributos en la regla">
						</div>
					</div>
				&nbsp
				<div class="container" align="center">
						<button type="submit" class="btn btn-primary">Cargar
							datos</button>
					</div>
				&nbsp
				</form:form>
			</div>
		</div>
		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Construya la regla</strong>
				</h4>
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Operadores
						Modales:</label>
					<div class="col-sm-10">
						<select class="form-control" name=project id="project">
							<option value="es obligatorio que">Es obligatorio que...</option>
							<option value="es obligatorio que">Es obligatorio que...</option>
						</select>
					</div>
				</div>
				<c:forEach var="i" begin="1" end="${numerAtFor}">
         			&nbsp
         			<div class="w3-panel w3-leftbar w3-border-blue">
						&nbsp
						<h6>
							<strong>Atributo ${i}</strong>
						</h6>
						&nbsp
						<div class="form-group">
							<label class="control-label col-sm-2" align="right">Cuantificadores:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="numberAt" disabled
									placeholder="el campo">
							</div>
						</div>
						&nbsp
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="exampleFormControlSelect1" align="right">Terminos:</label>
							<div class="col-sm-10">
								<select class="form-control" name=project id="project">
									<option value="es obligatorio que">Es obligatorio
										que...</option>
									<option value="es obligatorio que">Es obligatorio
										que...</option>
								</select>
							</div>
						</div>
						&nbsp
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="exampleFormControlSelect1" align="right">Verbos:</label>
							<div class="col-sm-10">
								<select class="form-control" name=project id="project">
									<option value="es obligatorio que">sea</option>
									<option value="es obligatorio que">puede</option>
								</select>
							</div>
						</div>
						&nbsp
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="exampleFormControlSelect1" align="right">Operadores
								Lógicos:</label>
							<div class="col-sm-10">
								<select class="form-control" name=project id="project">
									<option value="no">no</option>
									<option value="-">-</option>
								</select>
							</div>
						</div>
						&nbsp
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="exampleFormControlSelect1" align="right">Otras
								palabras:</label>
							<div class="col-sm-10">
								<select class="form-control" name=project id="project">
									<option value="nulo">nulo</option>
									<option value="-">-</option>
								</select>
							</div>
						</div>
						&nbsp
					</div>
					&nbsp
				</c:forEach>


				&nbsp
			</div>
		</div>
		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp

				<h4>
					<strong>Visualice la regla</strong>
				</h4>

				<div class="form-group">
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary">Cargar
							regla</button>
					</div>
					<div class="col-sm-10">
						<textarea class="form-control" rows="5" id="comment">${ completeRule}</textarea>
					</div>
				</div>
				&nbsp
			</div>
		</div>

		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp

				<h4>
					<strong>Información adicional</strong>
				</h4>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Propiedad de
						la Calidad:</label>
					<div class="col-sm-10">
						<select class="form-control" name=propiedad id="propiedad">
							<option value="propiedad1">propiedad1</option>
							<option value="propiedad2">propiedad2</option>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Estado:</label>
					<div class="col-sm-10">
						<select class="form-control" name=estado id="estado">
							<option value="estado1">estado1</option>
							<option value="estado2">estado2</option>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Criticidad:</label>
					<div class="col-sm-10">
						<select class="form-control" name=criticidad id="criticidad">
							<option value="criticidad1">criticidad1</option>
							<option value="criticidad2">criticidad2</option>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2"
						for="exampleFormControlSelect1" align="right">Prioridad:</label>
					<div class="col-sm-10">
						<select class="form-control" name=prioridad: id="prioridad:">
							<option value="prioridad1">prioridad1</option>
							<option value="prioridad2">prioridad2</option>
						</select>
					</div>
				</div>
				&nbsp
				<div class="form-group">
					<label class="control-label col-sm-2" align="right">Version:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="version"
							placeholder="indique la version">
					</div>
				</div>
				&nbsp

			</div>
		</div>
		&nbsp
				<div class="container" align="center">
			<button type="submit" class="btn btn-primary">Crear Regla</button>
		</div>
		&nbsp
	</sec:authorize>
</body>
</html>