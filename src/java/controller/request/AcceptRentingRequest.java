/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.request;

import dao.IContractDAO;
import dao.IRequestDAO;
import dao.impl.ContractDAOImpl;
import dao.impl.RequestDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.User;

/**
 * This is a Servlet responsible for handling accept renting request and make
 * new contract function /requests/accept is the URL Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class AcceptRentingRequest extends HttpServlet {

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
        String requestIdRaw = request.getParameter("requestid");
        IRequestDAO requestDAO = new RequestDAOImpl();
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            if (requestRenting.getRequestStatus().getId() == 1) {
                requestDAO.updateStatusByRID(requestId, 3);
                Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
                IContractDAO contractDAO = new ContractDAOImpl();
                contractDAO.insertContract(requestRenting.getProperty().getId(), requestRenting.getRenter().getId(), currentDate);
                requestDAO.updateStatusByRID(requestId, 3);
                List<Request> listRequest = requestDAO.getRequestHasStatusEqual1();
                request.setAttribute("requestlist", listRequest);
                request.setAttribute("page", "Requests");
                request.setAttribute("message", "You made new contract");
                //request.getRequestDispatcher("/views/dashboard/request/requests.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath()+"/dashboard/requests");
            } else {
                request.setAttribute("message", "You can't make new contract");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(AcceptRentingRequest.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
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
        /*String requestIdRaw = request.getParameter("requestid");
        IRequestDAO requestDAO = new RequestDAOImpl();
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            IContractDAO contractDAO = new ContractDAOImpl();
            contractDAO.insertContract(requestRenting.getProperty().getId(), requestRenting.getRenter().getId(), currentDate);
            request.setAttribute("message", "You made new contract");
            request.getRequestDispatcher("../views/dashboard/request/requests.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AcceptRentingRequest.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }*/
    }

}
