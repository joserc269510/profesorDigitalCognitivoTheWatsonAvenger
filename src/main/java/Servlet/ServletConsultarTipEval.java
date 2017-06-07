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
 * Servlet implementation class ServletConsultarTipEval
 */
@WebServlet("/ServletConsultarTipEval")
public class ServletConsultarTipEval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarTipEval() {
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
		String codigoTipEval = request.getParameter("selCodigo"); 	
		BaseDeDatos bd = new BaseDeDatos();
		String nombreTipEval = bd.SelectPorCodigoTEval(codigoTipEval);
		request.setAttribute("texto", nombreTipEval);	
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una consulta sobre tipo de evaluacion");
		ArrayList<String> tipoEvaluacion = bd.selectTipoEvaluacion();
		request.setAttribute("ListTipoEval", tipoEvaluacion);
		request.setAttribute("TipEval", codigoTipEval);
		request.getRequestDispatcher("ConsultarTipoEvaluacion.jsp").forward(request, response);
	}

}
