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
import Integracion.*;
import Seguridad.*;
import logicaDeNegocios.*;

/**
 * Servlet implementation class ServletRegistrarPreguntaM
 */
@WebServlet("/ServletRegistrarPreguntaM")
public class ServletRegistrarPreguntaM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarPreguntaM() {
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
		
		request.getRequestDispatcher("RegistrarPreguntaMarqueX.jsp").forward(request, response);
		
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
	            
				pregunta preg=new MarqueX();
				
				entradaEncriptarDesencriptar objeto = new entradaEncriptarDesencriptar(DescpPregunta.toLowerCase(),26);
				Encriptar  nEncripcion = new EncriptarLlave();
				nEncripcion.encriptarCadena(objeto);
				
				preg.registrarPregunta(codPreg, subtema, nEncripcion.getPIN(), descpAy);
				
				String chk1= request.getParameter("chk1");
				String resp1=request.getParameter("txtRespuesta1");
				System.out.println(resp1);
				System.out.println(chk1);
				if (resp1!=null){
					System.out.println(resp1);
					System.out.println(chk1);
					entradaEncriptarDesencriptar objeto1 = new entradaEncriptarDesencriptar(resp1.toLowerCase(),26);
					Encriptar  nEncripcion1 = new EncriptarLlave();
					nEncripcion1.encriptarCadena(objeto1);
					
					if(chk1!=null){
						
						resp.registrarRespuesta(codPreg, nEncripcion1.getPIN(), correcta);
					}
					else
						
						resp.registrarRespuesta(codPreg, nEncripcion1.getPIN(), incorrect);
				}
				//resp.registrarRespuesta(codP, descp, stt);
				String resp2=request.getParameter("txtRespuesta2");
				String chk2= request.getParameter("chk2");
				System.out.println(resp2);
				System.out.println(chk2);
				if (resp2!=null){
					System.out.println(resp2);
					System.out.println(chk2);
					
					entradaEncriptarDesencriptar objeto2 = new entradaEncriptarDesencriptar(resp2.toLowerCase(),26);
					Encriptar  nEncripcion2 = new EncriptarLlave();
					nEncripcion2.encriptarCadena(objeto2);
					
					if(chk2!=null){
						resp.registrarRespuesta(codPreg, nEncripcion2.getPIN(), correcta);
					}
					else
						resp.registrarRespuesta(codPreg, nEncripcion2.getPIN(), incorrect);
				}
				String resp3=request.getParameter("txtRespuesta3");
				String chk3= request.getParameter("chk3");
				System.out.println(resp3);
				System.out.println(chk3);
				if (resp3!=null){
					System.out.println(resp3);
					System.out.println(chk3);
					
					entradaEncriptarDesencriptar objeto3 = new entradaEncriptarDesencriptar(resp3.toLowerCase(),26);
					Encriptar  nEncripcion3 = new EncriptarLlave();
					nEncripcion3.encriptarCadena(objeto3);
					
					if(chk3!=null){
						resp.registrarRespuesta(codPreg, nEncripcion3.getPIN(), correcta);
					}
					else
						resp.registrarRespuesta(codPreg, nEncripcion3.getPIN(), incorrect);
				}
				String resp4=request.getParameter("txtRespuesta4");
				String chk4= request.getParameter("chk4");
				System.out.println(resp4);
				System.out.println(chk4);
				if (resp4!=null){
					System.out.println(resp4);
					System.out.println(chk4);
					
					entradaEncriptarDesencriptar objeto4 = new entradaEncriptarDesencriptar(resp4.toLowerCase(),26);
					Encriptar  nEncripcion4 = new EncriptarLlave();
					nEncripcion4.encriptarCadena(objeto4);
					
					if(chk4!=null){
						resp.registrarRespuesta(codPreg, nEncripcion4.getPIN(), correcta);
					}
					else
						resp.registrarRespuesta(codPreg, nEncripcion4.getPIN(), incorrect);
				}
				
				BaseDeDatos bd= new BaseDeDatos();
				ArrayList<Curso> cursos = bd.selectCurso();
				
				Bitacora bitacora = new XML();
				bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro una pregunta de marque con x");
				
				request.setAttribute("ListCursos", cursos);
				
				request.getRequestDispatcher("RegistrarPreguntaMarqueX.jsp").forward(request, response);
		
	}

}
