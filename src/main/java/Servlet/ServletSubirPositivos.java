package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.*;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import Integracion.Visual;
import logicaDeNegocios.Archivo;



import java.io.*;

/**
 * Servlet implementation class ServletEntrenarProfesor
 */
@WebServlet("/ServletEntrenarProfesor")
public class ServletSubirPositivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSubirPositivos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
	 
		String ruta = null;
		try {
			ruta=  CargarArchivo(request, response);
			System.out.println(ruta +"Hola");
			request.setAttribute("rutaP", ruta);
			//archivo.EscribirArchivoTXT(ruta);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		//String clasificador= request.getParameter("txtClasificador");
		//String clase= request.getParameter("txtClass");
//		Visual service= new Visual();
	  // 	service.EntrenarProfesorCognitivo(ruta, clasificador, clase);
		
		
	   	request.getRequestDispatcher("SubirNegativos.jsp").forward(request, response);
		
	}
	
	public String CargarArchivo(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Ruta donde se guardara el fichero
		//File destino=new File("C:\\Users\\Cora\\Desktop\\profesorDigitalCognitivoTheWatsonAvenger");
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