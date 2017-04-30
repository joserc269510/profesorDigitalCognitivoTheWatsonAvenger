package logicaDeNegocios;

import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Curso 
{
	String codigo; 
	String descripcionCurso;
	ArrayList temas;
	
	public Curso(String codigo, String descripcionCurso){
		 temas = new ArrayList<Tema>();
		 setCodigo(codigo);
		 setDescripcionCurso(descripcionCurso);
	}
	
	public void registrarTema(Tema tema){
		temas.add(tema);
	}
	
	public ArrayList getTemas() {
		return temas;
	}

	public void setTemas(ArrayList temas) {
		this.temas = temas;
	}

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
