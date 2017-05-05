package logicaDeNegocios;

import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Tema {
	int codTema;
	String descripcionTema;
	ArrayList subtemas;
	ArrayList cursos;
	BaseDeDatos conexion;
	
	public Tema(int pCodTema, String pDescripcionTema){
		subtemas = new ArrayList<Subtema>();
		cursos = new ArrayList<Curso>();
		setCodTema(pCodTema);
		setDescripcionTema(pDescripcionTema);
		conexion = new BaseDeDatos();
	}
	
	public Tema(){
		conexion = new BaseDeDatos();
		setCodTema(codTema);
		setDescripcionTema(descripcionTema);

	}

	public void anadirCurso(Curso pCurso){
		cursos.add(pCurso);
	}
	
	public void anadirSubTema(int pCodsubtema, String pDescripcion){
		Subtema subtema = new Subtema(pCodsubtema, pDescripcion);
		subtemas.add(subtema);
	}
	
	
	public  void registrarTema(String pCodigoCurso,String pDescripcion)//no ha sido agregado al diseno
	{
	 	getConexion().insertDelete("insert into tema(codigocurso,descripciontema) values (" + "'"+ pCodigoCurso + "'" + "," + "'" + pDescripcion +"'" + ")");
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
	public int getCodTema() {
		return codTema;
	}
	public void setCodTema(int codTema) {
		this.codTema = codTema;
	}

	public String getDescripcionTema() {
		return descripcionTema;
	}
	public ArrayList getSubtemas() {
		return subtemas;
	}


	public ArrayList getCursos() {
		return cursos;
	}


	public void setDescripcionTema(String descripcionTema) {
		this.descripcionTema = descripcionTema;
	}
	
	
}
