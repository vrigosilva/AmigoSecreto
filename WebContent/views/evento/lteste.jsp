<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
