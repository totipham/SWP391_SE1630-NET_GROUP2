/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 19, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.auth;

import dal.IUserDAO;
import dal.impl.UserDAOImpl;
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
import utils.HashUtility;
import utils.MailUtility;
import utils.ValidateUtility;

/**
 * The Servlet responsible for handling forget password function /forget is the
 * URL The method will throw an object of <code>java.lang.Exception</code> class
 * if there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class ForgetPasswordController extends HttpServlet {

    private void checkMail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        IUserDAO userDAO = new UserDAOImpl();

        ValidateUtility validate = new ValidateUtility();
        HashUtility hash = new HashUtility();

        try ( PrintWriter out = response.getWriter()) {
            String email = validate.getFieldByType(request, "email", "email", true, 5, 30); //get field email length between 5 and 30 characters
            User userFromDB = userDAO.getUserByEmail(email); //get user from DB by email

            //check if user with inputed email existed or not
            if (userFromDB != null) {
                MailUtility mailUtils = new MailUtility();
                String token = mailUtils.generateTokenString(); //generate token string from mailUtils
                userFromDB.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail("resetpassword", userFromDB); //send mail to user, if success then do next action

                //check if send mail status equals to true
                if (sendMailStatus) {
                    session.setMaxInactiveInterval(900); //set age for session
                    session.setAttribute("hashedToken", hash.hashString(token)); //set token for session
                    session.setAttribute("userId", userFromDB.getId()); //set token for session
                    out.print("success");
                } else {
                    out.print("Cannot send reset token. Try again!");
                }

            } else {
                out.print("No user exist with this email!");
            }

        } catch (Exception ex) {
            request.setAttribute("message", ex); //set exception for message
            request.getRequestDispatcher("views/error.jsp").forward(request, response); //forward to error page
        }
    }

    private void checkToken(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try ( PrintWriter out = response.getWriter()) {

            IUserDAO userDAO = new UserDAOImpl();
            HashUtility hash = new HashUtility();
            String hashedInputToken = hash.hashString(request.getParameter("token")); //get token from user input
            HttpSession session = request.getSession(); //call session in requét

            System.out.println("HASHED: " + session.getAttribute("hashedToken"));
            System.out.println("INPUT: " + request.getParameter("token"));
            System.out.println("HASHED INPUT: " + hash.hashString(request.getParameter("token")));

            User resetUser = userDAO.getUserById((int) session.getAttribute("userId"));
            if (resetUser == null) {
                out.print("Time out, please resend new token!");
                return;
            }

            boolean checkToken = hashedInputToken.equals((String) session.getAttribute("hashedToken")); //compare hashed token in session and hased token user input
            if (checkToken) {
                out.print("success");
            } else {
                out.print("Invalid captcha");
            }
        } catch (Exception ex) {
            Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try ( PrintWriter out = response.getWriter()) {
            IUserDAO userDAO = new UserDAOImpl();
            ValidateUtility validate = new ValidateUtility();
            String newPassword = validate.getField(request, "password", true, 3, 20); //get field password has length between 3 and 20
            String reNewPassword = validate.getField(request, "password", true, 3, 20); //get field password has length between 3 and 20
            HttpSession session = request.getSession();
            int resetUserId = (int) session.getAttribute("userId"); //call reset User from session

            if (newPassword.equals(reNewPassword)) {
                int checkUpdatePw = userDAO.updateNewPassword(resetUserId, newPassword); //call updateNewPassword method from AccountDAO
                if (checkUpdatePw == 1) {
                    out.print("success");
                    session.invalidate();
                } else {
                    out.print("Error while update new password. Please try again!");
                }
            } else {
                out.print("Two passwords field must same!");
            }

        } catch (Exception ex) {
            Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //check if user is not null
        if (user != null) {
            response.sendRedirect(request.getContextPath()); //redirect to home page 
        } else {
            request.getRequestDispatcher("views/auth/forget.jsp").forward(request, response); //redirect to XXXXXXXXXX
        }
    }

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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //check if user is not null
        if (user != null) {
            response.sendRedirect(request.getContextPath()); //redirect to home page 
        }

        String step = request.getParameter("step");

        switch (step.toLowerCase().trim()) {
            case "checkmail":
                checkMail(request, response);
                break;
            case "checktoken":
                checkToken(request, response);
                break;
            case "resetpassword":
                changePassword(request, response);
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
