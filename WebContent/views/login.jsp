<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<title>Amigo Secreto</title>
    <meta charset="utf-8">
    <script type="text/javascript"  src="<c:url value='/resources/js/jquery.min.js'/>"> </script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/bootstrap/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>

</head>
<body>
	<div class="container">	
		<h1>M Login</h1>
		<form:form servletRelativeAction="/login" name="f" method="post">
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
			<input name="submit" type="submit" value="Login">
			<a href="/usuario/addForm" >Registre-se</a>
		</form:form>
		${msg}
	</div>
</body>
</html>