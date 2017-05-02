package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.Visual;
import logicaDeNegocios.Archivo;

/**
 * Servlet implementation class ServletEntrenarProfesor
 */
@WebServlet("/ServletEntrenamiento")
public class ServletSubirNegativos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSubirNegativos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		Archivo archivo= new Archivo();
		String rutaN = null;
		try {
			rutaN=  archivo.CargarArchivo(request, response);
			//archivo.EscribirArchivoTXT(ruta);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	//	String clasificador= request.getParameter("txtClasificador");
//		String clase= request.getParameter("txtClass");
//		System.out.println("clasificador" + clasificador);
//		System.out.println("Clase" + clase);
		String rutaP=request.getParameter("x");
		request.setAttribute("rutaP", rutaP);
		request.setAttribute("rutaN", rutaN);
	//	Visual service= new Visual();
	  //	service.EntrenarProfesorCognitivo(rutaP,rutaN, clasificador, clase);
		request.getRequestDispatcher("EntrenarProfesor.jsp").forward(request, response);
	  	
	}

}
