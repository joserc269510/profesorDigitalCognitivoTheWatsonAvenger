package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;

/**
 * Servlet implementation class ServletCargarDatsTipPreg
 */
@WebServlet("/ServletCargarDatsTipPreg")
public class ServletCargarDatsTipPreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCargarDatsTipPreg() {
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
		String codigoTipPreg = request.getParameter("selCodigo"); 	
		BaseDeDatos bd = new BaseDeDatos();
		String nombreTipPreg = bd.SelectPorCodigoTPreg(codigoTipPreg);
		request.setAttribute("texto", nombreTipPreg);	
		ArrayList<String> tipoPregunta = bd.selectTipoPregunta();
		request.setAttribute("ListTipoPreguntas", tipoPregunta);
		request.setAttribute("TipPreg", codigoTipPreg);
		request.getRequestDispatcher("ActualizarTipoPregunta.jsp").forward(request, response);
	}

}
