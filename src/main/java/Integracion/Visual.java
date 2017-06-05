package Integracion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class Visual {
	
	
	public void EntrenarProfesorCognitivo(String pRutaArchivoP, String pRutaArhivoN, String pClasificador,String pClase)
	{
		File imagesP= new File(pRutaArchivoP);
		File imagesN= new File(pRutaArhivoN);
		ClassifierOptions options = new ClassifierOptions.Builder().classifierName(pClasificador.toString()).addClass(pClase.toString(), imagesP).negativeExamples(imagesN).build();
		VisualRecognition visual= new VisualRecognition("2016-05-20", "afa9d235d5cdca90e7a8fb2c9046cdc84c986d5c");
		VisualClassifier serviceResponse = visual.createClassifier(options).execute();
		System.out.println(serviceResponse);
	}
	
	public Double CompararImagen(String rutaI) throws IOException
	{
		 File images = new File(rutaI);
         
         VisualRecognition visual= new VisualRecognition("2016-05-20", "afa9d235d5cdca90e7a8fb2c9046cdc84c986d5c");
		   byte[] fileBytes = Files.readAllBytes(Paths.get(images.getPath()));
		   
		   
		    ClassifyImagesOptions options =
		           new ClassifyImagesOptions.Builder().images(fileBytes ,obtenerNombreImagen(rutaI)).classifierIds("Persona_1688977458").build();
		    VisualClassification  result = visual.classify(options).execute();
		        
	   System.out.println(result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getScore());
	    
		return  result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getScore();
		     
	}
	
	public String obtenerNombreImagen(String imagen)
	{
		String path = imagen ;
	     String file = path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf(""));
	    String nombreImagen= file;
	    
	    return nombreImagen;
	}
	
	public static void main(String[] args) throws IOException 
	{
		
		Visual service= new Visual();
		service.CompararImagen("C:/Users/Cora/Documents/GitHub/profesorDigitalCognitivoTheWatsonAvenger/HI.jpg");
		
	}

}
	
