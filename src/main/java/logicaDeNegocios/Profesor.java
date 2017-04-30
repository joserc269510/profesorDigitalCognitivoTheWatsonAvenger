package logicaDeNegocios;

import java.util.Date;

import com.itextpdf.text.log.SysoCounter;

import Integracion.BaseDeDatos;

public class Profesor {
	private String codProfesor=null;
	private String correo=null;
	private String contrasena=null;
	BaseDeDatos conexion = new BaseDeDatos();

	public Profesor(){	
	}
	
	public void registrarP(String pContrasena, String pCorreo)
	{
     
	
		setCorreo(pCorreo);
		setContrasena(pContrasena);
		
		
		BaseDeDatos conexion = new BaseDeDatos();
        conexion.insertDelete("insert into profesor values ("  +  "'"  + pContrasena + "'" +"," + "'" + pCorreo + "'" + ")" ) ;
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
		
        Profesor lista []=new Profesor[conexion.getNumeroRegistros("profesor", "codprofesor")];
        lista=conexion.selectProfesor();
        
        for (int i=0;i<lista.length;i++){
			System.out.println(lista[i].getCorreo());
			if ((lista[i].getCorreo().equals(pCorreo))&&(lista[i].getContrasena().equals(pContrasena))){
				setCorreo(pCorreo);
				setContrasena(pContrasena);
			return true;
			}
		}
        return false;

	}
	

}
