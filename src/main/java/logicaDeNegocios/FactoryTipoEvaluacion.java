package logicaDeNegocios;

public class FactoryTipoEvaluacion implements MetodoFactoryEvaluacion {
	
	
	public Evaluacion crearEvaluacion(String pTipoEvaluacion, String pDescripcion)
	{
		Evaluacion evaluacion =null;
		
		
		if (pTipoEvaluacion.equals("sumativa")){
			evaluacion= new Sumativa(pTipoEvaluacion, pDescripcion); 
		}
		if (pTipoEvaluacion.equals("formativa")){
			evaluacion= new Formativa(pTipoEvaluacion, pDescripcion);
		}
		return evaluacion;
	}
}
