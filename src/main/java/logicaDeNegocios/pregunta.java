package logicaDeNegocios;

import Integracion.BaseDeDatos;

public abstract class pregunta {

	protected int codigoPregunta;
	protected String descripcionPregunta;
	protected String descripcionAyuda;
	private Subtema subtema; //bidireccional
	BaseDeDatos conexion;
	FactoryTipoPregunta factory;
	
	public pregunta (int codigoPregunta, String descripcionPregunta, String descripcionAyduda){
		setCodigoPregunta(codigoPregunta);
		setDescripcionPregunta(descripcionPregunta);
		setDescripcionAyuda(descripcionAyduda);
		conexion = new BaseDeDatos();
	}
	public pregunta()
	{
		conexion = new BaseDeDatos();
	}
	
	public Subtema getSubtema() {
		return subtema;
	}

	public void anadirSubTema(int codsubtema, String descripcion){
		subtema = new Subtema( codsubtema, descripcion);
	}
	
	public abstract void RegistrarTipoPregunta(String pTipoEvaluacion, String pDescripcion);
	
	public void VerificarTipoPregunta(String pTipoPregunta, String pDescripcion)
	{
		String tipoPregunta;
		
		tipoPregunta= pTipoPregunta.toLowerCase(); 
		tipoPregunta=tipoPregunta.replace(" ","");
		
		MetodoFactoryPregunta factory = new FactoryTipoPregunta();
		pregunta pregunta = factory.crearPregunta(tipoPregunta, pDescripcion);
	
		if (tipoPregunta.equals("marqueconx "))
		{	
		    pregunta.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("espacio en Blanco"))
		{
			
			pregunta.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("desarrollo"))
		{
			pregunta.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		 
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
	public int getCodigoPregunta() 
	{
		return codigoPregunta;
	}
	public void setCodigoPregunta(int codigoPregunta) 
	{
		this.codigoPregunta = codigoPregunta;
	}

	public String getDescripcionPregunta() 
	{
		return descripcionPregunta;
	}
	public void setDescripcionPregunta(String descripcionPregunta) {
		this.descripcionPregunta = descripcionPregunta;
	}
	public String getDescripcionAyuda() {
		return descripcionAyuda;
	}
	public void setDescripcionAyuda(String descripcionAyuda) {
		this.descripcionAyuda = descripcionAyuda;
	}


}
