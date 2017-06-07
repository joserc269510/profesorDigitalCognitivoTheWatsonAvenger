package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Profesor;

/**
 * Servlet implementation class ServletConsultaBitacora
 */
@WebServlet("/ServletConsultaBitacora")
public class ServletConsultaBitacora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaBitacora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String FechaInicio= request.getParameter("txtFechaI");
		String FechaFinal= request.getParameter("txtFechaF");
		System.out.println("FechaInicio" + FechaInicio);
		
		Bitacora bitacora= new Bitacora();
		BaseDeDatos profe = new BaseDeDatos();
		ArrayList<Profesor> profes= profe.selectProfe();
		
		request.setAttribute("FechaI",FechaInicio);
		request.setAttribute("FechaF",FechaFinal);
		
	 ArrayList<Bitacora> bitacoras = new ArrayList<Bitacora>();
	  
	 bitacoras= bitacora.consultarBitacora(profes.get(0).getCorreo(),FechaInicio,FechaFinal);
	 System.out.println(profes.get(0).getCorreo()+ "HO");
	 request.setAttribute("Listbitacoras",bitacoras);
	  
		
		request.getRequestDispatcher("/ConsultarBitacora.jsp").forward(request, response);
		
		
	}

}
