package Servlet;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import Integracion.Visual;
import logicaDeNegocios.Archivo;
import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class ServletAutentificarEstudiante
 */
@WebServlet("/ServletAutentificarEstudiante")
public class ServletAutentificarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutentificarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		Archivo archivo= new Archivo();
		String ruta = null;
		try {
	
			ruta=  archivo.CargarImagen(request, response);
			System.out.println(ruta +"Hola");
	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		String nombreImagen= archivo.obtenerNombreImagen(ruta);  
		
		Estudiante estudiante = new Estudiante();
		Boolean resp;
		resp= estudiante.AutentificarEstudiante(ruta);
		
		request.setAttribute("estudiante", estudiante);
		request.setAttribute("ruta", ruta);
		request.setAttribute("carnet", nombreImagen);
		ArrayList<Estudiante> datos=  estudiante.ObtenerInformacionEstudiante(nombreImagen, ruta);
	
	    request.setAttribute("dato", datos);
		
		if(resp.equals(true))
		 {
		       
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/InformacionEstudiante.jsp");
			   dispatcher.forward(request, response);
	      }
		 else
		 {
	    	   request.getRequestDispatcher("AutentificarEstudiante.html").forward(request, response);
	      }
	}

}
