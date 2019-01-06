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
	background-color: #fff;
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
<title>Creación de Código por Tabla</title>
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

		<div class="page-header">
			<div class="container">
				<h2>Creación de Código por Tabla</h2>
			</div>
		</div>

		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Informacion principal</strong>
				</h4>
				<form:form name='cargarForm' action="${cp}/viewTable"
					method="GET">
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
				<div class="container" align="center">
						<button type="submit" class="btn btn-primary">Cargar
							tablas</button>
					</div>
				&nbsp
				</form:form>
			</div>
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Tabla y Propiedad</strong>
				</h4>
				<form:form name='cargarForm' action="${cp}/viewRuleCodeByProperty"
					method="GET">
					
					<input id="proj_id" type="hidden" class="form-control" name="proj_id"
								value="${proj_id}">
					
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Tabla:</label>
						<div class="col-sm-10">
							<select class="form-control" name=table id="table">
								<c:forEach var="dmd" items="${dmdList}">
									<option value="${dmd}">${dmd}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Propiedad
							de la Calidad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=propiedad id="propiedad">
								<option value="Precision sintactica">Precision sintactica</option>
								<option value="Precision semantica">Precision semantica</option>
								<option value="Rango de precision">Rango de precision</option>
								<option value="Completitud de registro">Completitud de registro</option>
								<option value="Completitud de fichero">Completitud de fichero</option>
								<option value="Completitud de valores de datos">Completitud de valores de datos</option>
								<option value="Completitud falsa de ficheros">Completitud falsa de ficheros</option>
								<option value="Consistencia integridad referencial">Consistencia integridad referencial</option>
								<option value="Consistencia de formato">Consistencia de formato</option>
								<option value="Consistencia semántica">Consistencia semántica</option>
								<option value="Riesgos de inconsistencia">Riesgos de inconsistencia</option>
								<option value="Credibilidad de los valores de datos">Credibilidad de los valores de datos</option>
								<option value="Credibilidad de la fuente de datos">Credibilidad de la fuente de datos</option>
								<option value="Frecuencia de actualizacion">Frecuencia de actualizacion</option>
								<option value="Conveniencia de actualizacion">Conveniencia de actualizacion</option>
							</select>
						</div>
					</div>
				&nbsp
				<div class="container" align="center">
						<button type="submit" class="btn btn-primary">Cargar
							reglas</button>
					</div>
				&nbsp
				</form:form>
			</div>
			
		</div>

		<div class="container">
			<c:forEach var="rule" items="${listRuleView}">
				<div class="titulo_boton" style="border-bottom: 2px solid #e6e6e6;">
					<div class="row">
						<div class="col-sm-11">${rule.description}</div>
						<div class="col-sm-1">
							<a href="<c:url value='/generateCode?id_rule=${rule.id_rule}'/>"
								class="boton_mostrar">Generar</span>
							</a>
						</div>
					</div>
				</div>
				&nbsp
				&nbsp
			</c:forEach>
			&nbsp
			

		</div>
	</sec:authorize>
</body>

</html>