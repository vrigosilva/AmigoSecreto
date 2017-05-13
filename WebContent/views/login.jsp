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
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styleLogin.css'/>"/>

</head>
<body>

<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Bem vindo!</h1>
        </div>
         <div class="modal-body">
         	<form:form servletRelativeAction="/login" name="f" method="post">
         
             <div class="form-group">
                 <input type="text" name="username" class="form-control input-lg" placeholder="E-mail"/>
             </div>

             <div class="form-group">
                 <input type="password" name="password" class="form-control input-lg" placeholder="Senha"/>
             </div>

             <div class="form-group">
                 <input type="submit" type="submit" class="btn btn-block btn-lg btn-primary" value="Logar"/>
                 <span class="pull-right"><a href="usuario/addForm">Cadastre-se</a></span><span><a href="#">Forgot Password</a></span>
             </div>
             </form:form>
         </div>
    </div>
 </div>

</body>
</html>