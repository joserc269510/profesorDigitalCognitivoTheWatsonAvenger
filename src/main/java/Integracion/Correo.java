package Integracion;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Correo {
	 public static String Username = "thewatsonavengers@gmail.com";
	    public static String PassWord = "proyecto1";
	    String Mensage = "Usted tiene una evaluación pendiente en la aplicación del profesor digital cognitivo";
	    String To = "suramirez92@gmail.com";
	    String Subject = "Notificación de Evaluación";

	    public String SendMail() {
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(Username, PassWord);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(Username));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(To));
	            message.setSubject(Subject);
	            message.setText(Mensage);

	            Transport.send(message);
	            return  "Su mensaje ha sido enviado";

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Correo nuevo= new Correo();
	    System.out.println(nuevo.SendMail());

	}

}
