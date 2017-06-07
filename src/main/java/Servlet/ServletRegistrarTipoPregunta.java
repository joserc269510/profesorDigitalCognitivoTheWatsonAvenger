package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.IVerificable;
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
		System.out.println(tipoPregunta);
		System.out.println(descripcionPregunta);
		
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro un nuevo tipo de pregunta " + descripcionPregunta.toLowerCase());
		
		
		IVerificable pregunta = new pregunta()
	     { 
	   
			public void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {}
	
			public void registrarPregunta(String CodP, String sub, String descp, String descpAy){}
	    }; 
			
		pregunta.verificarTipoPregunta(tipoPregunta, descripcionPregunta);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrarTipoPregunta.jsp");
		dispatcher.forward(request, response);
	}
	

}
