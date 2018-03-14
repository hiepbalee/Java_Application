/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pnv.functions;

import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendEmail {

    

    public boolean sendEmail(String EMAIL, String PASSWORD, String cusname, String gender, String birthday, String idcard, String address, String email, String numberphone, String area) {
//        EMAIL = "ariesspeedkun@gmail.com"; // hardCode
//        PASSWORD = "anhbahiepleqn2s";
        boolean isError = true;
        String HOST = "mail.smtp.host";
        String COM = "smtp.gmail.com";
        String SOCKETPORT = "mail.smtp.socketFactory.port";
        String SOCKETCLASS = "mail.smtp.socketFactory.class";
        String SOCKETJAVAX = "javax.net.ssl.SSLSocketFactory";
        String AUTH = "mail.smtp.auth";
        String PORT = "mail.smtp.port";

        String TO = email;// change accordingly

        // Get the session object
        Properties props = new Properties();
        props.put(HOST, COM);
        props.put(SOCKETPORT, "465");
        props.put(SOCKETCLASS, SOCKETJAVAX);
        props.put(AUTH, "true");
        props.put(PORT, "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);// change
                // accordingly
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("EMAIL"));// change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            message.setSubject("Notification for Customer ");
            message.setText("Hello " + cusname + ",\n\n"
                    + "Your information has been updated in the system as follows:\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "  - Customer Name: " + cusname + "\n"
                    + "  - Gender: " + gender + "\n"
                    + "  - Birthday: " + birthday + "\n"
                    + "  - ID Card: " + idcard + "\n"
                    + "  - Address: " + address + "\n"
                    + "  - Email: " + email + "\n"
                    + "  - Number Phone: " + numberphone + "\n"
                    + "  - Area: " + area + "\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "Please check your information, (if any) please contact the administrator to change your exact information. \n"
                    + "To log into the system, this is your default account and password:\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "  - Username: " + idcard + "\n"
                    + "  - Password: " + birthday + "\n"
                    + " ----------------------------------------------------------------------------------------------------------\n"
                    + "\n"
                    + "Thanks,\n"
                    + "Administrator of System.");
            Transport.send(message);
           
        } catch (MessagingException e) {
            System.out.println("k gui dc");
            isError = false;
        }
        return isError;

    }

}
