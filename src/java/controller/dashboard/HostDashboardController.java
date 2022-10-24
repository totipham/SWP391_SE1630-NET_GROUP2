/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 18, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.dashboard;

import dao.IContractDAO;
import dao.IPropertyDAO;
import dao.IRequestDAO;
import dao.IUserDAO;
import dao.impl.ContractDAOImpl;
import dao.impl.PropertyDAOImpl;
import dao.impl.RequestDAOImpl;
import dao.impl.UserDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Property;
import model.User;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method will
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Still have some issues related to search staff by address
 *
 * @author DucPTMHE160517
 */
public class HostDashboardController extends HttpServlet {

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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        //if user is not login
        if (u == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + request.getServletPath());
            return;
        }

        //check if user role is equal to 1
        if (u.getRole() == 2) { //check if role of user equal to 2
            try {
                IRequestDAO requestDAO = new RequestDAOImpl();
                IContractDAO contractDAO = new ContractDAOImpl();
                IPropertyDAO propertyDAO = new PropertyDAOImpl();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar begin = Calendar.getInstance();
                Calendar today = Calendar.getInstance();
                begin.add(Calendar.DATE, -14);
                Calendar firstDayOfMonth = Calendar.getInstance();   // this takes current date
                firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

                Map<Date, Integer> mapRequest = requestDAO.getNumberRequestByRange(u.getId(),
                        Date.valueOf(sdf.format(begin.getTime())),
                        Date.valueOf(sdf.format(today.getTime())));
                Set<Date> setRequestDaily = mapRequest.keySet();
                int numberOfReq = 0;

                //loop each key of set request daily
                for (Date key : setRequestDaily) {
                    numberOfReq += mapRequest.get(key);
                }

                double totalIncome = 0;

                Map<Date, Double> mapIncome = contractDAO.getIncomeInRange(u.getId(),
                        Date.valueOf(sdf.format(firstDayOfMonth.getTime())),
                        Date.valueOf(sdf.format(today.getTime())));

                Set<Date> setIncome = mapIncome.keySet();

                //loop each key of set request daily
                for (Date key : setIncome) {
                    totalIncome += (mapIncome.get(key) / 1000000);
                }

                int numberOfRents = contractDAO.getNumberOfContractInRange(u.getId(),
                        Date.valueOf(sdf.format(firstDayOfMonth.getTime())),
                        Date.valueOf(sdf.format(today.getTime())));

                List<User> todayRenterList = contractDAO.getRenterListByDate(u.getId(),
                        Date.valueOf(sdf.format(today.getTime())));

                //check if number of rents equal 0
                if (numberOfRents < 0) {
                    numberOfRents = 0;
                }
                
                Map<Property, Integer> mapTrendingProperty = propertyDAO.getTrendingRentProperty(u.getId());
                
                Set<Property> setTrendingProperty = mapTrendingProperty.keySet();

                request.setAttribute("mapTrendingProperty", mapTrendingProperty);
                request.setAttribute("setTrendingProperty", setTrendingProperty);
                request.setAttribute("mapIncome", mapIncome);
                request.setAttribute("setIncome", setIncome);
                request.setAttribute("totalIncome", totalIncome);
                request.setAttribute("todayRenterList", todayRenterList);
                request.setAttribute("numberOfRents", numberOfRents);
                request.setAttribute("numberOfReq", numberOfReq);
                request.setAttribute("mapRequestDaily", mapRequest);
                request.setAttribute("setRequestDaily", setRequestDaily);
            } catch (Exception ex) {
                request.setAttribute("message", ex);
                request.getRequestDispatcher("../views/error.jsp").forward(request, response);
            }

            request.setAttribute("user", u);
            request.setAttribute("page", "Dashboard");
            request.getRequestDispatcher("../views/dashboard/host/dashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "You don't have right to access this page!");
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
