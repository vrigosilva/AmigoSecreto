<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
	<title>Cadastro de Eventos</title>
	<%@include  file="../head.jsp" %>
	
	<script type="text/javascript">
	
	function remove(i){
		$("[id^=participacoes"+i+"]").remove()
	}
	
		function searchAjax() {
			indice =  $("#participantesIndice").val();
			if(indice==null ||indice=="" ) indice = 0;
			indice = parseInt(indice, 10);
			var emailFilter = $("#emailfilter").prop( "value" );
		
			$.get( "${pageContext.request.contextPath}/usuario/listByEmail",{ email: emailFilter } )
			  
			.done(function( data ) {
				
				if(data != null && data !="" && data !="null"){
					$("#participantes").append("<input id='participacoes"+indice+".participante.id' name='participacoes["+indice+"].participante.id' type='hidden' value='"+data.id+"'>");
					
					$("#tbParticipantes").append("<tr id='participacoes"+indice+"' ><td>"+data.nome+"</td><td>"+data.email+"</td>"+
							"<td class='td-actions' style='width: 10%'>	<a href='javascript:remove("+indice+");' class='btn btn-danger'> <i class='glyphicon glyphicon-trash'></i></a></td></tr>");
					$("#participantesIndice").val(indice+1);
					
				}else{
					alert("não entontrado");
				}
				
				
		
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
			<div id="participantes"></div>
			<input type="hidden" id="participantesIndice" name="participantesIndice" />
			<input type="submit" value="Salvar">
		</form:form>
		<br/>
		<br/>
		
		<label title="Email participante">Email participante: </label>
		<input type="text" id="emailfilter" name="emailfilter" />
		<i onclick="searchAjax()" class="glyphicon glyphicon-zoom-in"></i>

		<table class="table table-hover">
			<thead>
				<tr>
					<td>Nome</td>
					<td>E-mail</td>
					<td style="width: 10%">-</td>
				</tr>
			</thead>
			<tbody id="tbParticipantes" >
				
			</tbody>
		</table>
		
			
	</div>
</body>
</html>
