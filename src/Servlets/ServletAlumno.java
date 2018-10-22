package Servlets;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BeanAlumno;
import DAO.DaoAlumnoIMPL;

@WebServlet(name = "ServletAlumno", urlPatterns = {"/ServletAlumno"})
public class ServletAlumno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String idAlumno=request.getParameter("idAlumno");
				String DNI=request.getParameter("DNI");
				String Nombre=request.getParameter("Nombre");
				String Ape_Paterno=request.getParameter("Ape_Paterno");
				String Ape_Materno=request.getParameter("Ape_Materno");
				String Direccion=request.getParameter("Direccion");
				String Telefono=request.getParameter("Telefono");
		        String Edad=request.getParameter("Edad");
				String Grado=request.getParameter("Grado");
		
		
		BeanAlumno al = new BeanAlumno();
		al.setIdAlumno(idAlumno);
		al.setDNI(DNI);
		al.setNombre(Nombre);
		al.setApe_Paterno(Ape_Paterno);
		al.setApe_Materno(Ape_Materno);
		al.setDireccion(Direccion);
		al.setTelefono(Telefono);
        al.setEdad(Edad);
		al.setGrado(Grado);
		
		DaoAlumnoIMPL DAI = new DaoAlumnoIMPL();
		
	    if ("Agregar".equals(request.getParameter("btnAgregar"))) 
	    {
	    	try 
			{
	    		DAI.ingresar(al);
				System.out.println("Haz presionado el boton agregar");
				        RequestDispatcher despachador = request.getRequestDispatcher("Alumnos.jsp");;
				despachador.forward(request, response);
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	      } else if ("Modificar".equals(request.getParameter("btnModificar"))) 
	      {
	    	  try 
				{
					DAI.modificar(al);
					System.out.println("Haz presionado el boton modificar");
					RequestDispatcher despachador = request.getRequestDispatcher("Alumnos.jsp");;
					despachador.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }  else if ("Eliminar".equals(request.getParameter("btnEliminar"))) 
	      {
	    	  try 
				{
					DAI.eliminar(al);
					System.out.println("Haz presionado el boton eliminar");
					RequestDispatcher despachador = request.getRequestDispatcher("Alumnos.jsp");;
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
