/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * LoginController
 * Record of change:
 *      DATE: Oct 4, 2022            
 *      VERSION: 1.0
 *      AUTHOR: DucPTMHE160517          
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
 * This is a Servlet responsible for handling login function /Login is the URL
 * of the web site Extend HttpServlet class
 *
 * @author DucPTMHE160517
 */
public class LoginController extends HttpServlet {

    private ValidateUtility validate = new ValidateUtility();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        //Check if user is logged in or not
        if (loggedIn) {
            response.sendRedirect(request.getContextPath());
        } else {
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
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
        try {
            String username = validate.getField(request, "username", true, 5, 15);
            String password = validate.getField(request, "password", true, 3, 20);
            IUserDAO userDAO = new UserDAOImpl(); 
            User user = userDAO.getUser(username, password);

            //Check if user is existed
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath());
            } else {
                request.setAttribute("message", "Username or password wrong!");
                request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }

}
