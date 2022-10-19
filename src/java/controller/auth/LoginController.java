/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 4, 2022         1.0           DucPTMHE160517     First Implement
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.ValidateUtility;

/**
 * This is a Servlet responsible for handling login function /login is the URL
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class LoginController extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null; //check if user login or not
        String redirect = request.getParameter("redirect");

        //Check if user is logged in or not
        if (loggedIn) {
            response.sendRedirect(request.getContextPath()); //redirect to homepage
        } else {
            //check if redirect is not null and not equals empty string
            if (redirect != null && !redirect.equals("")) {
                request.setAttribute("redirect", redirect); //set attribute for redirect
            }
            
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response); //redirect to login page
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
        ValidateUtility validate = new ValidateUtility();
        IUserDAO userDAO = new UserDAOImpl();
        
        try {
            String username = validate.getField(request, "username", true, 3, 20);  //require to get field username has length between 3 and 20
            String password = validate.getField(request, "password", true, 3, 20); //require to get field password has length between 3 and 20

            String redirect = request.getParameter("redirect"); //get redirect page

            User userFromDB = userDAO.getUser(username, password); //get user by username and password

            //Check if user is not null
            if (userFromDB != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userFromDB); //set user for session

                //check if redirect is not empty and is not null
                if (!redirect.isEmpty() && redirect != null) {
                    response.sendRedirect(request.getContextPath() + redirect); //redirect page
                } else {
                    response.sendRedirect(request.getContextPath()); //redirect to home
                }

            } else {
                throw new Exception("Username or password wrong!"); //throw new exception for wrong username and password
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response); //forward to error page
        }
    }

}
