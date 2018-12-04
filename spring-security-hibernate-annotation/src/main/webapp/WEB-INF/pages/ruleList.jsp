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
	background-color: #e6e6e6;
	width: 100%;
	font-family: helvetica;
	font-size: 16px;
	font-weight: bold;
}

.boton_mostrar {
	float: right;
	font-size: 12px;
	line-height: 20px;
	color: #DE7217;
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
				<h2>Eliminar/Editar Organización</h2>
			</div>

		</div>
		<div class="container">
			<%-- <c:forEach var="rule" items="${listOrganization}"> --%>
			<div class="titulo_boton">
				Descripcion de la regla <a style='cursor: pointer;'
					onClick="muestra_oculta('contenido')" title=""
					class="boton_mostrar">Mostrar / Ocultar</a>
			</div>

			<div id="contenido">
				<div class="row">
					<div class="col-sm-12">
						<p>Caracteristicas de la regla</p>
					</div>
				</div>

				<div class="row">
					<form:form action="${cp}/updateRule" method="POST"
						modelAttribute="catalogue">
						<div class="col-sm-4">
							<label for="exampleFormControlSelect1" align="right">Propiedad
								de la Calidad</label> <select class="form-control" name=propiedad
								id="propiedad">
								<option value="precisionsintactica">Precision
									sintactica</option>
								<option value="precisionsemantica">Precision semantica</option>
								<option value="rangoprecision">Rango de precision</option>
								<option value="completitudregistro">Completitud de
									registro</option>
								<option value="completitudfichero">Completitud de
									fichero</option>
								<option value="completitudvalores">Completitud de
									valores de datos</option>
								<option value="completitudfalsa">Completitud falsa de
									ficheros</option>
								<option value="consistenciaintegridad">Consistencia
									integridad referencial</option>
								<option value="consistenciaformato">Consistencia de
									formato</option>
								<option value="consistenciasemantica">Consistencia
									semántica</option>
								<option value="inconsistencia">Riesgos de
									inconsistencia</option>
								<option value="credibilidadvalores">Credibilidad de los
									valores de datos</option>
								<option value="credibilidadfuente">Credibilidad de la
									fuente de datos</option>
								<option value="actualidadfrecuencia">Frecuencia de
									actualizacion</option>
								<option value="actualidadconveniencia">Conveniencia de
									actualizacion</option>
							</select>
						</div>
						<div class="col-sm-4">
							<label for="exampleFormControlSelect1" align="right">Estado</label>
							<select class="form-control" name=estado id="estado">
								<option value="elicitada">Elicitada</option>
								<option value="validada">Validada</option>
								<option value="evaluada">Evaluada</option>
								<option value="validada">Cerrada</option>
							</select>
						</div>
						<div class="col-sm-4">
							<label for="exampleFormControlSelect1" align="right">Criticidad</label>
							<select class="form-control" name=criticidad id="criticidad">
								<option value="c_muyalta">Muy alta</option>
								<option value="c_alta">Alta</option>
								<option value="c_baja">Baja</option>
								<option value="c_muybaja">Muy baja</option>
							</select>
						</div>
						<div class="col-sm-4">
							<label for="exampleFormControlSelect1" align="right">Prioridad</label>

							<select class="form-control" name=prioridad id="prioridad">
								<option value="p_muyalta">Muy alta</option>
								<option value="p_alta">Alta</option>
								<option value="p_media">Media</option>
								<option value="p_baja">Baja</option>
								<option value="p_muybaja">Muy baja</option>
							</select>

						</div>
						<div class="col-sm-4">
							<label align="right">Version</label> <input type="number"
								class="form-control" name="version"
								placeholder="indique la version">
						</div>
						<div class="col-sm-4">
							<label for="exampleFormControlSelect1" align="right">Catalogo:</label>

							<select class="form-control" name=catalogo id="catalogo">
								<c:forEach var="catalogue" items="${catalogueList}">
									<option value="${catalogue.id_catalogue}">${catalogue.name}</option>
								</c:forEach>
								<option value="0">-</option>
							</select>
						</div>
						&nbsp
						<div class="row">
							<div class="col-sm-12" align="center">
								<button type="submit" class="btn btn-primary">Actualizar</button>
							</div>
						</div>


					</form:form>
				</div>

			</div>
			<%-- 	</c:forEach> --%>
		</div>
	</sec:authorize>
</body>

</html>