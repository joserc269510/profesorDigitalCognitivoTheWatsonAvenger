package logicaDeNegocios;

public class FactoryTipoPregunta implements MetodoFactoryPregunta {
	
	public pregunta crearPregunta (String tipoPregunta, String pDescripcion){
		pregunta pregunta = null;
		
		if (tipoPregunta.equals("marqueconx")) {
			 pregunta = new MarqueX(tipoPregunta, pDescripcion);
			}
		else if(tipoPregunta.equals("espacioenblanco")){
			 pregunta = new EspacioBlanco(tipoPregunta, pDescripcion);
		}
		
		else if(tipoPregunta.equals("desarrollo")){
			 pregunta = new Desarrollo(tipoPregunta, pDescripcion);
		}
		return pregunta;
	}

}


