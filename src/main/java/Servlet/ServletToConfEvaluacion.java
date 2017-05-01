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
import logicaDeNegocios.Subtema;
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletToConfEvaluacion
 */
@WebServlet("/ServletToConfEvaluacion")
public class ServletToConfEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToConfEvaluacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<String> tipoEvaluacion = bd.selectTipoEvaluacion();
		request.setAttribute("ListTipoEval", tipoEvaluacion);
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		ArrayList<String> pregunta = bd.selectTipoPregunta();
		request.setAttribute("ListTipoPreguntas", pregunta);
		request.getRequestDispatcher("ConfigurarEvaluacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
