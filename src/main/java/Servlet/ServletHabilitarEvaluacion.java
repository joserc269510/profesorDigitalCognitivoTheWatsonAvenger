package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import Integracion.Correo;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.Evaluacion;

/**
 * Servlet implementation class ServletHabilitarEvaluacion
 */
@WebServlet("/ServletHabilitarEvaluacion")
public class ServletHabilitarEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHabilitarEvaluacion() {
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
		String codEvaluacion=request.getParameter("selCodigo");
		String[] listEstudiantes=request.getParameterValues("selEstudiante");
		
		
		
		 Evaluacion evaluacion=new Evaluacion() {
			
			@Override
			public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,
					String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion,
					int pTiempominutos, String pAleatorio) {
				// TODO Auto-generated method stub
				
			}
		};
		
		evaluacion.habilitarEvaluacion(codEvaluacion);
		BaseDeDatos bd=new BaseDeDatos();
		
		System.out.println("LARGO= "+listEstudiantes.length);
		for(int i=0;i<listEstudiantes.length;i++){
			System.out.println("CORREO= "+bd.ObtenerCorreoEstudiante(listEstudiantes[i]));
			System.out.println("IDENTIFICACION= "+listEstudiantes[i]);
			evaluacion.registrarEstudiante(listEstudiantes[i], codEvaluacion);
			Correo nCorreo=new Correo();
			nCorreo.SendMail(bd.ObtenerCorreoEstudiante(listEstudiantes[i]),"Notificación de Evaluación", "Usted tiene una evaluación pendiente en la aplicación del profesor digital cognitivo"+"\n"+"Ingresar al siguiente Link"+"\n"+"http://localhost:8080/JavaHelloWorldApp/AutentificarEstudiante.jsp?x="+codEvaluacion);
		}
		
		ArrayList<Evaluacion> evaluaciones = bd.selectEvaluacion();
		ArrayList<Estudiante> estudiantes= bd.selectEstudiante();
		request.setAttribute("ListEstudiantes", estudiantes);
		request.setAttribute("ListEval", evaluaciones);
		request.getRequestDispatcher("HabilitarEvaluacion.jsp").forward(request, response);
	}

}
