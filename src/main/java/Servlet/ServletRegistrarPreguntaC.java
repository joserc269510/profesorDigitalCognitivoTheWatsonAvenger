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
import Seguridad.Encriptar;
import logicaDeNegocios.*;

/**
 * Servlet implementation class ServletRegistrarPreguntaC
 */
@WebServlet("/ServletRegistrarPreguntaC")
public class ServletRegistrarPreguntaC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarPreguntaC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		
		request.setAttribute("ListCursos", cursos);
		
		request.getRequestDispatcher("RegistrarPreguntaComplete.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Respuesta resp= new Respuesta();
		
		String correcta="1";
		String incorrect="0";
				String curso= request.getParameter("x");
				String tema= request.getParameter("y");
				String subtema=request.getParameter("selCodigoSubtema");
				String codPreg=request.getParameter("txtCodigo");
				String DescpPregunta=request.getParameter("txtDescripcion");
				String resp1=request.getParameter("txtRespuesta1");
				
						
					
				String descpAy=request.getParameter("txtDescripcionAyuda");
	            
				pregunta preg=new EspacioBlanco();
				Encriptar nEncripcion=new Encriptar(DescpPregunta.toLowerCase(),26);
				preg.registrarPregunta(codPreg, subtema, nEncripcion.getPIN(), descpAy);
				
				Encriptar nEncripcion1=new Encriptar(resp1,26);
				
				resp.registrarRespuesta(codPreg, nEncripcion1.getPIN(), correcta);
				
				
				Bitacora bitacora = new Bitacora();
				bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro una pregunta corta");
				
				BaseDeDatos bd= new BaseDeDatos();
				ArrayList<Curso> cursos = bd.selectCurso();
				
				request.setAttribute("ListCursos", cursos);
				request.getRequestDispatcher("RegistrarPreguntaComplete.jsp").forward(request, response);
	}

}
