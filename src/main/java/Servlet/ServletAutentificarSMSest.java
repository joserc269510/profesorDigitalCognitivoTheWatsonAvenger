package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Seguridad.GenerarCodigo;

/**
 * Servlet implementation class ServletAutentificarSMSest
 */
@WebServlet("/ServletAutentificarSMSest")
public class ServletAutentificarSMSest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutentificarSMSest() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String codigoIngresado = request.getParameter("smsCodigo");
		String carnet = request.getParameter("x");
		
		
		GenerarCodigo seguridadSMS = new GenerarCodigo();
		seguridadSMS.validarCodigo(codigoIngresado, carnet);
		
	}

}
