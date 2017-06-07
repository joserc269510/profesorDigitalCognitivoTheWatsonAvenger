package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import Seguridad.Desencriptar;
import logicaDeNegocios.Respuesta;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletCalificarEvaluacion
 */
@WebServlet("/ServletCalificarEvaluacion")
public class ServletCalificarEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCalificarEvaluacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String evaluacion=request.getParameter("x");
		Respuesta Ev=new Respuesta();
		BaseDeDatos bd = new BaseDeDatos();
		ArrayList<pregunta> preguntas = bd.ObtenerPreguntasEvaluacion(evaluacion);
		ArrayList<String> resp=new ArrayList<String>();
		for(int i=0;i<preguntas.size();i++){
			//System.out.print("pregunta: ");
			Desencriptar nDescripcion2=new Desencriptar(preguntas.get(i).getDescripcionPregunta(),26); 
			//System.out.println(nDescripcion2.getPIN());
			resp.add( (String) request.getParameter(Integer.toString(preguntas.get(i).getCodigoPregunta())));
		  //System.out.print("respuesta: ");
		  //System.out.println((String) request.getParameter(Integer.toString(preguntas.get(i).getCodigoPregunta())));
		}
		int calificacion=0;
		int indicePre=0;
		System.out.println("////////////////-----------------------");
		int total=0;
		for(int z=0;z<preguntas.size();z++){
			System.out.println("pregunta"+z);
			System.out.println();
			System.out.print("pregunta: ");
			Desencriptar nDescripcion2=new Desencriptar(preguntas.get(z).getDescripcionPregunta(),26); 
			System.out.println(nDescripcion2.getPIN());
			System.out.println("////");
			System.out.print("respuesta estudiante : ");
			System.out.println(resp.get(z).toLowerCase());
			//boolean result=Ev.evaluar(resp.get(z),   Integer.toString(preguntas.get(z).getCodigoPregunta()));
			//System.out.println(result);
			String type;
	    	
	    	type=bd.ObtenerTipoPreguntas(preguntas.get(z).getCodigoPregunta());
	    	if(type.equals("1")){
	    		int stt=0;
	    		int pts=0;
	    		stt=bd.ObtenerStatusRespuesta(resp.get(z).toLowerCase());
	    		if(stt==1){
	    			pts=bd.ObtenerPuntajeEvaluacion(evaluacion, Integer.toString(preguntas.get(z).getCodigoPregunta()));
	    			System.out.println("correctaaaaaaaaaaaa");
	    			System.out.println("puntos: "+pts);
	    			calificacion+=pts;
	    		}
	    	}
	    	if(type.equals("2")){
	    		String correcta=bd.ObtenerDescripcionRespuesta(Integer.toString(preguntas.get(z).getCodigoPregunta()));
	    		//System.out.println(correcta);
	    		Desencriptar nDescripcion3=new Desencriptar(correcta,26);
	    		System.out.println("respuesta correcta-----------------------");
	    		System.out.println(nDescripcion3.getPIN());
	    		Respuesta j=new Respuesta();
	    		int pts=0;
	    		boolean result=j.revisar(resp.get(z).toLowerCase(),nDescripcion3.getPIN());
	    		if(result==true){
	    			pts=bd.ObtenerPuntajeEvaluacion(evaluacion, Integer.toString(preguntas.get(z).getCodigoPregunta()));
	    			System.out.println("correctaaaaaaaaaaaa");
	    			System.out.println("puntos: "+pts);
	    			calificacion+=pts;
	    		}
	    		  	}
	    	if(type.equals("3")){
	    		String correcta=bd.ObtenerDescripcionRespuesta(Integer.toString(preguntas.get(z).getCodigoPregunta()));
	    		Desencriptar nDescripcion3=new Desencriptar(correcta,26);
	    		System.out.println("respuesta correcta-----------------------");
	    		System.out.println(nDescripcion3.getPIN());
	    		Respuesta j=new Respuesta();
	    		boolean result=j.revisar(resp.get(z).toLowerCase(),nDescripcion3.getPIN());
	    		int pts=0;
	    		if(result==true){
	    			pts=bd.ObtenerPuntajeEvaluacion(evaluacion, Integer.toString(preguntas.get(z).getCodigoPregunta()));
	    			System.out.println("correctaaaaaaaaaaaa");
	    			System.out.println("puntos: "+pts);
	    			calificacion+=pts;
	    		}
	    	}
			/*if(result==true){
				System.out.println("entroo");
				total=+bd.ObtenerPuntajeEvaluacion(resp.get(z),Integer.toString(preguntas.get(z).getCodigoPregunta()));
				System.out.println(bd.ObtenerPuntajeEvaluacion(resp.get(z),Integer.toString(preguntas.get(z).getCodigoPregunta())));
			
			}
			*/
			
			
		}
		System.out.println(calificacion);
		request.setAttribute("calificacion", calificacion);
		request.getRequestDispatcher("Calificacion.jsp").forward(request, response);
	}

}
