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
 * Servlet implementation class ServletRegistroEstudiante
 */
@WebServlet("/ServletRegistroEstudiante")
public class ServletRegistroEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String numeroIdentificacion= request.getParameter("txtIdentificacion");
	   	 String numeroCarnet= request.getParameter("txtCarnet"); 
	   	 String fechaNacimiento =request.getParameter("txtNacimiento");
	   	 String apellido1=request.getParameter("txtApellido1") ;
	   	 String apellido2= request.getParameter("txtApellido2");
	   	 String nombre= request.getParameter("txtNombre");
	   	 String email= request.getParameter("txtEmail");
	   	String telefono= request.getParameter("txtTelefono");
	   	 
	   Estudiante estudiante= new Estudiante();
	   estudiante.registrarEstudiante(numeroIdentificacion,nombre,apellido1,apellido2,numeroCarnet,fechaNacimiento,email,telefono);
	 
	   
	   RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarEstudiante.jsp");
	   dispatcher.forward(request, response);
	}

}
