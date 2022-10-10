/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * DashboardPropertiesController
 * Record of change:
 *      DATE: Oct 10, 2022            
 *      VERSION: 1.0
 *      AUTHOR: DucPTMHE160517          
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

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author DucPTMHE160517
 */

public class DashboardPropertiesController extends HttpServlet {
   
    /** 
     * Handles the HTTP <code>GET</code> method.
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
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        
        
        //check if user role is equal to 1
        if (u.getRole() == 1) {
            
        } else if (u.getRole() == 2) { //check if role of user equal to 2
            request.setAttribute("user", u);
            request.setAttribute("page", "Properties");
            request.getRequestDispatcher("../views/dashboard/host/properties.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "You don't have right to access this page!");
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
