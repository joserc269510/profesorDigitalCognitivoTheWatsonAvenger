package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Bitacora.XML;
import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;

/**
 * Servlet implementation class servletEliminarCurso
 */
@WebServlet("/servletEliminarCurso")
public class ServletActualizarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarCurso() {
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
		// TODO Auto-generated method stub
		BaseDeDatos cursoBase = new BaseDeDatos();
		String codigoCurso = request.getParameter("x");
		String nombreActualizar = request.getParameter("txtDescripcion");
		Curso curso = new Curso();
		System.out.println(codigoCurso + "adskkkkkkkkkkk");
		curso.actualizarCurso(codigoCurso, nombreActualizar);
		
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una actualizacion sobre el curso a " + nombreActualizar.toLowerCase());
		
		ArrayList<Curso> cursos = cursoBase.selectCurso();
		request.setAttribute("ListCursos", cursos);
		request.getRequestDispatcher("ActualizarCurso.jsp").forward(request, response);
	}

}
