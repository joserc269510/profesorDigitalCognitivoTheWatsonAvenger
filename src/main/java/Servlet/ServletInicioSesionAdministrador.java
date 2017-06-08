package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Bitacora.XML;
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
	   System.out.println(resp);
	   
	   Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se inicio sesion por parte del administrador");
	   
	   if(resp.equals(true)){
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/ModuloAdministrativo.jsp");
		   dispatcher.forward(request, response);
       }else{
    	   String someMessage = "Credenciales invalidas vuelva a intentar";
    	   PrintWriter out = response.getWriter();
    	   out.print("<html><head>");
    	   out.print("<script type=\"text/javascript\">alert(" + someMessage + ");</script>");
    	   out.print("</head><body></body></html>");
    	   request.getRequestDispatcher("/InicioSesionAdministrador.jsp").forward(request, response);
       }
	}

		

}