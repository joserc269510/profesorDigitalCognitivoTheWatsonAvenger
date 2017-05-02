package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Respuesta {
	int codRespuesta;
	int codigoPregunta;
	String descripcionRespuesta;
	boolean status;
	BaseDeDatos conexion;
	
	
	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}
	public int getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(int codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public int getCodigoPregunta() {
		return codigoPregunta;
	}
	public void setCodigoPregunta(int codigoPregunta) {
		this.codigoPregunta = codigoPregunta;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
