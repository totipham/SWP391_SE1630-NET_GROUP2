/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 13, 2022         1.0           AnhVHHE160580     First Implement
 */
package controller.dashboard;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author AnhVHHE160580
 */
public class RemoveUserController extends HttpServlet {

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
        String uid_raw = request.getParameter("uid");

        //if user is not login
        if (user == null) {
            String redirect = request.getServletPath() + "?" + request.getQueryString();
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + URLEncoder.encode(redirect, StandardCharsets.UTF_8.toString()));
            return;
        }

        //get uid to remove
        if (uid_raw == null && uid_raw.equals("")) {
            response.sendRedirect("dashboard");
            return;
        }
        try {

            //check if user role is equal to 1
            if (user.getRole() == 1) {
                int id = Integer.parseInt(uid_raw);

                //check if user want to remove themselves
                if (id == user.getId()) {
                    request.getRequestDispatcher("../views/error.jsp").forward(request, response);
                    return;
                } else {
                    IUserDAO userDAO = new UserDAOImpl();
                    userDAO.removeUserByID(id);
                    response.sendRedirect("../dashboard");
                }
            } else {
                request.setAttribute("message", "You don't have right to access this page!");
                request.getRequestDispatcher("../views/error.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(RemoveUserController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }

    }
}
