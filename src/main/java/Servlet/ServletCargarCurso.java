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
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletCargarCurso
 */
@WebServlet("/ServletCargarCurso")
public class ServletCargarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCargarCurso() {
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
		BaseDeDatos bd= new BaseDeDatos();
		String curso=request.getParameter("selCodigoCurso");
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<Tema> temas = bd.selectTema(curso);
		request.setAttribute("ListTemas", temas);
		request.getRequestDispatcher("RegistrarSubtema.jsp").forward(request, response);
	}

}
