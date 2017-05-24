package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.*;

/**
 * Servlet implementation class InicioSesionAdministrador
 */
@WebServlet("/ServletInicioSesionAdministrador")
public class ServletInicioSesionAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String correo= request.getParameter("txtCorreo");
	   	 String contrasena= request.getParameter("txtContrasena"); 
	   	
	   	 
	   Profesor profesor= new Profesor();
	   Boolean resp;
	   resp=profesor.validarUsuario(correo, contrasena);
	   
	   
	   if(resp.equals(true)){
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/ModuloAdministrativo.html");
		   dispatcher.forward(request, response);
       }else{
    	   request.getRequestDispatcher("/InicioSesionAdministrador.jsp").forward(request, response);
       }
	}

		

}