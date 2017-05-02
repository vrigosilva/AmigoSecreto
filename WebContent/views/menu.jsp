<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div class="header clearfix">
	<h2 class="text-muted">Sitema de Modelo</h2>
 	<nav>
		
		<ul class="nav nav-pills pull-left">
		
			<li role="presentation" ><a href="/ModeloSpring/">Home</a> </li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li role="presentation"><a href="/ModeloSpring/usuario/addForm">Usuário</a> </li>
				<li role="presentation"><a href="/ModeloSpring/usuario/list">Lista</a> </li>
				<li role="presentation"><a href="/ModeloSpring/evento/addForm">Evento</a> </li>
			</sec:authorize>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li role="presentation">
				<div>Bem Vindo(a): <b><sec:authentication property="principal.nome"/></b></div>
			</li>
		</ul>
	</nav>
</div>
 	
