/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * ProfileController
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: AnhVHHE160580          
 */
package controller.user;

import dal.IUserDAO;
import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.ValidateUtility;

/**
 * This is a Servlet responsible for handling show profile function /profile is
 * the URL of the web site Extend HttpServlet class
 *
 * @author AnhVHHE160580
 */
public class ProfileController extends HttpServlet {

    private ValidateUtility validate = new ValidateUtility();

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
        IUserDAO userDAO = new UserDAOImpl();
        User u = (User) session.getAttribute("user");

        //if user is not login
        if (u == null) {
            request.getRequestDispatcher("login").forward(request, response);
        }

        User user = userDAO.getUserById(u.getId());

        //if user in session
        if (user != null) {
            session.setAttribute("user", user);
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("views/user/profile.jsp").forward(request, response);
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

        try {
            IUserDAO userDAO = new UserDAOImpl();

            String name = validate.getField(request, "name", true, 3, 20);
            String phone = validate.getFieldByType(request, "phone", "phone", true, 9, 11);
            String email = validate.getFieldByType(request, "email", "email", true, 11, 200);
            String address = validate.getField(request, "address", true, 10, 30);

            userDAO.updateUser(user.getId(), name, phone, email, address);
            User newUser = userDAO.getUserById(user.getId());
            
            //Check if new user is not null
            if (newUser != null) {
                session.setAttribute("user", newUser);
            }
            user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            request.setAttribute("message", "Update successfully!");
            request.getRequestDispatcher("views/user/profile.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("user", user);
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("views/user/profile.jsp").forward(request, response);
        }

    }
}
