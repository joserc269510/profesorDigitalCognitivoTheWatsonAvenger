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
import logicaDeNegocios.Subtema;

/**
 * Servlet implementation class ServletToSubtema
 */
@WebServlet("/ServletToSubtema")
public class ServletToSubtema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToSubtema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarSubtema")){
			request.getRequestDispatcher("ConsultarSubtema.jsp").forward(request, response);
		}
		if(par.equals("ActualizarSubtema")){
			request.getRequestDispatcher("ActualizarSubtema.jsp").forward(request, response);
		}
		if(par.equals("EliminarSubtema")){
			request.getRequestDispatcher("EliminarSubtema.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarSubtema")){
			request.getRequestDispatcher("ConsultarSubtema.jsp").forward(request, response);
		}
		if(par.equals("ActualizarSubtema")){
			request.getRequestDispatcher("ActualizarSubtema.jsp").forward(request, response);
		}
		if(par.equals("EliminarSubtema")){
			request.getRequestDispatcher("EliminarSubtema.jsp").forward(request, response);
		}
	}

}
