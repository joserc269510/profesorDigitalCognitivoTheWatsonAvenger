package logicaDeNegocios;

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
		
        Profesor lista []=new Profesor [getConexion().getNumeroRegistros("profesor", "codprofesor")];
        lista=conexion.selectProfesor();
        
        for (int i=0;i<lista.length;i++){
			
			if ((lista[i].getCorreo().equals(pCorreo))&&(lista[i].getContrasena().equals(pContrasena))){
				setCorreo(pCorreo);
				setContrasena(pContrasena);
				
			return true;
			}
		}
        return false;

	}
	

}
