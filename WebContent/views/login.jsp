<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<title>Modelo Spring</title>
</head>
<body>
	<div class="container">	
		<h1>Login</h1>
		<form:form servletRelativeAction="/login" method="post">
			<table>
				<tr>
					<td>E-mail:</td>
					<td><input type="text" name="username" ></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="password" ></td>
				</tr>
			</table>
			<input type="submit" value="Logar">
		</form:form>
		${msg}
	</div>
</body>
</html>
