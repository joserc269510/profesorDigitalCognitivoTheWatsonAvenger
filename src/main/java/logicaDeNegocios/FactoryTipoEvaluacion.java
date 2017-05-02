package logicaDeNegocios;

public class FactoryTipoEvaluacion implements MetodoFactoryEvaluacion {
	
	
	public Evaluacion crearEvaluacion(String pTipoEvaluacion, String pDescripcion){
		Evaluacion evaluacion =null;
		if (evaluacion.equals("sumativa")){
			Evaluacion tipoEvaluacionS= new Sumativa(); 
		}
		if (evaluacion.equals("formativa")){
			Evaluacion tipoEvaluacionF= new Formativa();
		}
		return evaluacion;
	}
}
