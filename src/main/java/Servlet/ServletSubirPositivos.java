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
		
		Archivo archivo= new Archivo();
		String ruta = null;
		try {
			ruta=  archivo.CargarArchivo(request, response);
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
		request.setAttribute("rutaP", ruta);
	   	request.getRequestDispatcher("EntrenarProfesor.html").forward(request, response);
		
	}
			

	



	
}