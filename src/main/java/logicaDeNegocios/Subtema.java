package logicaDeNegocios;

import java.util.ArrayList;

public class Subtema {
	int codSubTema;
	String descripcion;
	ArrayList preguntas;
	Tema tema;
	
	public Subtema(int codsubtema, String descripcion){
		preguntas = new ArrayList<Object>();//tener de las 3
		setCodSubTema(codsubtema);
		setDescripcion(descripcion);
	}
	public void anadirTema(int codTema, String descripcionTema){
		 tema = new Tema(codTema,  descripcionTema);		
	}
	
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
