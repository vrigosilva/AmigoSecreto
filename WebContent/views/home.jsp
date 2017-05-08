<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
	<title>Home</title>
	<%@include  file="head.jsp" %>
</head>
<body>
	<div class="container">
		<%@include  file="menu.jsp" %>
		<h3>Eventos</h3>
		
		
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Nome</td>
						<td>Descrição</td>
						<td>Data</td>
						<td style="width: 10%">-</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="evento" items="${eventos}">
						<tr>
							<td>${evento.nome}</td>
							<td>${evento.descricao}</td>
							<td>${evento.data}</td>
							<td class="td-actions" style="width: 10%" >
							
								<a href="#" class="btn btn-danger"> <i class="glyphicon glyphicon-trash"></i></a>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>${msg}</div>
	</div>
</body>
</html>