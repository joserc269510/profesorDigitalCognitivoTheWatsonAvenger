package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Evaluacion;

/**
 * Servlet implementation class ServletHabilitarEvaluacion
 */
@WebServlet("/ServletHabilitarEvaluacion")
public class ServletHabilitarEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHabilitarEvaluacion() {
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
		String codEvaluacion=request.getParameter("selCodigo");
		Evaluacion evaluacion=new Evaluacion() {
			
			@Override
			public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,
					String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion,
					int pTiempominutos) {
				// TODO Auto-generated method stub
				
			}
		};
		evaluacion.habilitarEvaluacion(codEvaluacion);
		
		BaseDeDatos bd=new BaseDeDatos();
		ArrayList<Evaluacion> evaluaciones = bd.selectEvaluacion();
		request.setAttribute("ListEval", evaluaciones);
		request.getRequestDispatcher("HabilitarEvaluacion.jsp").forward(request, response);
	}

}
