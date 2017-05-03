package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.IVerificarEvaluacion;
import logicaDeNegocios.Sumativa;

/**
 * Servlet implementation class ServletRegistrarTipoEvaluacion
 */
@WebServlet("/ServletRegistrarTipoEvaluacion")
public class ServletRegistrarTipoEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarTipoEvaluacion() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tipoEvaluacion = request.getParameter("txtTipo");
		String descripcionEvaluacion = request.getParameter("txtDescripcion");
		System.out.println(tipoEvaluacion);
		
	    IVerificarEvaluacion evaluacion = new Evaluacion() {
		
		
		public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,
				String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion,
				int pTiempominutos) {}

		public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {}
		
		public void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje) {}
		
		};
	    evaluacion.verificarTipoEvaluacion(tipoEvaluacion,descripcionEvaluacion );		
	}

}
