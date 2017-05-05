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
 * Servlet implementation class ServletActualizarTema
 */
@WebServlet("/ServletActualizarTema")
public class ServletActualizarTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarTema() {
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
		BaseDeDatos bd = new BaseDeDatos();
		String codigoTema = request.getParameter("x");
		String nombreActualizar = request.getParameter("txtDescripcion");
		String numeroCurso = request.getParameter("selCodigoCurso");
	
		System.out.println(codigoTema + "adskkkkkkkkkkk");
		bd.actualizarTema(codigoTema, numeroCurso, nombreActualizar);
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		request.getRequestDispatcher("ActualizarTema.jsp").forward(request, response);
	}

}
