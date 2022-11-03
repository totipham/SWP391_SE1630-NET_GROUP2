/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 21, 2022         1.0           LanBTHHE160676     First Implement
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
import model.Request;
import model.User;

/**
 * This is a Servlet responsible for handling delete renting request function for renter 
 * /deleterentingrequest is the URL
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class DeleteRentingRequest extends HttpServlet {

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
        //processRequest(request, response);
        //int requestID = Integer.parseInt(request.getParameter("rid"));
        int propertyId = Integer.parseInt(request.getParameter("pid"));
        IRequestDAO requestDAO = new RequestDAOImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        try {
            int userID = user.getId();
            //Request Request = requestDAO.getRequestByRID(requestID);
            //check current user id is the renter'd id of request and check request status is accept/finish or not
            
                requestDAO.deleteRequestByPropertyIdAndUserId(propertyId, userID);
                //request.setAttribute("message", "Delete successful");
                response.sendRedirect(request.getContextPath()+"/property?id="+propertyId);
//            else {
//                request.setAttribute("error", "You don't have permission to delete this request");
//                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
//            }

        } catch (Exception ex) {
            Logger.getLogger(DeleteRentingRequest.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
    }

}
