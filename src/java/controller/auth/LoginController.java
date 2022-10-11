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
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Still have some issues related to search staff by address				
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
            //redirect to homepage
            response.sendRedirect(request.getContextPath());
        } else {
            //redirect to login page
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
            IUserDAO userDAO = new UserDAOImpl();

            String username = validate.getField(request, "username", true, 3, 20);
            String password = validate.getField(request, "password", true, 3, 20);

            User userFromDB = userDAO.getUser(username, password);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
            //Check if user is not null
            if (userFromDB != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userFromDB);
                response.sendRedirect(request.getContextPath());
            } else {
                throw new Exception("Username or password wrong!");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }

}
