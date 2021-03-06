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
import Seguridad.Encriptar;
import Seguridad.EncriptarLlave;
import Seguridad.entradaEncriptarDesencriptar;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Desarrollo;
import logicaDeNegocios.MarqueX;
import logicaDeNegocios.Respuesta;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletRegistrarPreguntaD
 */
@WebServlet("/ServletRegistrarPreguntaD")
public class ServletRegistrarPreguntaD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarPreguntaD() {
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
		
		request.getRequestDispatcher("RegistrarPreguntaDesarrollo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String curso= request.getParameter("selCodigo");
		
		Respuesta resp= new Respuesta();
		
		String correcta="1";
		String incorrect="0";
				String curso= request.getParameter("x");
				String tema= request.getParameter("y");
				String subtema=request.getParameter("selCodigoSubtema");
				String codPreg=request.getParameter("txtCodigo");
				String DescpPregunta=request.getParameter("txtDescripcion");
				
				
				String descpAy=request.getParameter("txtDescripcionAyuda");
	            
				pregunta preg=new Desarrollo();
				
				entradaEncriptarDesencriptar objeto = new entradaEncriptarDesencriptar(DescpPregunta.toLowerCase(),26);
				Encriptar  nEncripcion = new EncriptarLlave();
				nEncripcion.encriptarCadena(objeto);
				
				preg.registrarPregunta(codPreg, subtema, nEncripcion.getPIN(), descpAy);
				
				Bitacora bitacora = new XML();
				bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro una pregunta de desarrollo");
				
				String resp1=request.getParameter("txtRespuesta");
				
				entradaEncriptarDesencriptar objeto1 = new entradaEncriptarDesencriptar(resp1.toLowerCase(),26);
				Encriptar  nEncripcion1 = new EncriptarLlave();
				nEncripcion1.encriptarCadena(objeto1);
				
				
				resp.registrarRespuesta(codPreg, nEncripcion1.getPIN(), correcta);
				
				BaseDeDatos bd= new BaseDeDatos();
				ArrayList<Curso> cursos = bd.selectCurso();
				
				request.setAttribute("ListCursos", cursos);
				
				request.getRequestDispatcher("RegistrarPreguntaDesarrollo.jsp").forward(request, response);
		
	}
}
