/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * UpdateRequestStatusController
 * Record of change:
 *      DATE: Oct 7, 2022            
 *      VERSION: 1.0
 *      AUTHOR: LANBTHHE160676          
 */
package controller.property;

import dal.IRequestDAO;
import dal.IUserDAO;
import dal.impl.RequestDAOImpl;
import dal.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Property;
import model.Request;
import model.User;

/**
 * [FILE DESCRIPTION HERE]
 *
 * @author LANBTHHE160676
 */
public class UpdateRequestStatusController extends HttpServlet {

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
        int requestStatusID = Integer.parseInt(request.getParameter("rstatusID"));
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

                updateRequest(requestID, requestStatusID);

                request.setAttribute("message", "Update successful");
                request.getRequestDispatcher("*").forward(request, response);
            } else {
                request.setAttribute("error", "You don't hove permission to update");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
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

    private void updateRequest(int rid, int newStatus) throws Exception {
        IRequestDAO requestDAO = new RequestDAOImpl();
        requestDAO.updateStatusByRID(rid, newStatus);
    }
}
