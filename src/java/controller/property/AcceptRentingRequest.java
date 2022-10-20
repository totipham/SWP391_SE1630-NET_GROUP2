/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */
package controller.property;

import dal.IContractDAO;
import dal.IRequestDAO;
import dal.impl.ContractDAOImpl;
import dal.impl.RequestDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Property;
import model.Request;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
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
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            IRequestDAO requestDAO = new RequestDAOImpl();
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            if (requestRenting.getRequestStatus().getId() == 3) {
               request.getRequestDispatcher("*").forward(request, response);
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
        String requestIdRaw = request.getParameter("requestid");
        try {
            int requestId = Integer.parseInt(requestIdRaw);
            IRequestDAO requestDAO = new RequestDAOImpl();
            Request requestRenting = requestDAO.getRequestByRID(requestId);
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            IContractDAO contractDAO = new ContractDAOImpl();
            contractDAO.insertContract(requestRenting.getProperty().getId(), requestRenting.getRenter().getId(), currentDate);
            request.setAttribute("message", "You made new contract");
            request.getRequestDispatcher("*").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AcceptRentingRequest.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

}
