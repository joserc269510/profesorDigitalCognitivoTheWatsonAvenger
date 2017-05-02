package logicaDeNegocios;

import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Tema {
	int codTema;
	String descripcionTema;
	ArrayList subtemas;
	ArrayList cursos;//falta modificador
	BaseDeDatos conexion;
	
	public Tema(int codTema, String descripcionTema){
		subtemas = new ArrayList<Subtema>();
		cursos = new ArrayList<Curso>();
		setCodTema(codTema);
		setDescripcionTema(descripcionTema);
		conexion = new BaseDeDatos();
	}
	public Tema(){
		conexion = new BaseDeDatos();
	}
	
	
	public void anadirCurso(Curso curso){
		cursos.add(curso);
	}
	
	public void anadirSubTema(int codsubtema, String descripcion){
		Subtema subtema = new Subtema(codsubtema, descripcion);
		subtemas.add(subtema);
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
	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}	
	
}
