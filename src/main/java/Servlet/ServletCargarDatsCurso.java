package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;

/**
 * Servlet implementation class ServletCargarDatsCurso
 */
@WebServlet("/ServletCargarDatsCurso")
public class ServletCargarDatsCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCargarDatsCurso() {
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
		String codigoCurso = request.getParameter("selCodigo"); 	
		BaseDeDatos curso = new BaseDeDatos();
		String nombreCurso = curso.SelectPorCodigo(codigoCurso, "descripcioncurso", "Curso");
		request.setAttribute("texto", nombreCurso);	
		ArrayList<Curso> cursos = curso.selectCurso();
		request.setAttribute("ListCursos", cursos);
		request.setAttribute("Curso", codigoCurso);
		request.getRequestDispatcher("ActualizarCurso.jsp").forward(request, response);
	}

}
