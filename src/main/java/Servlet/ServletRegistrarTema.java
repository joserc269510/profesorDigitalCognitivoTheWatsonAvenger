package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletRegistrarTema
 */
@WebServlet("/ServletRegistrarTema")
public class ServletRegistrarTema extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarTema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pCodigoCurso= request.getParameter("selCodigoCurso");
		String pDescripcion= request.getParameter("txtDescripcion");
		Tema tema= new Tema();
		tema.registrarTema(pCodigoCurso, pDescripcion);
		
		
	}

}
