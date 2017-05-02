package Integracion;

import java.io.File;
import java.io.IOException;


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
	
	
	public static void main(String[] args) throws IOException 
	{
		 // File imagesP = new File("C:/Users/Cora/git/watson1001/Estudiante.zip");
		//  File imagesP1 = new File("C:/Users/Cora/git/watson1001/Profesor.zip");
//		  File imagesN = new File("C:/Users/Cora/git/watson1001/NoEstudiante.zip");
		  
		  
//		    String class1 = "Students";
	//   ClassifierOptions options = new ClassifierOptions.Builder().classifierName("Person").addClass(class1, imagesP).negativeExamples(imagesN).build();
		   
//		    VisualRecognition visual= new VisualRecognition("2016-05-20", "ca498849bd159d3ed4de8b99e3fd8b99f7044db1");
		    
		//    VisualClassifier serviceResponse = visual.createClassifier(options).execute();
		    
		  //  System.out.println(serviceResponse);
		    
//		    ClassifierOptions options = new ClassifierOptions.Builder().classifierName("Persona").addClass(class1, images).build();
		    
		   // System.out.println(visual.updateClassifier("Persona_483279288",options).execute());
//    visual.deleteClassifier("Person_1082658321").execute();
	//	    System.out.println(visual.createClassifier(options).execute());
		    
//       System.out.println( visual.getClassifiers().execute());
//		   //********************************************************************************************************//
        
/*    File images = new File("C:/Users/Cora/git/watson1001/hola.jpg");
		   byte[] fileBytes = Files.readAllBytes(Paths.get(images.getPath()));
		   
		   
		    ClassifyImagesOptions options =
		           new ClassifyImagesOptions.Builder().images(fileBytes ,"hola.jpg").classifierIds("Person_701146578").build();
		    VisualClassification  result = visual.classify(options).execute();
		        
		         System.out.println(result);
		       

		 

		    // first request
	}*/

}
	}
