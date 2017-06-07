package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Bitacora.XML;
import Integracion.Visual;

/**
 * Servlet implementation class ServletEntrenar
 */
@WebServlet("/ServletEntrenar")
public class ServletEntrenar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEntrenar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String clasificador= request.getParameter("txtClasificador");
		String clase= request.getParameter("txtClass");
		System.out.println("clasificador" + clasificador);
		System.out.println("Clase" + clase);
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo un entrenamiento para reconocer los estudiantes del curso");
		String rutaP=request.getParameter("x");
		String rutaN=request.getParameter("y");
		Visual service= new Visual();
	  	service.EntrenarProfesorCognitivo(rutaP,rutaN, clasificador, clase);
	}

}
