/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 19, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.auth;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.MailUtility;

/**
 * The Servlet responsible for handling send token function /verify/sendtoken is
 * the URL The method will throw an object of <code>java.lang.Exception</code>
 * class if there is any error occurring when finding, inserting, or updating
 * data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class SendTokenController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        try (PrintWriter out = response.getWriter()) {
            
            //check if user is not null and is not verify
            if (user != null && !user.isVerify()) {
                MailUtility mailUtils = new MailUtility();
                String token = mailUtils.generateTokenString(); //generate token string from mailUtils
                user.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail("verify", user); //send verify mail to user
                
                //check if send mail status is true
                if (sendMailStatus) {
                    out.print("Sended token!");
                } else {
                    out.print("Error when sending! Please try again");
                }
            } else {
                out.print("This account has been verified yet!");
            }

        } catch (Exception ex) {
            Logger.getLogger(SendTokenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
