<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in/ Log out</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%-- 	<form name = "loginForm" action = "<c:url value = 'j_spring_security_check' />" method = "POST">
		<table>
			<tr>
				<td colspan="2">Login</td>
			</tr>
			<tr>
				<td colspan="2" style="color: red"><c:if test="${not empty error}">${error}</c:if></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name = "username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name = "password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"/></td>
			</tr>
		</table>
	</form> --%>


 	<div class="container" style="margin-top: 50px">
		<div class="page-header">
			<h1>Welcome to LiceDQTool!</h1>
		</div>
		<form class="form-horizontal" action="/inicio.jsp">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="pwd">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="remember">
							Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="Submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
		
		<a href="inicio">Inicio</a>
		
	</div> 
	

</body>
</html>