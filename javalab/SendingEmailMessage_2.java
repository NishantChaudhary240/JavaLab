//right click on project then click on properties
//then select libraries
//on compile add classpath
                   //downclass path from link below
                   //https://repo1.maven.org/maven2/com/sun/mail/jakarta.mail/2.0.1/jakarta.mail-2.0.1.jar
                   //https://repo1.maven.org/maven2/com/sun/activation/jakarta.activation/2.0.1/jakarta.activation-2.0.1.jar
//then ok 

package javalab;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SendingEmailMessage_2 {
    public static void main(String[] args) {

        String from = "kailash.pantha123@gmail.com";
        String to = "panthakailash0806@gmail.com";
        String password = "oyms sqfi gysz crsr";
        //setep to get password : go to https://myaccount.google.com/apppasswords
//enter app name and you will get the google application password and change to and from too

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        try {
            Session session = Session.getInstance(props,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("Java Mail Test from Kailash");
            message.setText("Hello, this email was sent using Java program from NetBeans.");

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
