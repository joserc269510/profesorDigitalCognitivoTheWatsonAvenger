package logicaDeNegocios;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class Archivo 
{
	public String CargarArchivo(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Ruta donde se guardara el fichero
		File destino=new File("C:\\Desktop\\");
	//Convertimos el HTTPRequest en un ContextRequest,este paso es necesario en la ultima version, ya que los metodos de las versiones anteriores se han quedado desfasados.
		ServletRequestContext src=new ServletRequestContext(request);
	 
		String fileName = "" ;
		 
		if(ServletFileUpload.isMultipartContent(src))  //Si el formulario es enviado con Multipart
				{
			
			DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024),destino); //Necesario para evitar errores de NullPointerException
			ServletFileUpload upload=new  ServletFileUpload(factory); //Creamos un FileUpload
			List lista = null; //Procesamos el request para que nos devuelva una lista con los parametros y ficheros.
			
			//Archivo lista1=new Archivo();
			try {
				lista = upload.parseRequest(src);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File file= null;
			//Recorremos la lista.
			Iterator it = lista.iterator();
			while(it.hasNext()){
				//Rescatamos el fileItem
				FileItem item=(FileItem)it.next();
				//Comprobamos si es un campo de formulario
				if(item.isFormField()){
					//Hacemos lo que queramos con el.
					System.out.println(item.getFieldName()+"<br>");
					System.out.println("Tonta");
				}
			else
			{
				
				//Si no, es un fichero y lo subimos al servidor.
				//Primero creamos un objeto file a partir del nombre del fichero.
			
				file=new File(item.getName());
				
				//Lo escribimos en el disco usando la ruta donde se guardara el fichero y cogiendo el nombre del file
				
					System.out.println("Hola");
					 fileName = item.getName();
	                 String contentType = item.getContentType();
	                 String String  = item.getString(); 
	                 
	                 
	                 long size = item.getSize();
	                 request.setAttribute("fileName", fileName);
	                 System.out.println("Tonta" + fileName);
	                 request.setAttribute("contentType", contentType);
	                 request.setAttribute("size", size);
	                 System.out.println("size" +  size);
					 
					 
					 item.write(new File(destino,file.getName()));
					 
					// String docBase = getServletConfig().getServletContext().getRealPath ("/");
			    	// System.out.println(docBase);
		}

			}
			
				}
		return fileName;
		
	}

}
