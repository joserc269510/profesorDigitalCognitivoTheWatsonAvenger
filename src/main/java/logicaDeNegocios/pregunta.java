package logicaDeNegocios;

public abstract class pregunta 
{
	private int codigoPregunta;
	private int codSubtema;
	private String descripcionPregunta;
	private String descripcionAyuda;
	
	
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
