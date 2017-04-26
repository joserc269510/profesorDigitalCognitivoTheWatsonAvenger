package Integracion;


	import java.util.Arrays;

	import com.google.api.services.translate.Translate;
	import com.google.api.services.translate.model.TranslationsListResponse;
	import com.google.api.services.translate.model.TranslationsResource;

	public class Traductor {
		
		String linea=null;
		
		public String Traduccion(String pTraducir){
			try {           
	            // See comments on 
	            //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
	            // on options to set
	            Translate t = new Translate.Builder(
	                    com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport()
	                    , com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)                                   
	                    //Need to update this to your App-Name
	                    .setApplicationName("Prueba")                    
	                    .build();           
	            Translate.Translations.List list = t.new Translations().list(
	                    Arrays.asList(pTraducir), 
	                        //Target language   
	                        "ES");  
	            //Set your API-Key from https://console.developers.google.com/
	            list.setKey("AIzaSyDon59wVZRBo86565MpD4cuMC0Hgt8WUPI");
	            TranslationsListResponse response = list.execute();
	            for(TranslationsResource tr : response.getTranslations()) {
	                linea=tr.getTranslatedText();
	                return linea;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return linea;
	    }


	   // public static void main(String[] args) { }
	}
