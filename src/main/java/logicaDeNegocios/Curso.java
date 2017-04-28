package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Curso 
{
	private String codigo; 
	private String descripcionCurso;
	
	
	public void RegistrarCurso(String pCodigo, String pDescripcion)
	{
		setCodigo(pCodigo);
		setDescripcionCurso(pDescripcion);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into curso values (" + "'" +pCodigo + "'"  + "," +  "'" + pDescripcion+"'" + ")");
	}
	
	public String getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(String pCodigo) 
	{
		codigo = pCodigo;
	}
	
	public String getDescripcionCurso() 
	{
		return descripcionCurso;
	}
	
	public void setDescripcionCurso(String pDescripcionCurso) 
	{
		descripcionCurso = pDescripcionCurso;
	} 
	
	
}
