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
import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class ServletToCurso
 */
@WebServlet("/ServletToCurso")
public class ServletToCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarCurso")){
			request.getRequestDispatcher("ConsultarCurso.jsp").forward(request, response);
		}
		if(par.equals("ActualizarCurso")){
			request.getRequestDispatcher("ActualizarCurso.jsp").forward(request, response);
		}
		if(par.equals("EliminarCurso")){
			request.getRequestDispatcher("EliminarCurso.jsp").forward(request, response);
		}
		if(par.equals("RegistrarTema")){
			request.getRequestDispatcher("RegistrarTema.jsp").forward(request, response);
		}
		if(par.equals("RegistrarSubtema")){
			request.getRequestDispatcher("RegistrarSubtema.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		String par=request.getParameter("x");
		System.out.println(par);
		if(par.equals("ConsultarCurso")){
			request.getRequestDispatcher("ConsultarCurso.jsp").forward(request, response);
		}
		if(par.equals("ActualizarCurso")){
			request.getRequestDispatcher("ActualizarCurso.jsp").forward(request, response);
		}
		if(par.equals("EliminarCurso")){
			request.getRequestDispatcher("EliminarCurso.jsp").forward(request, response);
		}
		if(par.equals("RegistrarTema")){
			request.getRequestDispatcher("RegistrarTema.jsp").forward(request, response);
		}
		if(par.equals("RegistrarSubtema")){
			request.getRequestDispatcher("RegistrarSubtema.jsp").forward(request, response);
		}
	}

}
