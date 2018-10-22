<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="Bean.BeanEmpleado"%>
 <%@ page import="DAO.DaoEmpleadoIMPL"%>
 <%@ page import="Tools.ToolLista"%>
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

      <%
      	ToolLista lis_usu=new ToolLista();
    	 DaoEmpleadoIMPL sql= new DaoEmpleadoIMPL();
    	 BeanEmpleado bean= new BeanEmpleado();
        lis_usu = sql.listarUsuarios();
      %>
      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css"/>
<title>Importe de Alumnos</title>
</head>
<body>
	<nav class="navbar navbar-dark" style="background-color: #000000;">
  		
	  		<div class="col-sm">	
		  	<a class="navbar-brand" href="PagosAlumnos.jsp">Importe de Pagos de Alumnos</a>
		  	</div>
	  		<div class="col-sm" style="padding-left: 580px">
	            <div class="row">
		            <div class="col-sm" align="right" style="padding-top: 8px; padding-left:80px;">
		            <p class="text-uppercase font-weight-bold"><%=sesion.getAttribute("nombre")%></p>
		            </div>
		            <div class="col-sm" align="right" style="padding-left: 20px">
		            <a class="btn btn-dark" href="admin.jsp" role="button">Regresar</a>
		            </div>
		            <div class="col-sm" align="left" >
		            <a class="btn btn-dark" href="index.jsp?cerrar=true" role="button">Cerrar Sesión</a>
		            </div>
	            </div>
	      	</div>
	</nav>
</body>
</html>