/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 18, 2022         1.0           ThuongTTHE163555     First Implement
 */
package controller.user;

import controller.auth.LoginController;
import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 * The class contains method doGet to get list of users from database then send
 * to screen and display this to admin
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author ThuongTTHE163555
 */
public class ViewSystemUserController extends HttpServlet {

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
        try {
            //check if user has logged in
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            //check if user is null
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
            //get list of users from database
            List<User> list = new ArrayList<>();
            IUserDAO userDAO = new UserDAOImpl();
            list = userDAO.getAllUserSystem();

            //send list of users to front end
            request.setAttribute("userList", list);
            request.getRequestDispatcher("../views/dashboard/user/users.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(ViewSystemUserController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e);
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

    }

}
