package logicaDeNegocios;

public abstract class Pregunta {
	protected int codigoPregunta;
	protected int codSubtema;
	protected int codTipoPregunta;
	public int getCodTipoPregunta() {
		return codTipoPregunta;
	}

	public void setCodTipoPregunta(int codTipoPregunta) {
		this.codTipoPregunta = codTipoPregunta;
	}
	protected String descripcionPregunta;
	protected String descripcionAyuda;
	
	
	public abstract void RegistrarTipoPregunta(String pTipoEvaluacion, String pDescripcion);
	
	public void VerificarTipoPregunta(String pTipoPregunta, String pDescripcion)
	{
		String tipoPregunta;
		
		tipoPregunta= pTipoPregunta.toLowerCase(); 
		
		if (tipoPregunta.equals("marque con x "))
		{
			Pregunta marqueX= new MarqueX(); 
			marqueX.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("espacio en Blanco"))
		{
			Pregunta espacioBlanco= new EspacioBlanco();
			espacioBlanco.RegistrarTipoPregunta(tipoPregunta, pDescripcion);
		}
		if (tipoPregunta.equals("desarrollo"))
		{
			Pregunta desarrollo= new Desarrollo();
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
	
	public int getCodSubtema() 
	{
		return codSubtema;
	}
	public void setCodSubtema(int codSubtema) 
	{
		this.codSubtema = codSubtema;
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
