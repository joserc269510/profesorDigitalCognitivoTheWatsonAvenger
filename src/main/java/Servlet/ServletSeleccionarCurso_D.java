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
 * Servlet implementation class ServletSeleccionarCurso
 */
@WebServlet("/ServletSeleccionarCurso_D")
public class ServletSeleccionarCurso_D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeleccionarCurso_D() {
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
		String curso= request.getParameter("selCodigo");
		//System.out.println("vuelta a cargar");
		//System.out.println(curso);
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<Tema> temas = bd.selectTema(curso);
		request.setAttribute("Curso", curso);
		request.setAttribute("ListTemas", temas);
		request.getRequestDispatcher("RegistrarPreguntaDesarrollo.jsp").forward(request, response);
		
		
	}

}
