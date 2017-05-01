package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.*;

/**
 * Servlet implementation class ServletToPregunta
 */
@WebServlet("/ServletToTipoPregunta")
public class ServletToTipoPregunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Object> pregunta = bd.selectPregunta();
		request.setAttribute("ListPreguntas", pregunta);
		String par=request.getParameter("x");
		System.out.println(par);
		
		if(par.equals("ConsultarTipoPregunta")){
			request.getRequestDispatcher("ConsultarTipoPregunta.jsp").forward(request, response);
		}
		if(par.equals("ActualizarTipoPregunta")){
			request.getRequestDispatcher("ActualizarTipoPregunta.jsp").forward(request, response);
		}
		if(par.equals("EliminarTipoPregunta")){
			request.getRequestDispatcher("EliminarTipoPregunta.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
