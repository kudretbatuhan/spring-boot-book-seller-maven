package com.sha.springbootbooksellermaven.configuraiton;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;


import java.time.LocalTime;

@Configuration
@EnableScheduling
@Service
public class AppConfiguration {
/*
    @Scheduled(fixedDelay = 3000)
    public void sendMessage(){
        System.out.println("Hey I am scheduled method");
    }
*/




    @Scheduled(cron = "0 0/1 * * * *")
    public void sendMessageCron(){

        System.out.println(LocalTime.now() +" Hey I am scheduled method");


        // Recipient's email ID needs to be mentioned.
        String to = "muhendisbey50@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "kudretbatuhan@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("kudretbatuhan@gmail.com", "nulpnwinpmmycech");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }






        System.out.println(LocalTime.now() +" Mail Sent Successfully");




    }
}
