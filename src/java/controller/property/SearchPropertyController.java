/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * SearchPropertyController
 * Record of change:
 *      DATE: Oct 6, 2022            
 *      VERSION: 1.0
 *      AUTHOR: NgocCMHE161386          
 */
package controller.property;

import dal.IPropertyDAO;
import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Property;

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author NgocCMHE161386
 */
public class SearchPropertyController extends HttpServlet {

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
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        String keyword = request.getParameter("keyword");
        List<Property> searchingProperty = propertyDAO.getPropertiesByKeyword(keyword);
        
        //Check searching property list is empty or not
        if (searchingProperty != null) {
            request.setAttribute("listProperty", searchingProperty);
            request.getRequestDispatcher("views/property/properties.jsp").forward(request, response);
        } else {
            response.sendRedirect("properties");
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
