package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class ServletMatricular
 */
@WebServlet("/ServletMatricular")
public class ServletMatricular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMatricular() {
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
		
		String idEstudiante=request.getParameter("selIdentificacion");
		String codCurso=request.getParameter("selCodigo");
		Curso matricula= new Curso();
		matricula.matricularEstudiante(codCurso, idEstudiante);
	
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Estudiante> estudiantes = bd.selectEstudiante();
		ArrayList<Curso> cursos = bd.selectCurso();
		
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se matriculo un estudiante a un curso");
		
		request.setAttribute("ListEstudiantes", estudiantes);
		request.setAttribute("ListCursos", cursos);
		request.getRequestDispatcher("MatricularEstudiante.jsp").forward(request, response);


		
		
		
		
		
	}

}
