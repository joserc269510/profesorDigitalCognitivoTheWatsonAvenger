package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bitacora.Bitacora;
import Integracion.BaseDeDatos;
import logicaDeNegocios.Profesor;

/**
 * Servlet implementation class ServletDescargarCSV
 */
@WebServlet("/ServletDescargarCSV")
public class ServletDescargarCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDescargarCSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		BaseDeDatos profe = new BaseDeDatos();
		ArrayList<Profesor> profes= profe.selectProfe();
		String fechaInicio= request.getParameter("x");
		String fechaFinal= request.getParameter("y");
		String tipoArhivo= request.getParameter("z");
		
		CompararTipoArchivo(tipoArhivo, profes.get(0).getCorreo(), fechaInicio, fechaFinal);
			
		request.getRequestDispatcher("/ConsultarBitacora.jsp").forward(request, response);
	}
	
	public void CompararTipoArchivo(String tipo, String pUsuario,String pFechaI, String pFechaF)
	{
		Bitacora bitacora= new Bitacora();
		if (tipo.equals("CSV"))
		{
			bitacora.generarCSV(pUsuario,pFechaI,pFechaF);
		}
		if (tipo.equals("XML"))
		{
			bitacora.generarXML(pUsuario,pFechaI,pFechaF);
		}
		if(tipo.equals("TXT"))
		{
			bitacora.generarArchivoPlano(pUsuario,pFechaI,pFechaF);
		}
			
	}

}
