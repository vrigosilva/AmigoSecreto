<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
	<title>Lista de Usuário</title>
	<%@include  file="../head.jsp" %>
</head>
<body>
	<div class="container">
		<%@include  file="../menu.jsp" %>
		<h3>Lista de Usuário</h3>
		
		
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Nome</td>
						<td>E-mail</td>
						<td>CPF</td>
						<td>Telefone</td>
						<td style="width: 10%">-</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.nome}</td>
							<td>${usuario.email}</td>
							<td>${usuario.cpf}</td>
							<td>${usuario.telefone}</td>
							<td class="td-actions" style="width: 10%" >
							
								<a href="#" class="btn btn-danger"> <i class="glyphicon glyphicon-trash"></i></a>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>
