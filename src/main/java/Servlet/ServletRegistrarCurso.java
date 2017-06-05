package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import logicaDeNegocios.Curso;

/**
 * Servlet implementation class ServletRegistrarCurso
 */
@WebServlet("/ServletRegistrarCurso")
public class ServletRegistrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarCurso() 
    {
        super();       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String codigo= request.getParameter("txtCodigo");
		String descripcion= request.getParameter("txtDescripcion");
		Curso curso= new Curso();
		curso.registrarCurso(codigo,descripcion);
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro un curso: " + descripcion.toLowerCase());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarCurso.jsp");
		dispatcher.forward(request, response);
	}

}
