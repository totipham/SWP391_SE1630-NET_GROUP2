package controller.property;

import dal.IPropertyDAO;
import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Property;
import model.User;

/**
 *
 * @author Asus
 */
public class PropertyController extends HttpServlet {

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
        int id = 0;
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        String id_raw = request.getParameter("id");

        //Check if id raw is null or id raw equals to empty string
        if (id_raw == null || id_raw.equals("")) {
            response.sendRedirect("properties");
            return;
        }

        try {
            id = Integer.parseInt(id_raw);

            Property property = propertyDAO.getPropertyById(id);
            
            //Check if property is not null
            if (property != null) {

                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");

                //Check if user is not null
                if (user != null) {
                    
                    //Check if property's host is equal to this loggin user
                    if (property.getHost().getId() == user.getId()) {
                        request.setAttribute("is_owner", true);
                    }
                }

                request.setAttribute("property", property);
                request.getRequestDispatcher("views/property/property.jsp").forward(request, response);
            } else {
                response.sendRedirect("properties");
            }
        } catch (Exception ex) {
            request.setAttribute("message", ex);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
    }

}
