<%--
    Document   : admin.jsp
    Created on : 14/10/2018, 02:22:57 PM
    Author     : Sobrino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
HttpSession sesion= request.getSession();

if(sesion.getAttribute("tipo")==null){
    response.sendRedirect("index.jsp");
    }
else{
    String nivel = sesion.getAttribute("tipo").toString();
    if(!nivel.equals("1"))
      {response.sendRedirect("index.jsp");
      }
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>ADMINISTRADOR</title>
    </head>
    <body class="bg-dark">   
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;" >
	  <a class="navbar-brand" href="admin.jsp">Bienvenido Administrador</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	   <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="Alumnos.jsp">Alumnos<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="Matricula.jsp">Matricula</a>
	      </li>
	      <li class="nav-item"> 
	        <a class="nav-link" href="Empleados.jsp">Empleados</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="Notas.jsp">Notas</a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Pagos
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="Pagos.jsp">Pagos a Empleados</a>
	          <a class="dropdown-item" href="PagosAlumnos.jsp">Importe de Alumnos</a>
	        </div>
	      </li>
	    </ul>
	   <form class="form-inline my-2 my-lg-0">
	      <h5 class="text-uppercase font-weight-bold mr-sm-2"><%=sesion.getAttribute("nombre")%></h5>
	      <a class="btn btn-dark my-2 my-sm-0" href="index.jsp?cerrar=true" role="button">Cerrar Sesión</a>
	    </form>
	  </div>
	</nav>
            <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </body>
</html>
