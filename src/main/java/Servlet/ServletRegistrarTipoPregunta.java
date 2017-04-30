package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Evaluacion;

import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletRegistrarTipoPregunta
 */
@WebServlet("/ServletRegistrarTipoPregunta")
public class ServletRegistrarTipoPregunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarTipoPregunta() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tipoPregunta = request.getParameter("txtPregunta");
		String descripcionPregunta = request.getParameter("txtDescripcion");
		
	     pregunta pregunta = new pregunta()
	     { 
	    	 public void RegistrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {}
	    }; 
			
		pregunta.VerificarTipoPregunta(tipoPregunta, descripcionPregunta);		
	}
	

}
