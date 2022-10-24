/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 18, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.auth;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 * The Servlet responsible for handling verify function /verify is the URL The
 * method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class VerifyAccountController extends HttpServlet {

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

        //check if user is logged in
        if (user != null) {

            //check if user is not verify
            if (!user.isVerify()) {
                request.setAttribute("user", user); //set attribute user
                request.getRequestDispatcher("views/auth/verifyaccount.jsp").forward(request, response); //forward to page verify account
            } else {
                response.sendRedirect(request.getContextPath() + "/profile");
            }

        } else {
            String redirect = request.getServletPath();

            //check if query string of request is not null
            if (request.getQueryString() != null) {
                redirect += "?" + request.getQueryString(); //add query string to redirect
            }

            response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString())); //send direct page to login page
            return;
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try ( PrintWriter out = response.getWriter()) {
            String token = request.getParameter("token"); //get catpcha from request
            HttpSession session = request.getSession(false); //call session from request
            User user = (User) session.getAttribute("user"); //call user from session
            IUserDAO userDAO = new UserDAOImpl();

            //check if user is null
            if (user == null) {
                String redirect = request.getServletPath() + "?" + request.getQueryString();
                response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString())); //send direct page to login page
                return;
            }

            boolean checkToken = token.equals(user.getToken()); //create boolean to check equals with input captcha and captcha in session

            //check if check token is true
            if (checkToken) {
                user.setVerify(true); //set this user is verify
                userDAO.updateVerifyByID(user.getId(), true);
                session.setAttribute("user", user);
                out.print("success");
            } else {
                out.print("Invalid token");
            }

        } catch (Exception ex) {
            Logger.getLogger(VerifyAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
