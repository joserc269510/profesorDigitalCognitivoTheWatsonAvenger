package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class InicioSesionAdministrador
 */
@WebServlet("/InicioSesionAdministrador")
public class InicioSesionAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String correo= request.getParameter("txtCorreo");
	   	 String contrasena= request.getParameter("txtContrasena"); 
	   	
	   	 
	   Estudiante estudiante= new Estudiante();
//	   estudiante.registrarEstudiante(correo,contrasena);
	   
	   RequestDispatcher dispatcher = request.getRequestDispatcher("/InicioSesionAdminstrador.html");
	   dispatcher.forward(request, response);
	}

}