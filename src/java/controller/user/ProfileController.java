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
        String uid = request.getParameter("uid");
        int id;

        //if user is not login
        if (u == null) {
            request.getRequestDispatcher("login").forward(request, response);
        }

        //check if uid is null
        if (uid == null || uid.equals("")) {
            id = (int) u.getId();
        } else {
            id = Integer.parseInt(uid);
            try {
                User user = userDAO.getUserById(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("views/user/profile.jsp").forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("message", ex);
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }
}
