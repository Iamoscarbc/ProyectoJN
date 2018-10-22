package Servlets;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BeanEmpleado;
import DAO.DaoEmpleadoIMPL;

@WebServlet(name = "ServletEmpleado", urlPatterns = {"/ServletEmpleado"})
public class ServletEmpleado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String idEmpleado=request.getParameter("idEmpleado");
		String DNI=request.getParameter("DNI");
		String Nombre=request.getParameter("Nombre");
		String Apellidos=request.getParameter("Apellidos");
		String Direccion=request.getParameter("Direccion");
		String Telefono=request.getParameter("Telefono");
                String Edad=request.getParameter("Edad");
		String Cargo=request.getParameter("Cargo");
		
		
		BeanEmpleado em = new BeanEmpleado();
		em.setIdEmpleado(idEmpleado);
		em.setDNI(DNI);
		em.setNombre(Nombre);
		em.setApellidos(Apellidos);
		em.setDireccion(Direccion);
		em.setTelefono(Telefono);
                em.setEdad(Edad);
		em.setCargo(Cargo);
		
		DaoEmpleadoIMPL DEI = new DaoEmpleadoIMPL();
		
	    if ("Agregar".equals(request.getParameter("btnAgregar"))) 
	    {
	    	try 
			{
	    		DEI.ingresar(em);
				System.out.println("Haz presionado el boton agregar");
				        RequestDispatcher despachador = request.getRequestDispatcher("Empleados.jsp");;
				despachador.forward(request, response);
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	      } else if ("Modificar".equals(request.getParameter("btnModificar"))) 
	      {
	    	  try 
				{
					DEI.modificar(em);
					System.out.println("Haz presionado el boton modificar");
					RequestDispatcher despachador = request.getRequestDispatcher("Empleados.jsp");;
					despachador.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }  else if ("Eliminar".equals(request.getParameter("btnEliminar"))) 
	      {
	    	  try 
				{
					DEI.eliminar(em);
					System.out.println("Haz presionado el boton eliminar");
					RequestDispatcher despachador = request.getRequestDispatcher("Empleados.jsp");;
					despachador.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }
	      
	      else {
	    	  System.out.println("error");
	      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    /**
     * Returns a short description of the servlet.
     *
    @Override
    public String getServletInfo() {
        return "Short description";
     * @return a String containing servlet description
     */
    //} </editor-fold>
    
}


