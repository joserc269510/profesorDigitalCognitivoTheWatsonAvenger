package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class ServletEstudiante
 */
@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstudiante() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroIdentificacion= request.getParameter("txtIdentificacion");
	   	 String numeroCarnet= request.getParameter("txtCarnet"); 
	   	 String fechaNacimiento =request.getParameter("txtNacimiento");
	   	 String apellido1=request.getParameter("txtApellido1") ;
	   	 String apellido2= request.getParameter("txtApellido2");
	   	 String nombre= request.getParameter("txtNombre");
	   	 String email= request.getParameter("txtEmail");
	   	 
	   Estudiante estudiante= new Estudiante();
	   estudiante.registrarEstudiante(numeroIdentificacion, numeroCarnet, fechaNacimiento, apellido1, apellido2, nombre, email);
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo un registro de un estudiante " + nombre.toLowerCase() + " " + apellido1.toLowerCase() + " " + apellido2.toLowerCase());
	   response.setContentType("text/html");
	}

}
