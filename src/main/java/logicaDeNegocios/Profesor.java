package logicaDeNegocios;

import com.itextpdf.text.log.SysoCounter;

import Integracion.BaseDeDatos;

public class Profesor {
	private String correo=null;
	private String contrasena=null;

	public Profesor(){	
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



	public String validarUsuario(String pCorreo, String pContrasena){
		BaseDeDatos conexion = new BaseDeDatos();
        Profesor lista []=new Profesor[conexion.getNumeroRegistros("profesor", "codprofesor")];
        lista=conexion.selectProfesor();
        for (int i=0;i<lista.length;i++){
			Profesor profe=(Profesor)lista[1];
			if ((profe.correo.equals(pCorreo))&&(profe.contrasena.equals(pContrasena))){
				setCorreo(pCorreo);
				setContrasena(pContrasena);
			return "Bien";
			}
		}
        return "Malo";

	}
	

}
