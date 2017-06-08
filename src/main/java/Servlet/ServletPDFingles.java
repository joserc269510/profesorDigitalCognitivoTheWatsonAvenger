package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import Integracion.BaseDeDatos;
import Integracion.Traductor;
import Seguridad.Desencriptar;
import Seguridad.DesencriptarLlave;
import Seguridad.entradaEncriptarDesencriptar;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletPDFingles
 */
@WebServlet("/ServletPDFingles")
public class ServletPDFingles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPDFingles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //get the output stream for writing binary data in the response.
		  ServletOutputStream os = response.getOutputStream();
		  //set the response content type to PDF
		  response.setContentType("application/pdf"); 
		  response.setHeader("Content-Disposition","attachment;filename=Informacion Evaluacion en Ingles.pdf");
		  //create a new document
		  Document doc = new Document();

		  //create some special styles and font sizes
		  Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
		  Font bfBold19 = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD, new BaseColor(0, 0, 0));
		  Font bfBold17 = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, new BaseColor(0, 0, 0));

		  
		  String codEvaluacion = request.getParameter("selCodigo");

		  BaseDeDatos bd = new BaseDeDatos();
		  Traductor traducir=new Traductor();
		  Evaluacion evaluacion = bd.selectEvaluacion(codEvaluacion);
		  
		  try{
		   
		   //create an instance of the PdfWriter using the output stream
		   PdfWriter.getInstance(doc, os); 

		   //document header properties
		   doc.addAuthor("Esteban Morales");
		   doc.addCreationDate();
		   doc.addProducer();
		   doc.addCreator("Esteban");
		   doc.addTitle("Informacion de Evaluacion en ingles");
		   doc.setPageSize(PageSize.LETTER);
		   doc.open();
		   
		   
		   

		 //add a new paragraph
		   doc.add( new Paragraph(traducir.Traduccion("Informacion de la Evaluacion"), bfBold18));
		   doc.add( new Paragraph(traducir.Traduccion("Codigo de Evaluacion= "+codEvaluacion), bfBold19));
		   doc.add( new Paragraph(traducir.Traduccion("Nombre de Evaluacion= "+evaluacion.getNombreEvaluacion()), bfBold17));
		   doc.add( new Paragraph(traducir.Traduccion("Fecha de Evaluacion= "+evaluacion.getFechaEvaluacion()), bfBold17));
		   doc.add( new Paragraph(traducir.Traduccion("Codigo del curso= "+evaluacion.getCurso().getCodigo()), bfBold17));
		   doc.add( new Paragraph(traducir.Traduccion("Puntaje Total= "+evaluacion.getPuntajeTotal()), bfBold17));
		   doc.add( new Paragraph(traducir.Traduccion("Porcentaje sobre nota final= "+evaluacion.getPorcentajeNotaFinal()), bfBold17));
		   doc.add( new Paragraph(traducir.Traduccion("Tiempo en minutos para realizar la prueba= "+evaluacion.getTiempoMinutos()), bfBold17));
		   if(!evaluacion.isStatus()){
			   doc.add( new Paragraph(traducir.Traduccion("Estado= Deshabilitada"), bfBold17));
		   }
		   else{
			   doc.add( new Paragraph(traducir.Traduccion("Estado= Habilitada"), bfBold17));
		   }
		   ArrayList<Estudiante> estudiantes=bd.ObtenerEstudiantesEvaluacion(codEvaluacion);
		   ArrayList<pregunta> preguntas=bd.ObtenerPreguntasEvaluacion(codEvaluacion);
		   doc.add(new Paragraph(traducir.Traduccion("Preguntas"), bfBold19));
		   for(pregunta p:preguntas){
			     
				entradaEncriptarDesencriptar objeto = new entradaEncriptarDesencriptar(p.getDescripcionPregunta().toLowerCase(),26);
				Desencriptar nDescripcion = new DesencriptarLlave();
				nDescripcion.desencriptarCadena(objeto);
				
			   doc.add( new Paragraph(traducir.Traduccion("Codigo de Pregunta = "+p.getCodigoPregunta()+", Descripcion de Pregunta = "+nDescripcion.getPIN()), bfBold17));
		   }
		   doc.add(new Paragraph(traducir.Traduccion("Estudiantes"), bfBold19));
		   for(Estudiante e:estudiantes){
			   String nota=bd.ObtenerNotaEstudiante(e.getNumeroIdentificacion(),codEvaluacion);
			   doc.add( new Paragraph(traducir.Traduccion("Carnet Estudiante = "+e.getNumeroCarnet()+", Nombre del Estudiante = ")+e.getNombre()+" "+e.getApellido1()+" "+e.getApellido2()+", Nota = "+nota, bfBold17));
		   }
		   
		   doc.close();

		  }catch(DocumentException e){
		   e.printStackTrace();
		  }
		  catch(Exception e){
		   e.printStackTrace();
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
