package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Desarrollo extends pregunta 
{
	protected String tipoPregunta;
	protected String descripcionTipoPreg;


	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into tipopregunta values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	public String getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public String getDescripcion() 
	{
		return descripcionTipoPreg;
	}

	public void setDescripcion(String pDescripcion) 
	{
		descripcionTipoPreg = pDescripcion;
	}
	

}
