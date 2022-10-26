/*        
* Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 7, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.request;

import dao.IRequestDAO;
import dao.impl.RequestDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Property;
import model.Request;
import model.User;

/**
 *This is a Servlet responsible for handling decline renting request function 
 * /requests/decline is the URL
 * Bugs: Haven't found yet
 *
 * @author LANBTHHE160676
 */
public class DeclineRentingRequestController extends HttpServlet {

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
        int requestID = Integer.parseInt(request.getParameter("rid"));
        IRequestDAO requestDAO = new RequestDAOImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            int userID = user.getId();
            Request Request = requestDAO.getRequestByRID(requestID);
            Property property = Request.getProperty();
            User host = property.getHost();
            int hostID = host.getId();
            //check current user id is propery's host id or not
            if (hostID == userID) {
                requestDAO.updateStatusByRID(requestID, 4);
                request.setAttribute("message", "Decline successful");
                request.getRequestDispatcher("../views/dashboard/request").forward(request, response);
            } else {
                request.setAttribute("error", "You don't hove permission to update");
                request.getRequestDispatcher("../views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(DeclineRentingRequestController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", ex);
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
