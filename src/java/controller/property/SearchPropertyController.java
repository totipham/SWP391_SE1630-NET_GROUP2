/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 10, 2022         1.0           NgocCMHE161386     First Implement
 */

package controller.property;

import dal.IPropertyDAO;
import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Property;

/**				
 * The class contains method find update, delete, insert staff information from				
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
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
        try {
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
        } catch (Exception ex) {
            request.setAttribute("message", ex);
            request.getRequestDispatcher("views/user/error.jsp").forward(request, response);
        }
    }

}
