package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Curso 
{
	String codigo; 
	String descripcionCurso;
	
	
	public void RegistrarCurso(String pCodigo, String pDescripcion)
	{
		setCodigo(pCodigo);
		setDescripcionCurso(pDescripcion);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into curso values (" + "'"+ pCodigo + "'" + "," + "'" + pDescripcion +"'" + ")");
		conexion.insertDelete("insert into curso values (" + "'" +pCodigo + "'"  + "," +  "'" + pDescripcion+"'" + ")");
	}
	
	public String getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getDescripcionCurso() 
	{
		return descripcionCurso;
	}
	
	public void setDescripcionCurso(String descripcionCurso) 
	{
		this.descripcionCurso = descripcionCurso;
	} 
	
	
}
