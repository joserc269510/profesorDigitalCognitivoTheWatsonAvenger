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
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletConsultarTema
 */
@WebServlet("/ServletConsultarTema")
public class ServletConsultarTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarTema() {
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
		String codigoTema = request.getParameter("selCodigo"); 	
		BaseDeDatos bd = new BaseDeDatos();
		String nombreTema = bd.SelectPorCodigoTema(codigoTema);
		Curso curso = bd.SelectPorTema(codigoTema);
		String nombreCurso = curso.getCodigo()+" - "+curso.getDescripcionCurso(); 
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se realizo una consulta sobre un tema");
		request.setAttribute("texto", nombreTema);
		request.setAttribute("texto2", nombreCurso);
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		request.setAttribute("Tema", codigoTema);
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		request.getRequestDispatcher("ConsultarTema.jsp").forward(request, response);
	}

}
