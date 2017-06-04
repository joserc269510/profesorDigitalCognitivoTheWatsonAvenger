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
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletConsultarSubtema
 */
@WebServlet("/ServletConsultarSubtema")
public class ServletConsultarSubtema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarSubtema() {
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
		String codigoSubtema = request.getParameter("selCodigo"); 	
		BaseDeDatos bd = new BaseDeDatos();
		String nombreSubtema = bd.SelectPorCodigoSubtema(codigoSubtema);
		String nombreTema = bd.SelectSubtema(codigoSubtema);
		String nombreCurso = bd.SelectSubtema2(codigoSubtema);
		request.setAttribute("texto", nombreSubtema);
		request.setAttribute("texto2", nombreTema);
		request.setAttribute("texto3", nombreCurso);
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		request.setAttribute("Subtema", codigoSubtema);
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		request.getRequestDispatcher("ConsultarSubtema.jsp").forward(request, response);
	}

}
