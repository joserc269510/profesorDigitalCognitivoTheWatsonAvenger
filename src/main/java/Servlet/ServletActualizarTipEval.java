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
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletActualizarTipEval
 */
@WebServlet("/ServletActualizarTipEval")
public class ServletActualizarTipEval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarTipEval() {
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
		String codigoTipEval = request.getParameter("x");
		String nombreActualizar = request.getParameter("txtTipo");
		bd.actualizarTipEval(codigoTipEval, nombreActualizar);
		ArrayList<String> tipoEvaluacion = bd.selectTipoEvaluacion();
		
		Bitacora bitacora = new XML();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una actualizacion sobre el tipo de evaluacion a " + nombreActualizar.toLowerCase());
		
		request.setAttribute("ListTipoEval", tipoEvaluacion);;
		request.getRequestDispatcher("ActualizarTipoEvaluacion.jsp").forward(request, response);
	}

}
