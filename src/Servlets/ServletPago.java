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

@WebServlet(name = "ServletPago", urlPatterns = {"/ServletPago"})
public class ServletPago extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idEmpleado=request.getParameter("idEmpleado");
		String Salario=request.getParameter("Salario");
		String Fechadepago=request.getParameter("Fechadepago");
		
		BeanEmpleado pa = new BeanEmpleado();
		pa.setIdEmpleado(idEmpleado);
		pa.setSalario(Salario);
		pa.setFechadepago(Fechadepago);
		
		DaoEmpleadoIMPL DPI = new DaoEmpleadoIMPL();
		
	    if ("Agregar".equals(request.getParameter("btnAgregar"))) 
	    {
	    	try 
			{
	    		DPI.ingresar(pa);
				System.out.println("Haz presionado el boton agregar");
				        RequestDispatcher despachador = request.getRequestDispatcher("Pagos.jsp");;
				despachador.forward(request, response);
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	      } else if ("Modificar".equals(request.getParameter("btnModificar"))) 
	      {
	    	  try 
				{
					DPI.modificar(pa);
					System.out.println("Haz presionado el boton modificar");
					RequestDispatcher despachador = request.getRequestDispatcher("Pagos.jsp");;
					despachador.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }  else if ("Eliminar".equals(request.getParameter("btnEliminar"))) 
	      {
	    	  try 
				{
					DPI.eliminar(pa);
					System.out.println("Haz presionado el boton eliminar");
					RequestDispatcher despachador = request.getRequestDispatcher("Pagos.jsp");;
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
