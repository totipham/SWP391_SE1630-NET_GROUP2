/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 14, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.property;

import dal.IPropertyTypeDAO;
import dal.impl.PropertyTypeDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 * The class contains method insert new property type to DB
 *  The method will
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class AddCategoryController extends HttpServlet {

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
        String newCategory = request.getParameter("Category");
        try {
            //check role of current user is admin or not
            if (user.getRole() == 3) {
                IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
                propertyTypeDAO.insertPropertyType(newCategory);
                request.setAttribute("message", "Add new category successful");
                request.getRequestDispatcher("*").forward(request, response);
            } else {
                request.setAttribute("message", "You don't have permission to access this function");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "You don't have permission to access this function");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

}
