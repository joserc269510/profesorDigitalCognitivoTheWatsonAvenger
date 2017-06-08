package Servlet;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import Integracion.BaseDeDatos;
import Integracion.Visual;
import Seguridad.GenerarCodigo;
import logicaDeNegocios.Archivo;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.pregunta;

/**
 * Servlet implementation class ServletAutentificarEstudiante
 */
@WebServlet("/ServletAutentificarEstudiante")
public class ServletAutentificarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutentificarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	
		String ruta = null;
		try {
	
			ruta=  CargarImagen(request, response);
			System.out.println(ruta +"Hola");
	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		String nombreImagen= obtenerNombreImagen(ruta);  
		
		Estudiante estudiante = new Estudiante();
		Boolean resp;
		resp= estudiante.AutentificarEstudiante(ruta);
		
		String evaluacion=request.getParameter("x");
		
		request.setAttribute("estudiante", estudiante);
		request.setAttribute("ruta", ruta);
		request.setAttribute("carnet", nombreImagen);
		request.setAttribute("Evaluacion", evaluacion);
		ArrayList<Estudiante> datos=  estudiante.ObtenerInformacionEstudiante(nombreImagen, ruta);
	
	    request.setAttribute("dato", datos);
	    BaseDeDatos baseDeDatos = new BaseDeDatos();
		   ArrayList<pregunta> preguntas = baseDeDatos.ObtenerPreguntasEvaluacion(evaluacion);
			System.out.println(preguntas.size());
			request.setAttribute("ListPreguntas", preguntas);
			request.setAttribute("CodEvaluacion", evaluacion);
		
		if(resp.equals(true))
		 { 
			   GenerarCodigo sms = new GenerarCodigo();

			   request.getRequestDispatcher("InformacionEstudiante.jsp").forward(request, response); 
			   sms.enviarSMS(baseDeDatos.selectNumeroTelefonoEstudiante(nombreImagen), nombreImagen);/////
	      }
		 else
		 {
	    	   request.getRequestDispatcher("/AutentificarEstudiante.jsp").forward(request, response);
	      }
	}





public String CargarImagen(HttpServletRequest request, HttpServletResponse response) throws Exception
{
	//Ruta donde se guardara el fichero
	//File destino=new File("/Users/joseramirezcalderon/Desktop/profesorDigitalCognitivoTheWatsonAvenger");
	File destino=new File("D:\\Users\\Esteban Morales\\git\\profesorDigitalCognitivoTheWatsonAvenger");
	FileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);

	// req es la HttpServletRequest que recibimos del formulario.
	// Los items obtenidos serán cada uno de los campos del formulario,
	// tanto campos normales como ficheros subidos.
	List<?> items = upload.parseRequest(request);

	File fichero = null;
	// Se recorren todos los items, que son de tipo FileItem
	for (Object item : items) {
	   FileItem uploaded = (FileItem) item;

	   // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
	   // subido donde nos interese
	   if (!uploaded.isFormField()) {
	      // No es campo de formulario, guardamos el fichero en algún sitio
	       fichero = new File(destino, uploaded.getName());
	      uploaded.write(fichero);
	   } else {
	      // es un campo de formulario, podemos obtener clave y valor
	      String key = uploaded.getFieldName();
	      String valor = uploaded.getString();
	   }
	}
	System.out.println(fichero.getAbsolutePath());
	String direccionFinal=transformarDireccion(fichero.getAbsolutePath());
	return ( direccionFinal);	
}



public String obtenerNombreImagen(String imagen)
{
	String path = imagen ;
    String file = path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf("."));
    String nombreImagen= file;
    
    return nombreImagen;
}



public String transformarDireccion(String Dir)
{
	String direccion = Dir;
	char ruta[]= direccion.toCharArray();
	char ruta2[]=new char[ruta.length+1];
	int k=0;

	for(int i=0;i<ruta.length;i++){
		if(ruta[i]==':')
		{
			ruta2[k]=ruta[i];
			k++;
			ruta2[k]='/';
		}
		else if(ruta[i]=='\\')
		{
			ruta2[k]='/';
		} 
		else {
			ruta2[k]=ruta[i];
		}
		k++;
}//fin del for

	direccion="";
	for(int i=0;i<ruta2.length;i++)
	{
		direccion+=ruta2[i];
		}
	return direccion; //regresa el valor del array convertido en string
	}
}
