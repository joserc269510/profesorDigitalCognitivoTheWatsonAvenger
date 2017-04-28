package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Evaluacion;

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
		String TipoEvaluacion = request.getParameter("txtCodigo");
		
	//	Evaluacion evaluacion= 
	}

}
