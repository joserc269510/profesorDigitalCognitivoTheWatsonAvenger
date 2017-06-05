package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.*;
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
				preg.registrarPregunta(codPreg, subtema, DescpPregunta, descpAy);
				
				String chk1= request.getParameter("chk1");
				String resp1=request.getParameter("txtRespuesta1");
				System.out.println(resp1);
				System.out.println(chk1);
				if (resp1!=null){
					System.out.println(resp1);
					System.out.println(chk1);
					if(chk1!=null){
						resp.registrarRespuesta(codPreg, resp1, correcta);
					}
					else
						resp.registrarRespuesta(codPreg, resp1, incorrect);
				}
				//resp.registrarRespuesta(codP, descp, stt);
				String resp2=request.getParameter("txtRespuesta2");
				String chk2= request.getParameter("chk2");
				System.out.println(resp2);
				System.out.println(chk2);
				if (resp2!=null){
					System.out.println(resp2);
					System.out.println(chk2);
					if(chk2!=null){
						resp.registrarRespuesta(codPreg, resp2, correcta);
					}
					else
						resp.registrarRespuesta(codPreg, resp2, incorrect);
				}
				String resp3=request.getParameter("txtRespuesta3");
				String chk3= request.getParameter("chk3");
				System.out.println(resp3);
				System.out.println(chk3);
				if (resp3!=null){
					System.out.println(resp3);
					System.out.println(chk3);
					if(chk3!=null){
						resp.registrarRespuesta(codPreg, resp3, correcta);
					}
					else
						resp.registrarRespuesta(codPreg, resp3, incorrect);
				}
				String resp4=request.getParameter("txtRespuesta4");
				String chk4= request.getParameter("chk4");
				System.out.println(resp4);
				System.out.println(chk4);
				if (resp4!=null){
					System.out.println(resp4);
					System.out.println(chk4);
					if(chk4!=null){
						resp.registrarRespuesta(codPreg, resp4, correcta);
					}
					else
						resp.registrarRespuesta(codPreg, resp4, incorrect);
				}
				
				BaseDeDatos bd= new BaseDeDatos();
				ArrayList<Curso> cursos = bd.selectCurso();
				
				request.setAttribute("ListCursos", cursos);
				
				request.getRequestDispatcher("RegistrarPreguntaMarqueX.jsp").forward(request, response);
		
	}

}
