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
<style type="text/css">
.titulo_boton {
	float: left;
	padding: 5px;
	background-color: #c2d7e1;
	width: 100%;
	font-family: helvetica;
	font-size: 16px;
	/* font-weight: bold; */
	/* 	font-style: italic; */
}

.boton_mostrar {
	float: right;
	font-size: 18px;
	line-height: 30px;
	color: #046392;
}

#contenido {
	float: left;
	clear: both;
	border: 2px solid #e6e6e6;
	margin-top: 2px;
	padding: 5px;
	width: 100%;
	overflow: auto;
	font-family: helvetica;
	font-size: 14px;
	text-align: justify;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eliminar/editar regla</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
	function muestra_oculta(id) {
		if (document.getElementById) { //se obtiene el id
			var el = document.getElementById(id); //se define la variable "el" igual a nuestro div
			el.style.display = (el.style.display == 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
		}
	}
	window.onload = function() {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
		muestra_oculta('contenido');/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
	}
</script>
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
						<li><a href="viewRule">Visualizar</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Catalogo <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newCatalogue">Crear</a></li>
						<li><a href="viewCatalogue">Eliminar/Modificar</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Generar codigo <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newCode">Regla</a></li>
						<li><a href="newCodeTable">Tabla</a></li>
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
				<h2>Gestión de Reglas en Catálogos</h2>
				<p>Busque la regla que desee gestionar. Pulse + si desea añadir
					la regla a un catalogo o por el contrario pulse la papelera si
					desea eliminar la regla de algún catálogo</p>
			</div>


		</div>


		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Informacion principal</strong>
				</h4>
				<form:form name='cargarForm' action="${cp}/deleteRuleProjCatalogue"
					method="GET">
					<input id="id_proj" type="hidden" class="form-control"
						name="id_proj" value="${id_proj}">
					<input id="id_rule" type="hidden" class="form-control"
						name="id_rule" value="${id_rule}">
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Catálogo:</label>
						<div class="col-sm-10">
							<select class="form-control" name=catalogue id="catalogue">
								<c:forEach var="catalogue" items="${listaCatalogos}">
									<option value="${catalogue.id_catalogue}">${catalogue.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				&nbsp
				<div class="container" align="center">
						<button type="submit" class="btn btn-primary">Eliminar</button>
					</div>
				&nbsp
				</form:form>
			</div>
		</div>

	</sec:authorize>

</body>

</html>