<%--
    Document   : docente.jsp
    Created on : 14/10/2018, 02:23:25 PM
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
    if(!nivel.equals("2"))
      {response.sendRedirect("index.jsp");
      }
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css"/>
        <title>DOCENTE</title>
    </head>
    <body class="p-3 mb-2 bg-primary text-dark">
        <div align="right">
            Bienvenida Prof. <%=sesion.getAttribute("nombre")%>
            <a class="btn btn-dark" href="index.jsp?cerrar=true" role="button">Cerrar Sesion</a>
            <hr>
        </div>
        <div align="center">
            <h1>ENTRO COMO DOCENTE</h1>
                <br>
                <form>
                    <a class="btn btn-dark" href="Alumnos.jsp" role="button">Alumnos</a>
                    <br>
                    <br>
                </form>
        </div>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
    </body>
</html>
