<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/" var="home" />		

<div class="header clearfix">
	<h2 class="text-muted">Amigo Secreto</h2>
 	<nav>
		
		<ul class="nav nav-pills pull-left">
		
			<li role="presentation" ><a href="${home}">Home</a> </li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li role="presentation"><a href="${home}usuario/addForm">Usuário</a> </li>
				<li role="presentation"><a href="${home}usuario/list">Lista</a> </li>
				<li role="presentation"><a href="${home}evento/addForm">Evento</a> </li>
			</sec:authorize>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li role="presentation">
				<div>Bem Vindo(a): <b><sec:authentication property="principal.nome"/></b></div>
			</li>
		</ul>
	</nav>
</div>
 	
