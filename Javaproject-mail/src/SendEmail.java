
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
  
public class SendEmail  
{ 
  
   public static void main(String [] args)  
   {     
      // email ID of Recipient. 
      String recipient = "test@msn.com"; 
  
      // email ID of  Sender. 
      String sender = "test123@gmail.com"; 
  
      // using host as localhost 
      String host = "127.0.0.1"; 
  
      // Getting system properties 
      Properties props = System.getProperties(); 
  
      
     
   // Setting up mail server 
      props.setProperty("mail.smtp.host", "smtp.gmail.com"); 
      props.setProperty("mail.transport.protocol", "smtp");     
      props.setProperty("mail.host", "smtp.gmail.com");  
      props.put("mail.smtp.auth", "true");  
      props.put("mail.smtp.port", "465");  
      props.put("mail.debug", "true");  
      props.put("mail.smtp.socketFactory.port", "465");  
      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
      props.put("mail.smtp.socketFactory.fallback", "false"); 
     // mail.setTLS(true);
      
  
      Session session = Session.getDefaultInstance(props,  
    		    new javax.mail.Authenticator() {
    		       protected PasswordAuthentication getPasswordAuthentication() {  
    		       return new PasswordAuthentication(sender,"pwd");  
    		   }  
    		   });
    		   

      
      
      
      
          
      try 
            { 
               // MimeMessage object. 
               MimeMessage message = new MimeMessage(session); 
        
               // Set From Field: adding senders email to from field. 
               message.setFrom(new InternetAddress(sender)); 
        
               // Set To Field: adding recipient's email to from field. 
               message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
        
               // Set Subject: subject of the email 
               message.setSubject("This is Suject"); 
        
               // set body of the email. 
               message.setText("This is a test mail"); 
        
               // Send email. 
               Transport.send(message); 
               System.out.println("Mail successfully sent"); 
            } 
            catch (MessagingException mex)  
            { 
               mex.printStackTrace(); 
            } 
         } 
      }

