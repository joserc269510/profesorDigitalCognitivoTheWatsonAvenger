package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.*;

/**
 * Servlet implementation class ServletSeleccionarTema
 */
@WebServlet("/ServletSeleccionarTema_C")
public class ServletSeleccionarTema_C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeleccionarTema_C() {
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
		String curso= request.getParameter("x");
		//String tema1= request.getParameter("y");
		String tema= request.getParameter("selCodigoTema");
	//	System.out.println("vuelta a cargarsegunda");
		//System.out.println(curso);
		//System.out.println(tema);
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<Tema> temas = bd.selectTema(curso);
		request.setAttribute("ListTemas", temas);
		ArrayList<Subtema> subtemas = bd.selectSubTema( Integer.parseInt(tema));
		request.setAttribute("Curso", curso);
		request.setAttribute("Tema", tema);
		request.setAttribute("ListSubTemas", subtemas);
		request.getRequestDispatcher("RegistrarPreguntaComplete.jsp").forward(request, response);
		

	}

}
