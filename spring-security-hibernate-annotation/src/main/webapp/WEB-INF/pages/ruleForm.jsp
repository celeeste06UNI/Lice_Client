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
<!-- <script type="text/javascript">
	function mostrar() {
		document.getElementById('oculto').style.display = 'block';
	}
</script> -->
<!-- <script type="text/javascript">
	function PromptDemo() {	   
		//var bucle = document.getElementById('bucle').value;
		//Ingresamos un mensaje a mostrar
		var cadena = prompt("Escriba: fijo/rango/termino.{numeroAtributo}. Ejemplo: fijo.1", "");
		separador = ".", // un espacio en blanco
		limite = 2,
		arregloDeSubCadenas = cadena.split(separador, limite);
		var eleccion = arregloDeSubCadenas[0];	
		var numero = arregloDeSubCadenas[1];
		//Detectamos si el usuario ingreso un valor
		if (eleccion != null) {
			if(eleccion.localeCompare("fijo") || eleccion.localeCompare("rango") || eleccion.localeCompare("termino") || 
					eleccion.localeCompare("expresion")){
				document.getElementById(eleccion+numero).style.display = 'block';
				document.getElementById('añadirValor'+numero).disabled=true;
			}else{
				alert("No has seleccionado ninguna de las opciones correctas");
			}
		}
		//Detectamos si el usuario NO ingreso un valor
		else {
			alert("Ningun valor introducido");
		}
	}
</script> -->
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
								<option value="oligatorio">Es obligatorio que...</option>
								<option value="necesario">Es necesario que...</option>
								<option value="imposible">Es imposible que...</option>
								<option value="puede">Puede que...</option>
								<option value="paratodo">Para todo registro que...</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<input id="bucle" type="hidden" class="form-control" name="bucle"
								value="${numerAtFor}"> <input id="id_project" type="hidden"
								class="form-control" name="id_project" value="${id_project}">
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
										name="cuantificador${i}" value="campo"
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
								<%-- <div class="col-sm-2">
									<input id="añadirValor${i}" type="button" class="btn btn-primary"
										onclick="PromptDemo()" value="Añadir valor" />
								</div> --%>
							</div>
							&nbsp
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="exampleFormControlSelect1" align="right">Verbos:</label>
								<div class="col-sm-10">
									<select class="form-control" name="verbo${i}" id="project">
										<option value="sea">sea</option>
										<option value="tomevalor">Tome el valor...</option>
										<option value="tomevalores">Tome los valores...</option>
										<option value="expresion">Tenga una expresión regular
											definida como...</option>
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
										<option value="operalodorLo-">-</option>
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
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Estado:</label>
						<div class="col-sm-10">
							<select class="form-control" name=estado id="estado">
								<option value="elicitada">Elicitada</option>
								<option value="validada">Validada</option>
								<option value="evaluada">Evaluada</option>
								<option value="validada">Cerrada</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Criticidad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=criticidad id="criticidad">
								<option value="c_muyalta">Muy alta</option>
								<option value="c_alta">Alta</option>
								<option value="c_baja">Baja</option>
								<option value="c_muybaja">Muy baja</option>
							</select>
						</div>
					</div>
					&nbsp
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="exampleFormControlSelect1" align="right">Prioridad:</label>
						<div class="col-sm-10">
							<select class="form-control" name=prioridad id="prioridad">
								<option value="p_muyalta">Muy alta</option>
								<option value="p_alta">Alta</option>
								<option value="p_media">Media</option>
								<option value="p_baja">Baja</option>
								<option value="p_muybaja">Muy baja</option>
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