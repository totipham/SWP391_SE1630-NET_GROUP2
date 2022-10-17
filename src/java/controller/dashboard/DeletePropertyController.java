/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 13, 2022         1.0           ThuongTTHE163555     First Implement
 */
package controller.dashboard;

import controller.auth.LoginController;
import dal.IPropertyDAO;
import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 * The class contains method find update, delete, insert staff information from
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author ThuongTTHE163555
 */
public class DeletePropertyController extends HttpServlet {

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

        //check if user is null
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        //get id from front end
        String pid = request.getParameter("pid");
        // delete property  
        try {
            //check if user role equal to 2 or to 3
            if (user.getRole() == 2 || user.getRole() == 3) {
                int id = Integer.parseInt(pid);
                IPropertyDAO propertyDAO = new PropertyDAOImpl();
                propertyDAO.deletePropertyByID(id);
                //re-load
                response.sendRedirect(request.getContextPath() + "/dashboard/properties");
            } else {
                throw new Exception("Don't have permission to access this page!");
            }
        } catch (Exception e) {
            request.setAttribute("message", e);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }

    }

}
