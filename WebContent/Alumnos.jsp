<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="Bean.BeanAlumno"%>
 <%@ page import="DAO.DaoAlumnoIMPL"%>
 <%@ page import="Tools.ToolLista"%>
 <%@page session="true"%>

<%
HttpSession sesion= request.getSession();

if(sesion.getAttribute("tipo")==null){
    response.sendRedirect("index.jsp");
    }
else{
    String nivel = sesion.getAttribute("tipo").toString();
    if(!nivel.equals("1") && !nivel.equals("2") )
      {response.sendRedirect("index.jsp");
      }
    }
%>

      <%
      	ToolLista lis_usu=new ToolLista();
    	 DaoAlumnoIMPL sql= new DaoAlumnoIMPL();
    	 BeanAlumno bean= new BeanAlumno();
        lis_usu = sql.listarUsuarios();
      %>

<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<title>Tabla Alumnos</title>
    </head>
<body class="bg-dark">

	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;" >
	  <a class="navbar-brand" href="Alumnos.jsp">Registro de Alumnos</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	   <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="admin.jsp">Administrador<span class="sr-only">(current)</span></a>
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
	<div class="row" style="padding-left:150px; padding-top:50px">
        <div class="col-sm-3" style="background-color: #222128;">
          <div class="card-body text-white">
            <form action="ServletAlumno" method="get">
                <div class="form-group">
                  <input type="text" placeholder="idAlumno" name="idAlumno" class="form-control" autofocus>
                </div>
                <div class="form-group">
                  <input type="text" placeholder="DNI" name="DNI" class="form-control">
                </div>
                <div class="form-group">
                  <input type="text" placeholder="Nombre" name="Nombre" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Ape_Paterno" name="Ape_Paterno" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Ape_Materno" name="Ape_Materno" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Direccion" name="Direccion" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Telefono"  name="Telefono" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Edad"  name="Edad" class="form-control">
                </div>      
                <div class="form-group">
                <input type="text" placeholder="Grado" name="Grado" class="form-control">
                </div>
                    <input type="submit" value="Agregar" name="btnAgregar" class="btn btn-dark">
                    <input type="submit" value="Modificar" name="btnModificar" class="btn btn-dark">
                    <input type="submit" value="Eliminar" name="btnEliminar" class="btn btn-dark">
            </form>
          </div>
        </div>
            <div class="col-sm-3 bg-dark">
              <table class="table table-bordered table-dark text-white">
                <thead>
                  <tr>
                        <td>#</td>
                        <td>DNI</td>
                        <td>Nombre</td>
                        <td>Ape_Paterno</td>
                        <td>Ape_Materno</td>
                        <td>Direccion</td>
                        <td>Telefono</td>
                        <td>Edad</td>
                        <td>Grado</td>
                  </tr>
                </thead>
                <tbody >
                     <% for(int i=0;i<lis_usu.getTamanio();i++)
                        {bean=(BeanAlumno)lis_usu.getElemento(i);
                        %>                   
                      <tr>
                            <td><%=bean.getIdAlumno()%></td>
                            <td><%=bean.getDNI() %></td>
                            <td><%=bean.getNombre() %></td>
                            <td><%=bean.getApe_Paterno() %></td>
                            <td><%=bean.getApe_Materno() %></td>
                            <td><%=bean.getDireccion() %></td>
                            <td><%=bean.getTelefono() %></td>
                            <td><%=bean.getEdad() %></td>
                            <td><%=bean.getGrado() %></td>
                      </tr>
                    <% } %>
                </tbody>
              </table>
            </div>
        </div>            
   <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
   <script src="js/bootstrap.min.js" type="text/javascript"></script>
   <script src="js/popper.min.js" type="text/javascript"></script>
</body>
</html>
