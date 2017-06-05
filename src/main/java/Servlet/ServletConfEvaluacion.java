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
import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.Formativa;
import logicaDeNegocios.Subtema;
import logicaDeNegocios.Sumativa;
import logicaDeNegocios.Tema;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletConfEvaluacion
 */
@WebServlet("/ServletConfEvaluacion")
public class ServletConfEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfEvaluacion() {
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
		String chk1= request.getParameter("chk1");
		String chk2= request.getParameter("chk2");
		String tipoPregunta= request.getParameter("selTipoPre");
		String tema= request.getParameter("selTema");
		String subtema= request.getParameter("selSubtema");
		BaseDeDatos bd = new BaseDeDatos();
		ArrayList<pregunta> preguntas=new ArrayList<pregunta>();
		if(chk2!=null){
			System.out.println("------Subtemas------");
			preguntas = bd.SelectTipoPreguntaPorSubtema(tipoPregunta, subtema);
		}
		else if (chk1!=null){
			System.out.println("------Temas------");
			preguntas = bd.SelectTipoPreguntaPorTema(tipoPregunta, tema);
		}else{
			System.out.println("------Normal------");
			preguntas = bd.SelectTipoPreguntaEspecifica(tipoPregunta);
		}
		
		
		request.setAttribute("ListPreguntas", preguntas);
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
		
		String codEval=request.getParameter("cEv");
		String tipoEval= request.getParameter("tEv");;
		String codPregunta= request.getParameter("selPre");
		String puntaje= request.getParameter("txtPts");
		
		request.setAttribute("CodEval", codEval);

		request.setAttribute("CodTipEval", tipoEval);
		
		Evaluacion evaluacion;
		if(tipoEval.equals("1")){
			evaluacion=new Formativa();
			
			evaluacion.registrarPregunta(Integer.parseInt(codPregunta), Integer.parseInt(codEval), Integer.parseInt(puntaje));
		}
		if(tipoEval.equals("2")){
			evaluacion=new Sumativa();
			
			evaluacion.registrarPregunta(Integer.parseInt(codPregunta), Integer.parseInt(codEval), Integer.parseInt(puntaje));

		}
		request.getRequestDispatcher("ConfigurarEvaluacion2.jsp").forward(request, response);
	}

}
