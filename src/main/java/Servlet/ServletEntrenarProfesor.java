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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		Archivo archivo= new Archivo();
		try {
			String ruta= archivo.CargarArchivo(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   request.getRequestDispatcher("EntrenarProfesor.html").forward(request, response);
//	   RequestDispatcher dispatcher = request.getRequestDispatcher("/EntrenarProfesor.jsp");
	//   dispatcher.forward(request, response);
	 //  	Visual service= new Visual();
	  // 	service.EntrenarProfesorCognitivo(ruta, pRutaArhivoN, clasificador, clase);
		
	}
			

	



	
}