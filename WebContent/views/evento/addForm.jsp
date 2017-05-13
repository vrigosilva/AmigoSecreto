<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
	<title>Cadastro de Eventos</title>
	<%@include  file="../head.jsp" %>
	
	<script type="text/javascript">
	
	
		function searchAjax() {

			var emailFilter = $("#emailfilter").prop( "value" );
		
			$.get( "${pageContext.request.contextPath}/usuario/listByEmail",{ email: emailFilter } )
			  
			.done(function( data ) {
// 			    alert( "Data Loaded: " + data );
// 			    console.log("SUCCESS: ", data);
				$("#tbParticipantes").append(data);

			 })
			  
			.fail(function() {
			  alert( "error" );
			});
		
		}
	</script>
	
</head>
<body>
	<div class="container">
	<%@include  file="../menu.jsp" %>
		<h3>Cadastro de Eventos</h3>
		
		<c:url value="/evento/add" var="url" />
		<form:form  action="${url}" method="post" commandName="evento">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
					<td><form:errors path="nome" /></td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td><form:input path="descricao" /></td>
					<td><form:errors path="descricao" /></td>
				</tr>
				<tr>
					<td>Data:</td>
					<fmt:formatDate value="${evento.data}" var="dateString" pattern="dd/MM/yyyy" />
					<td><input type="text" id="data" name="data" value="${dateString}" placeholder="DD/MM/AAAA" /></td>
					<td><form:errors path="data" /></td>
				</tr>
				<tr>
					<td>Endereço:</td>
					<td><form:input path="endereco" /></td>
					<td><form:errors path="endereco" /></td>
				</tr>
			</table>
			<input type="submit" value="Salvar">
		</form:form>
			
			<div onclick="searchAjax()"><i class="glyphicon glyphicon-zoom-in"></i></div>
			<input type="text" id="emailfilter" name="emailfilter"  />
			
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
				<tbody id="tbParticipantes" >
					
				</tbody>
			</table>
			
			
	</div>
</body>
</html>
