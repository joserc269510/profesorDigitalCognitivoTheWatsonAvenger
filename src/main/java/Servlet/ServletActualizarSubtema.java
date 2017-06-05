package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Subtema;

/**
 * Servlet implementation class ServletActualizarSubtema
 */
@WebServlet("/ServletActualizarSubtema")
public class ServletActualizarSubtema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarSubtema() {
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
		String codigoSubtema = request.getParameter("x");
		String nombreActualizar = request.getParameter("txtDescripcion");
		
		String nombreViejo = (String) request.getAttribute("texto");
		String numeroTema = request.getParameter("selCodigoTema");
		Subtema subtema = new Subtema();
		System.out.println(codigoSubtema + "adskkkkkkkkkkk");
		subtema.actualizarSubtema(codigoSubtema, numeroTema, nombreActualizar);
		
		System.out.println("hola que tal: " + nombreViejo);
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una actualizacion sobre subtema a " + nombreActualizar.toLowerCase());
		
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		request.getRequestDispatcher("ActualizarSubtema.jsp").forward(request, response);
	}

}
