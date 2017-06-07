package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Bitacora.XML;
import Integracion.BaseDeDatos;

/**
 * Servlet implementation class ServletConsultarTipPreg
 */
@WebServlet("/ServletConsultarTipPreg")
public class ServletConsultarTipPreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarTipPreg() {
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
		ArrayList<String> list= bd.SelectPorCodigoTPreg(codigoTipPreg);
		String nombreTipPreg = list.get(0);
		String descripTipPreg = list.get(1);
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una consulta sobre un tipo de pregunta");
		request.setAttribute("texto", nombreTipPreg);
		request.setAttribute("texto2", descripTipPreg);
		ArrayList<String> tipoPregunta = bd.selectTipoPregunta();
		request.setAttribute("ListTipoPreguntas", tipoPregunta);
		request.setAttribute("TipPreg", codigoTipPreg);
		request.getRequestDispatcher("ConsultarTipoPregunta.jsp").forward(request, response);
	}

}
