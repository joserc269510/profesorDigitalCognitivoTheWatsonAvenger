package logicaDeNegocios;

import Integracion.BaseDeDatos;

public abstract class pregunta implements IVerificable, IRegistrableTipoPregunta {

	protected int codigoPregunta;
	protected String descripcionPregunta;
	protected String descripcionAyuda;
	private Subtema subtema; //bidireccional
	BaseDeDatos conexion;
	FactoryTipoPregunta factory;
	
	public pregunta (int pCodigoPregunta, String pDescripcionPregunta, String pDescripcionAyuda){
		setCodigoPregunta(pCodigoPregunta);
		setDescripcionPregunta(pDescripcionPregunta);
		setDescripcionAyuda(pDescripcionAyuda);
		conexion = new BaseDeDatos();
	}
	public pregunta()
	{
		conexion = new BaseDeDatos();
	}
	
	public Subtema getSubtema() {
		return subtema;
	}

	public void anadirSubTema(int pCodSubtema, String pDescripcion){
		subtema = new Subtema( pCodSubtema, pDescripcion);
	}
	

	public abstract void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion);
	public abstract void registrarPregunta(String CodP,String sub, String descp, String descpAy);

	public void verificarTipoPregunta(String pTipoPregunta, String pDescripcion)
	{
		String tipoPregunta;
		
		tipoPregunta= pTipoPregunta.toLowerCase(); 
		tipoPregunta=tipoPregunta.replace(" ","");
		
		MetodoFactoryPregunta factory = new FactoryTipoPregunta();
		pregunta pregunta = factory.crearPregunta(tipoPregunta, pDescripcion);
	
		if (tipoPregunta.equals("marqueconx"))
		{	
			System.out.println("entro al x pregunta");
		    pregunta.registrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("espacioenblanco"))
		{
			System.out.println("entro al espacio");
			pregunta.registrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("desarrollo"))
		{
			System.out.println("entro al desarrollo");
			pregunta.registrarTipoPregunta(tipoPregunta, pDescripcion);
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
