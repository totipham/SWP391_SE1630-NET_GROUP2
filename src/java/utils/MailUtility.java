/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 19, 2022       1.0           DucPTMHE160517     First Implement
 */
package utils;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User;

/**
 * The class contains method generate random token and send mail, support for
 * send token verify to user if sign up or reset password The method will throw
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class MailUtility {

    /**
     * Generate a CAPTCHA String consisting of random lowercase & uppercase
     * letters, and numbers.
     *
     * @return
     */
    public String generateTokenString() {
        int length = 6;
        SecureRandom rand = new SecureRandom();
        String captchaStringBuilder = "";
        for (int i = 0; i < length; i++) {
            int baseCharNumber = abs(rand.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuilder+=((char) charNumber);
        }

        return captchaStringBuilder;
    }

    /**
     * Fail-fast wrapper for {@link Math#abs(int)}
     *
     * @param x
     * @return the absolute value of x
     * @throws ArithmeticException when a negative value would have been
     * returned by {@link Math#abs(int)}
     */
    public static int abs(int x) throws ArithmeticException {
        if (x == Integer.MIN_VALUE) {
            // fail instead of returning Integer.MAX_VALUE
            // to prevent the occurrence of incorrect results in later computations
            throw new ArithmeticException("Math.abs(Integer.MIN_VALUE)");
        }
        return Math.abs(x);
    }

    //send email to the user email
    public boolean sendEmail(User user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "hostalpy@gmail.com";
        String password = "skxjvulvkxjtndhl";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "25");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.ssl.checkserveridentity", true);
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            mess.setSubject("Account Verification");
            String messBody = "<!DOCTYPE html><body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin:0;background-color:#f2f3f8\" leftmargin=\"0\"><table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\" style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700);font-family:'Open Sans',sans-serif\"><tr><td><table style=\"background-color:#f2f3f8;max-width:670px;margin:0 auto\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"height:80px\">&nbsp;</td></tr><tr><td style=\"text-align:center\"><img height=\"100\" src=\"https://user-images.githubusercontent.com/19572025/196596493-06ac35dc-f0b4-4d72-8d51-5655ad56edef.png\" title=\"logo\" alt=\"logo\"></td></tr><tr><td style=\"height:20px\">&nbsp;</td></tr><tr><td><table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff;border-radius:20px;text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06)\"><tr><td style=\"height:40px\">&nbsp;</td></tr><tr><td style=\"padding:0 35px\"><h1 style=\"color:#1e1e2d;font-weight:500;margin:0;font-size:32px;font-family:Rubik,sans-serif\">Account Verification System</h1><p style=\"font-size:15px;color:#455056;margin:8px 0 0;line-height:24px\">Your account has been requested to verify. Below are your system generated token,<br><strong>Please use this token to verify your account.</strong></p><span style=\"display:inline-block;vertical-align:middle;margin:29px 0 26px;border-bottom:1px solid #cecece;width:100px\"></span><p style=\"color:#455056;font-size:18px;line-height:20px;margin:0;font-weight:500\"><strong style=\"display:block;font-size:13px;margin:0 0 4px;color:rgba(0,0,0,.64);font-weight:400\">Username</strong>" + user.getUsername() + "<strong style=\"display:block;font-size:13px;margin:24px 0 4px 0;font-weight:400;color:rgba(0,0,0,.64)\">Token</strong>" + user.getToken() + "</p></td></tr><tr><td style=\"height:40px\">&nbsp;</td></tr></table></td></tr><tr><td style=\"height:20px\">&nbsp;</td></tr><tr><td style=\"text-align:center\"><p style=\"font-size:14px;color:rgba(69,80,86,.7411764705882353);line-height:18px;margin:0 0 0\">&copy;<strong>Hostalpy</strong></p></td></tr><tr><td style=\"height:80px\">&nbsp;</td></tr></table></td></tr></table></body>";
            //set message text
            mess.setContent(messBody, "text/html; charset=UTF-8");
            //send the message
            Transport.send(mess);

            test = true;

        } catch (MessagingException ex) {
            Logger.getLogger(MailUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return test;
    }
}
