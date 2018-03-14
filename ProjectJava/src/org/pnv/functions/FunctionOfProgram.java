package org.pnv.functions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JFileChooser;
import javax.swing.JTable;
import org.pnv.project.ThemeUserHistory;

public class FunctionOfProgram {

    private static Connection connect;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultset;
    private static String email_jdbc = null;
    private static String password_jdbc = null;

    public static StringBuffer capsText(String text) {

        StringBuffer stringbf = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)",
                Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) {
            m.appendReplacement(stringbf,
                    m.group(1).toUpperCase() + m.group(2).toLowerCase());
        }
        return stringbf;

    }

    public static String PrintFilePDF(JTable table, String title) {
        String path = null;
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            System.out.println(path);
            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
                doc.open();
                Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
                Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.ITALIC);
                Paragraph paragraph1 = new Paragraph(title, catFont);
                paragraph1.setIndentationLeft(80);
                Paragraph paragraph2 = new Paragraph("Print by Administrator", Font2);
                paragraph2.setIndentationLeft(340);
                doc.add(paragraph1);
                doc.add(new Paragraph("\n"));
                doc.add(paragraph2);
                doc.add(new Paragraph("\n"));
                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                for (int i = 0; i < table.getColumnCount(); i++) {
                    pdfTable.addCell(table.getColumnName(i));
                }
                for (int rows = 0; rows < table.getRowCount(); rows++) {
                    for (int cols = 0; cols < table.getColumnCount(); cols++) {
                        pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
                    }
                }
                doc.add(pdfTable);
                doc.close();

            } catch (DocumentException ex) {
                Logger.getLogger(ThemeUserHistory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThemeUserHistory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return path;
    }

    public static String insertHistory(String id, String text) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_project?user=root&password=");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            preparedStatement = (PreparedStatement) connect.prepareStatement("INSERT INTO History ( user_ID, time_of_use, history ) VALUES ( ? , ?, ?)");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, dtf.format(now));
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
        return null;

    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectMail() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT email_program, password_program FROM settingapp ");
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            email_jdbc = resultset.getString(1);
            password_jdbc = resultset.getString(2);
        }
    }

    public static String sendEmailWithAttachment(String email, String name, String path) throws SQLException {
        selectMail();
        if (resultset.next()) {
            email_jdbc = resultset.getString(1);
            password_jdbc = resultset.getString(2);
        }
        String EMAIL = email_jdbc;
        String PASSWORD = password_jdbc;
        String HOST = "mail.smtp.host";
        String COM = "smtp.gmail.com";
        String SOCKETPORT = "mail.smtp.socketFactory.port";
        String SOCKETCLASS = "mail.smtp.socketFactory.class";
        String SOCKETJAVAX = "javax.net.ssl.SSLSocketFactory";
        String AUTH = "mail.smtp.auth";
        String PORT = "mail.smtp.port";
        String TO = email;
        Properties props = new Properties();
        props.put(HOST, COM);
        props.put(SOCKETPORT, "465");
        props.put(SOCKETCLASS, SOCKETJAVAX);
        props.put(AUTH, "true");
        props.put(PORT, "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("EMAIL"));
            // to email
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            //message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse("anh.hiep.507@gmail.com,portgas.roo@gmail.com"));
            // subject email
            message.setSubject("Send Email With Attachment");
            // Content email
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello "+ name 
                    + ",\n\nThis is file print from system."
                    + "\nThanks."
                    + "\nAdministrator");
            // With attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = path;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

}
