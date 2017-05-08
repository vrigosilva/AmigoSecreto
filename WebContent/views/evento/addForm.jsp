<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
	<title>Cadastro de Eventos</title>
	<%@include  file="../head.jsp" %>
</head>
<body>
	<div class="container">
	<%@include  file="../menu.jsp" %>
		<h3>Cadastro de Eventos</h3>
		
		<c:url value="/evento/add" var="url" />
		<form:form   action="${url}" method="post" commandName="evento">
			<table>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
					<td><form:errors path="nome" /></td>
				</tr>
				<tr>
					<td>Descri��o:</td>
					<td><form:input path="descricao" /></td>
					<td><form:errors path="descricao" /></td>
				</tr>
				<tr>
					<td>Data:</td>
					<td><input type="date" name="data" /></td>
					<td><form:errors path="data" /></td>
				</tr>
				<tr>
					<td>Endere�o:</td>
					<td><form:input path="endereco" /></td>
					<td><form:errors path="endereco" /></td>
				</tr>
			</table>
			<input type="submit" value="Salvar">
		</form:form>
	</div>
</body>
</html>
