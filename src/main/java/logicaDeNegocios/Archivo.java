package logicaDeNegocios;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;




public class Archivo 
{
	public String CargarArchivo(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Ruta donde se guardara el fichero
		File destino=new File("C:\\Users\\Cora\\Desktop\\profesorDigitalCognitivoTheWatsonAvenger");
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
		return fichero.getAbsolutePath();
		
	}
	
	public String CargarArchivo1(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Ruta donde se guardara el fichero
		File destino=new File("C:\\Users\\Cora\\Desktop\\profesorDigitalCognitivoTheWatsonAvenger");
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
		return fichero.getAbsolutePath();
		
	}
	
	public void EscribirArchivoTXT(String rutaP)
	{
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	
            fichero = new FileWriter("C:/Users/Cora/Desktop/profesorDigitalCognitivoTheWatsonAvenger/prueba.txt", false);
            pw = new PrintWriter(fichero);

            
                pw.println(rutaP + ",");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}


}
