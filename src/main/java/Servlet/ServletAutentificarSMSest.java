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
import Seguridad.EnviarSMS;
import Seguridad.GenerarCodigo;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletAutentificarSMSest
 */
@WebServlet("/ServletAutentificarSMSest")
public class ServletAutentificarSMSest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutentificarSMSest() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoIngresado = request.getParameter("smsCodigo");
		String evaluacion=request.getParameter("x");
		String carnet=request.getParameter("y");
		String errores=request.getParameter("z");
		System.out.println("CODIGO ING= "+codigoIngresado);
		System.out.println("CARNET= "+carnet);
		
		
		GenerarCodigo seguridadSMS = new GenerarCodigo();
		Boolean isIgual=seguridadSMS.validarCodigo(codigoIngresado, carnet);
		System.out.println(isIgual);
		BaseDeDatos bd = new BaseDeDatos();
		ArrayList<pregunta> preguntas = bd.ObtenerPreguntasEvaluacion(evaluacion);
		
		request.setAttribute("ListPreguntas", preguntas);
		request.setAttribute("CodEvaluacion", evaluacion);
		request.setAttribute("carnet", carnet);
		if(isIgual==true){
			
			request.getRequestDispatcher("RealizarEvaluacion.jsp").forward(request, response);
		}else{
			if(errores.equals("0")){
				request.setAttribute("error", "1");
				request.getRequestDispatcher("AutentificarEstudianteSMS.jsp").forward(request, response);
			}else{
				EnviarSMS sms = new EnviarSMS(bd.selectNumeroTelefonoEstudiante(carnet), "Su evaluacion ha sido bloqueada");
				//EnviarSMS sms = new EnviarSMS("87113820", "Su evaluacion N "+evaluacion+" ha sido bloqueada");
				Correo nCorreo=new Correo();
				nCorreo.SendMail("estebanmorales1594@hotmail.com", "Evaluacion Bloqueada", "La evaluacion N "+evaluacion+" del estudiante "+carnet+" ha sido bloqueada por errar 2 veces en la contraseña");
				nCorreo.SendMail("cora2994@gmail.com", "Evaluacion Bloqueada", "La evaluacion N "+evaluacion+" del estudiante "+carnet+" ha sido bloqueada por errar 2 veces en la contraseña");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
	}

}
