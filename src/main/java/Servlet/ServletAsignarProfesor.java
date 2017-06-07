package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Bitacora.XML;
import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Profesor;

/**
 * Servlet implementation class ServletAsignarProfesor
 */
@WebServlet("/ServletAsignarProfesor")
public class ServletAsignarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAsignarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<Profesor> profesores = bd.selectProfe();
		request.setAttribute("ListProfesores", profesores);
		request.getRequestDispatcher("AsignarProfesor.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String codProfesor=request.getParameter("selIdentificacion");
		String codCurso=request.getParameter("selCodigo");
		Curso curso= new Curso();
		curso.AsinarProfesorCurso(codCurso, codProfesor);
		
		
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se asigno un profesor a un curso");
		
		ArrayList<Profesor> profesores = bd.selectProfe();
		request.setAttribute("ListProfesores", profesores);
		request.getRequestDispatcher("AsignarProfesor.jsp").forward(request, response);

	}

}
