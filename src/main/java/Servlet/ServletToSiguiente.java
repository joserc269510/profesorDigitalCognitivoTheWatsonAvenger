package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletToSiguiente
 */
@WebServlet("/ServletToSiguiente")
public class ServletToSiguiente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToSiguiente() {
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
		request.setAttribute("CodEval", request.getParameter("txtCodigo"));
		request.setAttribute("Curso", request.getParameter("selCodigoCurso"));
		request.setAttribute("Nombre", request.getParameter("txtNombre"));
		request.setAttribute("CodTipEval", request.getParameter("selCodigoEval"));
		request.setAttribute("Pts", request.getParameter("txtPts"));
		request.setAttribute("Nota", request.getParameter("txtNota"));
		request.setAttribute("Tiempo", request.getParameter("txtTiempo"));
		request.setAttribute("Descripcion", request.getParameter("txtDescripcion"));
		request.getRequestDispatcher("ConfigurarEvaluacion2.jsp");
	}

}
