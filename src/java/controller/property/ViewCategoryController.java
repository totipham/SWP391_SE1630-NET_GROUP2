/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Nov 3, 2022         1.0           LanBTHHE160676     First Implement
 */

package controller.property;

import dao.IPropertyTypeDAO;
import dao.impl.PropertyTypeDAOImpl;
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
import model.PropertyType;
import model.User;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */

public class ViewCategoryController extends HttpServlet {
   
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
        //processRequest(request, response);
        try {
            //check if user has logged in
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            //check if user is null
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
            //get list of property caegory from database
            List<PropertyType> list = new ArrayList<>();
            IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
            list = propertyTypeDAO.getAllPropertyType();

            //send list of users to front end
            request.setAttribute("categorylist", list);
            request.setAttribute("page", "Category");
            request.getRequestDispatcher("../views/dashboard/property/propertycategories.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(ViewCategoryController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e);
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
        //processRequest(request, response);
    }

}