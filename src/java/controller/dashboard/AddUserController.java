/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 13, 2022         1.0           AnhVHHE160580     First Implement
 */
package controller.dashboard;

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
 * The class contains method add user account from admin dashboard to
 * User table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author AnhVHHE160580
 */
public class AddUserController extends HttpServlet {

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
        User user = (User) session.getAttribute("user");
        //if user is not login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //check if user role is equal to 1
        if (user.getRole() == 1) {
            request.getRequestDispatcher("/views/dashboard/add.jsp").forward(request, response);

        } else {
            request.setAttribute("message", "You don't have right to access this page!");
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
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
        //get and check user information 
        try {
            IUserDAO userDAO = new UserDAOImpl();

            String name = validate.getField(request, "name", true, 3, 20);
            String phone = validate.getFieldByType(request, "phone", "phone", true, 9, 11);
            String email = validate.getFieldByType(request, "email", "email", true, 11, 200);
            String address = validate.getField(request, "address", true, 10, 30);
            String username = validate.getField(request, "username", true, 3, 20);
            String password = validate.getField(request, "password", true, 3, 20);

            //check if user with username is existed
            if (userDAO.getUserByUsername(username) != null) {
                throw new Exception("Username " + username + " is existed!");
            }
            
            //check if user with email is existed
            if (userDAO.getUserByEmail(email) != null) {
                throw new Exception("Email " + email + " is existed!");
            }

            String message = userDAO.insertUser(name, phone, email, address, username, password);
            request.setAttribute("success", message);
            request.getRequestDispatcher("*").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
