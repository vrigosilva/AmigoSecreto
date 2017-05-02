<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
	<title>Cadastro de Usuário</title>
	<%@include  file="../head.jsp" %>
</head>
<body>
	<div class="container">
	<%@include  file="../menu.jsp" %>
		<h3>Cadastro de Usuário</h3>
		
		<c:url value="/usuario/add" var="url" />
		<form:form   action="${url}" method="post" commandName="usuario">
			<table>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
					<td><form:errors path="nome" /></td>
				</tr>
				<tr>
					<td>Nascimento:</td>
					<td><input type="date" name="nascimento" /></td>
					<td><form:errors path="nascimento" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" /></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><form:input path="cpf" /></td>
					<td><form:errors path="cpf" /></td>
				</tr>
				<tr>
					<td>Telefone:</td>
					<td><form:input path="telefone" /></td>
					<td><form:errors path="telefone" /></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><form:password path="senha" /></td>
					<td><form:errors path="senha" /></td>
				</tr>
			</table>
			<input type="submit" value="Salvar">
		</form:form>
	</div>
</body>
</html>
