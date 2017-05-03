/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.mail;

import javax.mail.MessagingException;

/**
 *
 * @author Alex
 */
public class TestMain {
    public static void main(String []args) throws MessagingException{
        MailService.sendExternalMail("kornelius.lackner@htlpinkafeld.at", "Kinder for free","Free Candy");
    }
}
