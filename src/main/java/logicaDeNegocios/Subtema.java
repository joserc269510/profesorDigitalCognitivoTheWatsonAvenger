package logicaDeNegocios;
/*
 * ver si lo que esta documentado realmente sirve
 */
import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Subtema {
	private int codSubTema;
	private String descripcion;
	ArrayList preguntas;
	Tema tema;
	BaseDeDatos conexion;
	
	
	public Subtema(){
		conexion = new BaseDeDatos();
	}
	public Subtema(int pCodsubtema, String pDescripcion){
		preguntas = new ArrayList<Object>();//tener de las 3
		setCodSubTema(pCodsubtema);
		setDescripcion(pDescripcion);
		conexion = new BaseDeDatos();
	}
	public void anadirTema(int pCodTema, String pDescripcionTema){
		 tema = new Tema(pCodTema,  pDescripcionTema);
		 
	}
	public  void registrarSubTema(String pDescripcionSubtema)//no ha sido anadiad a la base
	{
	 	getConexion().insertDelete("insert into subtema(descripcion) values (" +  "'" + pDescripcionSubtema +"'" + ")");
	}
	
	public void actualizarSubtema(String pCodigo, String pCodTema, String pDescripcion)
	{
		setCodSubTema(Integer.parseInt(pCodigo));
		setDescripcion(pDescripcion);
		//BaseDeDatos conexion= new BaseDeDatos();
		getConexion().insertDelete("UPDATE subtema SET descripcion = '"+pDescripcion+"' , codtema = '"+pCodTema+"' WHERE codsubtema = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
	}
	
	/*
	public void anadirPreguntasMarqueX(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		pregunta pregunta = new MarqueX( codigoPregunta, codigoTipoPregunta, descripcionPregunta,  descripcionAyduda, tipoPregunta, descripcionTipoPreg);
		preguntas.add(pregunta);
	}
	public void anadirPreguntasRespuestaCorta(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		pregunta pregunta = new EspacioBlanco( codigoPregunta, codigoTipoPregunta, descripcionPregunta, descripcionAyduda, tipoPregunta, descripcionTipoPreg);
		preguntas.add(pregunta);
	}
	public void anadirPreguntasDesarrollo(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		pregunta pregunta = new Desarrollo( codigoPregunta,  codigoTipoPregunta, descripcionPregunta,  descripcionAyduda,  tipoPregunta,  descripcionTipoPreg);
		preguntas.add(pregunta);
	}
	*/ 
	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}
	public ArrayList getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList preguntas) {
		this.preguntas = preguntas;
	}
	public Tema getTema() {
		return tema;
	}
	public int getCodSubTema() {
		return codSubTema;
	}
	public void setCodSubTema(int codSubTema) {
		this.codSubTema = codSubTema;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
