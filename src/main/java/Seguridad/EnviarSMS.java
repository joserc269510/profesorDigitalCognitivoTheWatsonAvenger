package Seguridad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
* 
* Clase para enviar SMS, por medio de un WebRequest, en la pagina sms506.com
*
*/
public class EnviarSMS {
    public EnviarSMS(String Numero, String Texto) throws MalformedURLException, IOException{
        URL yahoo = new URL("http://api.sms506.com/sms/3a4e304455894a83296ac69947dc04b9/t="+Numero+"&m="+Texto);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
