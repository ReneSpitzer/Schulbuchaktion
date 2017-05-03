/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.mail;

/**
 *
 * @author Alex
 */

import javax.mail.MessagingException;

public final class MailService extends Mail {
    public static final String Mail_Schule = "SRP <schulbuchaktionHTLPinkafeld@gmx.at>";
    
    private static final String SMTP_SERVER = "mail.gmx.net";
    private static final int SMTP_PORT = 587;
    private static final String SMTP_USER = "schulbuchaktionHTLPinkafeld@gmx.at";
    private static final String SMTP_PASSWORD = "htlpinkafeld1";
    
    private MailService() {
        super(SMTP_SERVER, SMTP_PORT, true, SMTP_USER, SMTP_PASSWORD);
    }
    
    private static final MailService INSTANCE = new MailService();
    
    public static void sendExternalMail(String to, String subject, String message) throws MessagingException {
        INSTANCE.sendMail(Mail_Schule, to, Mail_Schule , subject, message);
    }
}
