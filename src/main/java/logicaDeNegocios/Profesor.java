package logicaDeNegocios;

import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.log.SysoCounter;

import Integracion.BaseDeDatos;

public class Profesor {
	private String codProfesor=null;
	private String correo=null;
	private String contrasena=null;
	BaseDeDatos conexion;

	public Profesor(){	
		conexion = new BaseDeDatos();
	}
	public Profesor(String codProfesor,String correo,String contrasena){
		setCodProfesor(codProfesor);
		setCorreo(correo);
		setContrasena(contrasena);
		conexion = new BaseDeDatos();
	}
	
	
	public void registrarP(String pContrasena, String pCorreo)
	{
		setCorreo(pCorreo);
		setContrasena(pContrasena);
        getConexion().insertDelete("insert into profesor values (" +1 +  "'"  + pContrasena + "'" +"," + "'" + pCorreo + "'" + ")" ) ;
	}
	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}
	public String getCodProfesor() {
		return codProfesor;
	}

	public void setCodProfesor(String string) {
		this.codProfesor = string;
	}

	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean validarUsuario(String pCorreo, String pContrasena){
		
        ArrayList<Profesor> lista =new ArrayList<Profesor>();
        lista=conexion.selectProfesor();
        //System.out.println(lista.length);
        for (int i=0;i<lista.size();i++){
        	
			if ((lista.get(i).getCorreo().equals(pContrasena))&&(lista.get(i).getContrasena().equals(pCorreo))){
				
				
				
			return true;
			}
		}
        return false;

	}
	public static void main(String[] args) {
		Profesor j=new Profesor();
		j.validarUsuario("thewatsonavengers@gmail.com", "proyecto1");
	}

}
