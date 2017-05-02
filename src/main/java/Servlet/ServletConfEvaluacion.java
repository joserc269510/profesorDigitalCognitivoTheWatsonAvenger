package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.Formativa;
import logicaDeNegocios.Sumativa;

/**
 * Servlet implementation class ServletConfEvaluacion
 */
@WebServlet("/ServletConfEvaluacion")
public class ServletConfEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfEvaluacion() {
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
		String codEval=request.getParameter("cEv");
		String curso= request.getParameter("cur");
		String nombre= request.getParameter("nom");
		String tipoEval= request.getParameter("tEv");
		String pts= request.getParameter("pts");
		String nota= request.getParameter("not");
		String tiempo= request.getParameter("tie");
		String descripcion= request.getParameter("des");
		String codPregunta= request.getParameter("selPre");
		String puntaje= request.getParameter("txtPts");
		
		request.setAttribute("CodEval", codEval);
		request.setAttribute("Curso", curso);
		request.setAttribute("Nombre", nombre);
		request.setAttribute("CodTipEval", tipoEval);
		request.setAttribute("Pts", pts);
		request.setAttribute("Nota", nota);
		request.setAttribute("Tiempo", tiempo);
		request.setAttribute("Descripcion", descripcion);
		
		Evaluacion evaluacion;
		if(tipoEval.equals("1")){
			evaluacion=new Formativa();
			evaluacion.registrarPregunta(codPregunta, codEval, puntaje);
		}
		if(tipoEval.equals("2")){
			evaluacion=new Sumativa();
			evaluacion.registrarPregunta(codPregunta, codEval, puntaje);

		}
		request.getRequestDispatcher("ConfigurarEvaluacion2.jsp");
	}

}
