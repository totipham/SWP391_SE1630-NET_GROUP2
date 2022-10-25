/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 18, 2022       1.3           DucPTMHE160517      SEND DATA FOR INCOME CHART
 */
package controller.dashboard;

import dao.IContractDAO;
import dao.IPropertyDAO;
import dao.IRequestDAO;
import dao.impl.ContractDAOImpl;
import dao.impl.PropertyDAOImpl;
import dao.impl.RequestDAOImpl;
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
 * This Servlet responsible for handling forget password function /forget is the
 * URL The method will throw an object of <code>java.lang.Exception</code> class
 * if there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
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
        User user = (User) session.getAttribute("user"); //get user from the session

        //if user is not login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + request.getServletPath());
            return;
        }

        //check if role of user equal to 2
        if (user.getRole() == 2) { 
            
            try {
                IRequestDAO requestDAO = new RequestDAOImpl();
                IContractDAO contractDAO = new ContractDAOImpl();
                IPropertyDAO propertyDAO = new PropertyDAOImpl();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //give format for date
                
                Calendar today = Calendar.getInstance(); //current date
                
                Calendar begin = Calendar.getInstance(); //set begin date equals current date
                begin.add(Calendar.DATE, -7); //set begin date equals 7 days before current date
                
                Calendar firstDayOfMonth = Calendar.getInstance(); //set first day of month equals to current date
                firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1); //set first day of month equals to 1st day of current month

                Map<Date, Integer> mapRequest = requestDAO.getNumberRequestByRange(user.getId(),
                        Date.valueOf(sdf.format(begin.getTime())),
                        Date.valueOf(sdf.format(today.getTime()))); //get number of request per day (date)
                Set<Date> setRequestDaily = mapRequest.keySet(); //get set of date
                
                int numberOfRequest = 0; //init number of request

                //loop each key of set request daily
                for (Date keyDate : setRequestDaily) {
                    numberOfRequest += mapRequest.get(keyDate); //add number of request per day (date)
                }

                double totalIncome = 0; //init income

                Map<Date, Double> mapIncome = contractDAO.getIncomeInRange(user.getId(),
                        Date.valueOf(sdf.format(firstDayOfMonth.getTime())),
                        Date.valueOf(sdf.format(today.getTime()))); //get income per day (date)
                Set<Date> setIncome = mapIncome.keySet(); //get set of date

                //loop each key of set request daily
                for (Date key : setIncome) {
                    totalIncome += (mapIncome.get(key) / 1000000); //add income (divided by 1M) to total income
                }

                int numberOfRents = contractDAO.getNumberOfContractInRange(user.getId(),
                        Date.valueOf(sdf.format(firstDayOfMonth.getTime())),
                        Date.valueOf(sdf.format(today.getTime()))); //get number of range from first day of month to current

                //check if number of rents equal 0
                if (numberOfRents < 0) {
                    numberOfRents = 0; //set number of rents to 0
                }

                List<User> todayRenterList = contractDAO.getRenterListByDate(user.getId(),
                        Date.valueOf(sdf.format(today.getTime()))); //get list of renter of today
                Map<Property, Integer> mapTrendingProperty = propertyDAO.getTrendingRentProperty(user.getId()); //get number of rent per property
                Set<Property> setTrendingProperty = mapTrendingProperty.keySet(); //get set of property in map trending property

                request.setAttribute("mapTrendingProperty", mapTrendingProperty); //set attribute map trending property 
                request.setAttribute("setTrendingProperty", setTrendingProperty); //set attribute for set of trending property
                request.setAttribute("mapIncome", mapIncome); //set attribute for map of income
                request.setAttribute("setIncome", setIncome); //set attribute for set of income
                request.setAttribute("totalIncome", totalIncome); //set attribute for total of income
                request.setAttribute("todayRenterList", todayRenterList); //set attribute for today renter list
                request.setAttribute("numberOfRents", numberOfRents); //set attribute for number of rent
                request.setAttribute("numberOfReq", numberOfRequest); //set attribute for number of request
                request.setAttribute("mapRequestDaily", mapRequest); //set attribute for map of request 
                request.setAttribute("setRequestDaily", setRequestDaily); //set attribute for set of daily request
            } catch (Exception ex) {
                request.setAttribute("message", ex); //set attribute for exception
                request.getRequestDispatcher("../views/error.jsp").forward(request, response); //forward to error page
            }

            request.setAttribute("user", user); //set attribute for session user
            request.setAttribute("page", "Dashboard"); //set attribute page name
            request.getRequestDispatcher("../views/dashboard/host/dashboard.jsp").forward(request, response); //forward to host dashboard page
        } else {
            request.setAttribute("message", "You don't have right to access this page!"); //set attribute for message
            request.getRequestDispatcher("../views/error.jsp").forward(request, response); //forward to error page
        }
    }

}
