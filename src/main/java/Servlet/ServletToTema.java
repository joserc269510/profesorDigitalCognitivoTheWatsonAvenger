package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Subtema;
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletToTema
 */
@WebServlet("/ServletToTema")
public class ServletToTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToTema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarTema")){
			request.getRequestDispatcher("ConsultarTema.jsp").forward(request, response);
		}
		if(par.equals("ActualizarTema")){
			request.getRequestDispatcher("ActualizarTema.jsp").forward(request, response);
		}
		if(par.equals("EliminarTema")){
			request.getRequestDispatcher("EliminarTema.jsp").forward(request, response);
		}
		if(par.equals("RegistrarSubTema")){
			request.getRequestDispatcher("RegistrarSubtema.jsp").forward(request, response);
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
