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

import Integracion.Visual;

import java.io.*;

/**
 * Servlet implementation class ServletEntrenarProfesor
 */
@WebServlet("/ServletEntrenarProfesor")
public class ServletEntrenarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEntrenarProfesor() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		try {
			String ruta= CargarArchivo(request);
			System.out.println(ruta);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		String clasificador= request.getParameter("txtClasificador");
	   	String clase = request.getParameter("txtClass"); 
	   	
	   	request.getRequestDispatcher("EntrenarProfesor.jsp").forward(request, response);
	 //  	Visual service= new Visual();
	  // 	service.EntrenarProfesorCognitivo(ruta, pRutaArhivoN, clasificador, clase);
		
	}
			



	private String CargarArchivo(HttpServletRequest request) throws Exception 
	{
		File destino = new File("C:\\Users\\Cora\\Desktop\\profesorDigitalCognitivoTheWatsonAvenger");
		 File fichero = null;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return fichero.getPath();
		}
	
	}
	
