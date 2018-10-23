<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
body#LoginForm {
	background-image:
		/* url("https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg"); */
		/* url("http://www.liocreativo.com/wp-content/uploads/2014/03/fondo-11.jpg"); */
		/* url("http://www.defondos.com/images/wallpapers/rombos%20horizontal%20wallpaper%20pattern%20(55)-579255_800.jpeg"); */
		/* url("http://www.hdfondos.eu/pictures/2015/1029/1/orig_770062.jpg"); */
		url("https://s3.pixers.pics/pixers/700/FO/56/88/39/28/700_FO56883928_50b3e5528286100e09d73c921aec546b.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding: 10px;
	background-repeat: no-repeat;
}

.form-heading {
	color: #000000;
	font-size: 50px;
	margin: 60px auto 60px;
}

.panel h2 {
	color: #444444;
	font-size: 25px;
	margin: 0 0 8px 0;
}

.panel p {
	color: #777777;
	font-size: 14px;
	margin-bottom: 30px;
	line-height: 24px;
}

.login-form .form-control {
	background: #f7f7f7 none repeat scroll 0 0;
	border: 1px solid #d4d4d4;
	border-radius: 4px;
	font-size: 14px;
	height: 50px;
	line-height: 50px;
}

.main-div {
	background: #ffffff none repeat scroll 0 0;
	border-radius: 2px;
	margin: 60px auto 30px;
	max-width: 38%;
	padding: 50px 80px 80px 80px;
	*/
}

.login-form .form-group {
	margin-bottom: 10px;
}

.login-form {
	text-align: center;
}

.forgot a {
	color: #777777;
	font-size: 14px;
	text-decoration: underline;
}

.login-form  .btn.btn-primary {
	background: #636363 none repeat scroll 0 0;
	border-color: #636363;
	color: #ffffff;
	font-size: 14px;
	width: 100%;
	height: 50px;
	line-height: 50px;
	padding: 0;
}

.forgot {
	text-align: left;
	margin-bottom: 30px;
}

.botto-text {
	color: #ffffff;
	font-size: 14px;
	margin: auto;
}

.login-form .btn.btn-primary.reset {
	background: #ff9900 none repeat scroll 0 0;
}

.back {
	text-align: left;
	margin-top: 10px;
}

.back a {
	color: #444444;
	font-size: 13px;
	text-decoration: none;
}
</style>
</head>
<body id="LoginForm">
	<div class="container">
		<h1 class="form-heading" align="center">LiceDQTool</h1>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Inicio de Sesión</h2>
					<p>Introduzca su nombre de usuario y su contraseña</p>
				</div>
				<form name='loginForm' action="<c:url value='/login' />"
					method='POST'>

					<div class="form-group">
						Nombre de Usuario <input type="text" class="form-control" name="username">
					</div>

					<div class="form-group">

						Contraseña <input type="password" class="form-control"
							name="password">

					</div>
					<!-- 					<div class="forgot">
						<a href="reset.html">Forgot password?</a>
					</div> -->
					<button type="submit" class="btn btn-primary">Acceder</button>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</form>

			</div>

		</div>
	</div>
	</div>


</body>
</html>
