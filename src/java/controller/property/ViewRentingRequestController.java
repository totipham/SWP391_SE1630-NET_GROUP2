/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 18, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.property;

import dao.IRequestDAO;
import dao.impl.RequestDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.User;

/**
 * This is a Servlet responsible for handling view renting request function 
 * /requests is the URL
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class ViewRentingRequestController extends HttpServlet {

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
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        try {
            if (currentUser.getRole() != 2) {
                request.setAttribute("message", "You don't have permission to access thí function");
                request.getRequestDispatcher("../views/error.jsp").forward(request, response);
            }
            else{
                IRequestDAO requestDAO = new RequestDAOImpl();
                List<Request> listRequest = requestDAO.getRequestHasStatusEqual1();
                request.setAttribute("requestlist", listRequest);
                request.getRequestDispatcher("../views/dashboard/request/requests.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewRentingRequestController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
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
        //processRequest(request, response);
        
    }

}
