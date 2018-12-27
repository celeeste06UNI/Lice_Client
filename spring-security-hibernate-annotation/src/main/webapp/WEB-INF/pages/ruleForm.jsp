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
<script type="text/javascript">
	function pregunta() {
		if (confirm("¿Desea crear la regla?")) {
			document.pruebaForm.submit()
		}
	}
</script>
<script type="text/javascript">
	function datos() {
		alert("Valores posibles: NULL, UNIQUE, {1,2}");
	}
</script>
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
						<li><a href="viewRule">Visualizar</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Catalogo <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newCatalogue">Crear</a></li>
						<li><a href="viewCatalogue">Eliminar/Modificar</a></li>
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
				<h2>Nueva Regla</h2>
			</div>

		</div>
		<div class="container" align="center">
			<div class="w3-panel w3-border w3-round-xlarge">
				&nbsp
				<h4>
					<strong>Informacion principal</strong>
				</h4>
				<form:form name='cargarForm' action="${cp}/selectProject"
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
		<form:form name='pruebaForm' action="${cp}/saveRule" method="GET">

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
							<select class="form-control" name=operador id="operador">
								<option value="Es oligatorio que">Es obligatorio que...</option>
								<option value="Es necesario que">Es necesario que...</option>
								<option value="Es imposible que">Es imposible que...</option>
								<option value="Puede que">Puede que...</option>
								<option value="Para todo registro que">Para todo
									registro que...</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<input id="bucle" type="hidden" class="form-control" name="bucle"
								value="${numerAtFor}"> <input id="id_project"
								type="hidden" class="form-control" name="id_project"
								value="${id_project}">
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
									<input type="text" class="form-control"
										name="cuantificador${i}" value="el campo"
										placeholder="el campo">
								</div>
							</div>
							&nbsp
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="exampleFormControlSelect1" align="right">Terminos:</label>
								<div class="col-sm-10">
									<select class="form-control" name="termino${i}"
										id="termino${i}">
										<c:forEach var="dataModelDec" items="${listAttributes}">
											<option value="${dataModelDec}">${dataModelDec}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							&nbsp
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="exampleFormControlSelect1" align="right">Verbos:</label>
								<div class="col-sm-10">
									<select class="form-control" name="verbo${i}" id="project">
										<option value="sea">sea</option>
										<option value="sea igual que">sea igual que...</option>
										<option value="tenga una longitud">Tenga una longitud...</option>
										<option value="tome el valor">Tome el valor...</option>
										<option value="tome alguno de los valores">Tome alguno de los valores...</option>
										<option value="tome los valores">Tome los valores...</option>
										<option
											value="tenga una expresión regular
											definida como">Tenga
											una expresión regular definida como...</option>
									</select>
								</div>
							</div>
							&nbsp
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="exampleFormControlSelect1" align="right">Operadores
									Lógicos:</label>
								<div class="col-sm-10">
									<select class="form-control" name="operadorLogi${i}" id="no">
										<option value="no">no</option>
										<option value="-">-</option>
									</select>
								</div>
							</div>
							&nbsp
							<div class="form-group">
								<label class="control-label col-sm-2" align="right">Valor
									del Termino:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="valorAt${i}"
										placeholder="indique el valor del atributo">
								</div>
								<div class="col-sm-2">
									<button type="button" onclick="datos()" class="btn btn-info">
										<span class="glyphicon glyphicon-info-sign"></span> Info
									</button>

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
						<strong>Información adicional</strong>
					</h4>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Propiedad
							de la Calidad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=propiedad id="propiedad">
								<option value="Precision
									sintactica">Precision
									sintactica</option>
								<option value="Precision semantica">Precision semantica</option>
								<option value="Rango de precision">Rango de precision</option>
								<option value="Completitud de
									registro">Completitud
									de registro</option>
								<option value="Completitud de
									fichero">Completitud
									de fichero</option>
								<option value="Completitud de
									valores de datos">Completitud
									de valores de datos</option>
								<option value="Completitud falsa de
									ficheros">Completitud
									falsa de ficheros</option>
								<option value="Consistencia
									integridad referencial">Consistencia
									integridad referencial</option>
								<option value="Consistencia de
									formato">Consistencia
									de formato</option>
								<option value="Consistencia
									semántica">Consistencia
									semántica</option>
								<option value="Riesgos de
									inconsistencia">Riesgos
									de inconsistencia</option>
								<option value="Credibilidad de los
									valores de datos">Credibilidad
									de los valores de datos</option>
								<option value="Credibilidad de la
									fuente de datos">Credibilidad
									de la fuente de datos</option>
								<option value="Frecuencia de
									actualizacion">Frecuencia
									de actualizacion</option>
								<option value="Conveniencia de
									actualizacion">Conveniencia
									de actualizacion</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Estado:</label>
						<div class="col-sm-10">
							<select class="form-control" name=estado id="estado">
								<option value="Elicitada">Elicitada</option>
								<option value="Validada">Validada</option>
								<option value="Evaluada">Evaluada</option>
								<option value="Validada">Cerrada</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Criticidad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=criticidad id="criticidad">
								<option value="muy alta">Muy alta</option>
								<option value="alta">Alta</option>
								<option value="baja">Baja</option>
								<option value="muy baja">Muy baja</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Prioridad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=prioridad id="prioridad">
								<option value="muy alta">Muy alta</option>
								<option value="alta">Alta</option>
								<option value="media">Media</option>
								<option value="baja">Baja</option>
								<option value="muy baja">Muy baja</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2" align="right">Version:</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" name="version"
								placeholder="indique la version">
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Catalogo:</label>
						<div class="col-sm-10">
							<select class="form-control" name=catalogo id="catalogo">
								<c:forEach var="catalogue" items="${catalogueList}">
									<option value="${catalogue.id_catalogue}">${catalogue.name}</option>
								</c:forEach>
								<option value="0">-</option>
							</select>
						</div>
					</div>
					&nbsp

				</div>
			</div>
		&nbsp
		<div class="container" align="center">
				<input type="button" class="btn btn-primary" onclick="pregunta()"
					value="Enviar">
			</div>
		</form:form>
		&nbsp
	</sec:authorize>
</body>
</html>