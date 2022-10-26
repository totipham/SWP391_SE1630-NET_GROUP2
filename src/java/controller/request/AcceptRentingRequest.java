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
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;

/**
 *This is a Servlet responsible for handling accept renting request and make new contract function 
 * /requests/accept is the URL
 * Bugs: Haven't found yet
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
        String requestIdRaw = request.getParameter("requestid");
        IRequestDAO requestDAO = new RequestDAOImpl();
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            if (requestRenting.getRequestStatus().getId() ==1) {
               requestDAO.updateStatusByRID(requestId, 3);
               request.getRequestDispatcher("*").forward(request, response);
            } else {
                request.setAttribute("message", "You can't make new contract");
                request.getRequestDispatcher("../views/error.jsp").forward(request, response);
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
        String requestIdRaw = request.getParameter("requestid");
        IRequestDAO requestDAO = new RequestDAOImpl();
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            IContractDAO contractDAO = new ContractDAOImpl();
            contractDAO.insertContract(requestRenting.getProperty().getId(), requestRenting.getRenter().getId(), currentDate);
            request.setAttribute("message", "You made new contract");
            request.getRequestDispatcher("*").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AcceptRentingRequest.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
