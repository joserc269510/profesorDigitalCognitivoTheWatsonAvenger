package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Profesor {
	public String correo=null;
	public String contrasena=null;

	public Profesor(){	
	}
	
	
	public void validarUsuario(String pCorreo, String pContrasena){
		BaseDeDatos conexion = new BaseDeDatos();
        //conexion.insertDelete("insert into estudiante values (" + pNumeroIdentificacion  + "," +  "'" + pNombre + "'" + "," + "'"+ pApellido1 + "'" + "," + "'" + pApellido2 + "'"+ "," +  "'" +pNumeroCarnet + "'" + "," + "'"+ pFechaNacimiento +  "'"+ "," + "'" + pEmail +"'" + ")" ) ;
	}
	

}
