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
import logicaDeNegocios.Evaluacion;

/**
 * Servlet implementation class ServletToTipoEvaluacion
 */
@WebServlet("/ServletToTipoEvaluacion")
public class ServletToTipoEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToTipoEvaluacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<String> tipoEvaluacion = bd.selectTipoEvaluacion();
		request.setAttribute("ListTipoEval", tipoEvaluacion);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarTipoEvaluacion")){
			request.getRequestDispatcher("ConsultarTipoEvaluacion.jsp").forward(request, response);
		}
		if(par.equals("ActualizarTipoEvaluacion")){
			request.getRequestDispatcher("ActualizarTipoEvaluacion.jsp").forward(request, response);
		}
		if(par.equals("EliminarTipoEvaluacion")){
			request.getRequestDispatcher("EliminarTipoEvaluacion.jsp").forward(request, response);
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
