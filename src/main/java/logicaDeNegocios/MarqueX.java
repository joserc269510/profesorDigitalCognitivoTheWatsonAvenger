package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class  MarqueX extends Pregunta
{
	protected String tipoPregunta;
	protected String  descripcionTipoPreg;; 
	

	
	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public String getTipoPregunta()
	{
		return tipoPregunta;
	}

	public void setTipoPregunta(String pTipoPregunta) 
	{
		tipoPregunta = pTipoPregunta;
	}

	public String getDescripcionTipoPreg() 
	{
		return descripcionTipoPreg;
	}

	public void setDescripcionTipoPreg(String pDescripcionTipoPreg) 
	{
		descripcionTipoPreg = pDescripcionTipoPreg;
	}
	
	
	
	
}
