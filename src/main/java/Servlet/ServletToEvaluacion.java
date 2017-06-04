package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.Evaluacion;

/**
 * Servlet implementation class ServletToEvaluacion
 */
@WebServlet("/ServletToEvaluacion")
public class ServletToEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToEvaluacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Evaluacion> evaluaciones = bd.selectEvaluacion();
		ArrayList<Estudiante> estudiantes= bd.selectEstudiante();
		request.setAttribute("ListEval", evaluaciones);
		request.setAttribute("ListEstudiantes", estudiantes);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("HabilitarEvaluacion")){
			request.getRequestDispatcher("HabilitarEvaluacion.jsp").forward(request, response);
		}
		if(par.equals("EstadoEvaluacion")){
			request.getRequestDispatcher("EstadoEvaluacion.jsp").forward(request, response);
		}
		if(par.equals("DetalleEvaluacion")){
			request.getRequestDispatcher("DetalleEvaluacion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
