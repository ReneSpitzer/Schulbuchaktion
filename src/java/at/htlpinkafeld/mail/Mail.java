/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.mail;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Alex
 */


 
public class Mail
{
    
    private final String host, username, password;
    private final int port;
    private final boolean starttls, auth;
    
    protected Mail(String host, int port) {
        this(host, port, false);
    }
    
    protected Mail(String host, int port, boolean starttls) {
        this(host, port, starttls, null, null);
    }
    
    protected Mail(String host, int port, boolean starttls, String username, String password) {
        this.host = host;
        this.port = port;
        this.starttls = starttls;
        this.username = username;
        this.password = password;
        this.auth = true;
    }
    
    protected final void sendMail(String from, String to, String replyTo, String subject, String message) throws MessagingException {
        Properties p = new Properties();
        p.put("mail.smtp.host", host);
        p.put("mail.smtp.port", port);
        p.put("mail.smtp.starttls.enable", starttls);
        p.put("mail.smtp.auth", auth);
        
        Session session;
        
        if (auth) {
            Authenticator authenticator = new Authenticator() {
                private final PasswordAuthentication pa = new PasswordAuthentication(username, password);
                
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
            
            session = Session.getInstance(p, authenticator);
        } else {
            session = Session.getInstance(p);
        }
        
        MimeMessage mimemessage = new MimeMessage(session);
        
        mimemessage.setFrom(new InternetAddress(from));
        mimemessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimemessage.setReplyTo(new Address[] { new InternetAddress(replyTo) });
        mimemessage.setSubject(subject);
        mimemessage.setSentDate(new Date());
        mimemessage.setText(message);
        Transport.send(mimemessage);
    }
    
}
