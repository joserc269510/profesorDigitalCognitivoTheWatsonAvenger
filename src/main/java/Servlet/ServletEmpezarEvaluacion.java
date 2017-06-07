package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletEmpezarEvaluacion
 */
@WebServlet("/ServletEmpezarEvaluacion")
public class ServletEmpezarEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpezarEvaluacion() {
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
		String evaluacion=request.getParameter("x");
		String carnet=request.getParameter("y");
		BaseDeDatos bd = new BaseDeDatos();
		ArrayList<pregunta> preguntas = bd.ObtenerPreguntasEvaluacion(evaluacion);
		
		request.setAttribute("ListPreguntas", preguntas);
		request.setAttribute("CodEvaluacion", evaluacion);
		request.setAttribute("carnet", carnet);
		request.setAttribute("error", "0");
		request.getRequestDispatcher("AutentificarEstudianteSMS.jsp").forward(request, response);
	}

}
