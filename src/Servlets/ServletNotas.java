package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoNotasIMPL;

import Bean.BeanNotas;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletNotas")
public class ServletNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNotas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAlumno=request.getParameter("idAlumno");
		String DNI=request.getParameter("DNI");
		String Nombres=request.getParameter("Nombres");
		String Apellidos=request.getParameter("Apellidos");
		String Grado=request.getParameter("Grado");
		String LM=request.getParameter("LM");
		String CI=request.getParameter("CI");
		String CA=request.getParameter("CA");
		String Computo=request.getParameter("Computo");
		String PS=request.getParameter("PS");
		String Religion=request.getParameter("Religion");
		String EF=request.getParameter("EF");
		String Minichef=request.getParameter("Minichef");
		String Tutoria=request.getParameter("Tutoria");
		
		
		BeanNotas al = new BeanNotas();
		al.setIdAlumno(idAlumno);
		al.setDNI(DNI);
		al.setNombres(Nombres);
		al.setApellidos(Apellidos);
		al.setGrado(Grado);
		al.setLM(LM);
		al.setCI(CI);
		al.setCA(CA);
		al.setComputo(Computo);
		al.setPS(PS);
		al.setReligion(Religion);
		al.setEF(EF);
		al.setMinichef(Minichef);
		al.setTutoria(Tutoria);
		al.setGrado(Grado);
		
		DaoNotasIMPL DAI = new DaoNotasIMPL();
		
	    if ("Agregar".equals(request.getParameter("btnAgregar"))) 
	    {
	    	try 
			{
	    		DAI.ingresar(al);
				System.out.println("Haz presionado el boton agregar");
				RequestDispatcher despachador = request.getRequestDispatcher("Menu2.jsp");;
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
					RequestDispatcher despachador = request.getRequestDispatcher("Menu2.jsp");;
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
					RequestDispatcher despachador = request.getRequestDispatcher("Menu2.jsp");;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
