package logicaDeNegocios;


public abstract class pregunta {

	protected int codigoPregunta;
	protected String descripcionPregunta;
	protected String descripcionAyuda;
	private Subtema subtema; //bidireccional
	
	
	public pregunta (int codigoPregunta, String descripcionPregunta, String descripcionAyduda){
		setCodigoPregunta(codigoPregunta);
		setDescripcionPregunta(descripcionPregunta);
		setDescripcionAyuda(descripcionAyduda);
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
		
		if (tipoPregunta.equals("marque con x "))
		{
			pregunta marqueX= new MarqueX(); 
			marqueX.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("espacio en Blanco"))
		{
			pregunta espacioBlanco= new EspacioBlanco();
			espacioBlanco.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("desarrollo"))
		{
			pregunta desarrollo= new Desarrollo();
			desarrollo.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		 
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
