package controller.property;

import dal.IPropertyDAO;
import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Property;

/**
 *
 * @author Asus
 */
public class PropertiesController extends HttpServlet {

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
            List<Property> list = propertyDAO.getAllProperties();

            request.setAttribute("listProperty", list);
            request.getRequestDispatcher("views/property/properties.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", ex);
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }

}
