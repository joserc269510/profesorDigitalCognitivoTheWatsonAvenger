package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Integracion.BaseDeDatos;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.Formativa;
import logicaDeNegocios.Subtema;
import logicaDeNegocios.Sumativa;
import logicaDeNegocios.Tema;

/**
 * Servlet implementation class ServletToSiguiente
 */
@WebServlet("/ServletToSiguiente")
public class ServletToSiguiente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToSiguiente() {
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
		
		String codEval=request.getParameter("txtCodigo");
		String curso= request.getParameter("selCodigoCurso");
		String nombre= request.getParameter("txtNombre");
		String tipoEval= request.getParameter("selCodigoEval");
		String pts= request.getParameter("txtPts");
		String nota= request.getParameter("txtNota");
		String tiempo= request.getParameter("txtTiempo");
		String descripcion= request.getParameter("txtDescripcion");
		String aleatorio= request.getParameter("txtAleatorio1");
		System.out.println("Aleatorio="+aleatorio);
		if(aleatorio.equals("Si")){
			System.out.println("SI");
			aleatorio="B'1'";
		}else{
			System.out.println("NO");
			aleatorio="B'0'";
		}
		
		
		request.setAttribute("CodEval", codEval);
		request.setAttribute("Curso", curso);
		request.setAttribute("Nombre", nombre);
		request.setAttribute("CodTipEval", tipoEval);
		request.setAttribute("Pts", pts);
		request.setAttribute("Nota", nota);
		request.setAttribute("Tiempo", tiempo);
		request.setAttribute("Descripcion", descripcion);
		request.setAttribute("Aleatorio", aleatorio);
		
		SimpleDateFormat mascara=new SimpleDateFormat("dd/MM/yy");
		String fecha= mascara.format(Calendar.getInstance().getTime());
		
		Evaluacion evaluacion;
		if(tipoEval.equals("2")){
			evaluacion=new Formativa();
			evaluacion.registrarEvaluacion(codEval, curso, tipoEval, nombre, Integer.parseInt(pts), Integer.parseInt(nota), fecha, Integer.parseInt(tiempo), aleatorio);
		}
		if(tipoEval.equals("1")){
			evaluacion=new Sumativa();
			evaluacion.registrarEvaluacion(codEval, curso, tipoEval, nombre, Integer.parseInt(pts), Integer.parseInt(nota), fecha, Integer.parseInt(tiempo), aleatorio);
		}
		
		Bitacora bitacora = new Bitacora();
		bitacora.insertarEnBitacora("thewatsonavengers@gmail.com", "se registro una evaluacion");
		
		BaseDeDatos bd= new BaseDeDatos();
		ArrayList<Curso> cursos = bd.selectCurso();
		request.setAttribute("ListCursos", cursos);
		ArrayList<String> tipoEvaluacion = bd.selectTipoEvaluacion();
		request.setAttribute("ListTipoEval", tipoEvaluacion);
		ArrayList<Tema> temas = bd.selectTema();
		request.setAttribute("ListTemas", temas);
		ArrayList<Subtema> subtemas = bd.selectSubTema();
		request.setAttribute("ListSubtemas", subtemas);
		ArrayList<String> pregunta = bd.selectTipoPregunta();
		request.setAttribute("ListTipoPreguntas", pregunta);
		request.getRequestDispatcher("ConfigurarEvaluacion2.jsp").forward(request, response);
		

	}

}
