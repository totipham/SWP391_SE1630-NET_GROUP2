/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 14, 2022       1.0           DucPTMHE160517     First Implement
 */
package controller.dashboard;

import dal.IPropertyDAO;
import dal.IPropertyImageDAO;
import dal.IPropertyTypeDAO;
import dal.IPropertyUtilityDAO;
import dal.IUserDAO;
import dal.impl.PropertyDAOImpl;
import dal.impl.PropertyTypeDAOImpl;
import dal.impl.PropertyImageDAOImpl;
import dal.impl.UserDAOImpl;
import dal.impl.PropertyUtilityDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Property;
import model.PropertyImage;
import model.PropertyType;
import model.PropertyUtility;
import model.User;
import utils.FileUtility;
import utils.ValidateUtility;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Still have some issues related to search staff by address
 *
 * @author DucPTMHE160517
 */
@MultipartConfig
public class AddPropertyController extends HttpServlet {

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
        IUserDAO userDAO = new UserDAOImpl();
        User u = (User) session.getAttribute("user");

        //if user is not login
        if (u == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        //check if user role is equal to 1
        if (u.getRole() == 1) {

        } else if (u.getRole() == 2) { //check if role of user equal to 2
            request.setAttribute("user", u);
            request.setAttribute("page", "Add Property");
            request.getRequestDispatcher("../views/dashboard/host/addproperty.jsp").forward(request, response);
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
        
        HttpSession session = request.getSession();
        IUserDAO userDAO = new UserDAOImpl();
        User user = (User) session.getAttribute("user");

        //if user is not login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        //check if role of user is host or admin
        if (user.getRole() != 2 && user.getRole() != 3) { 
            request.setAttribute("message", "You don't have right to access this page!");
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
        
        ValidateUtility validate = new ValidateUtility();
        FileUtility fileUtils = new FileUtility();
        List<PropertyUtility> propertyUtilityList = new ArrayList<>();
        IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
        IPropertyImageDAO propertyImageDAO = new PropertyImageDAOImpl();
        IPropertyUtilityDAO propertyUtilityDAO = new PropertyUtilityDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        
        String folder = request.getServletContext().getRealPath("/assets/images");
        
        String propertyName = request.getParameter("name");
        String propertyAddress = request.getParameter("address");
        int propertyTypeId = Integer.parseInt(request.getParameter("typeid"));
        String propertyDescription = request.getParameter("description");
        double propertyPrice = Double.parseDouble(request.getParameter("price"));
        double propertyArea = Double.parseDouble(request.getParameter("area"));
        int propertyTotal = Integer.parseInt(request.getParameter("total"));
        Date createdDate = Date.valueOf(LocalDate.now());
        
        String[] uName = request.getParameterValues("uname");
        String[] uPrice = request.getParameterValues("ufee");
        String[] uPeriod = request.getParameterValues("uperiod");

        String filename = null;
        
        try {
            PropertyType propertyType = propertyTypeDAO.getTypeByID(propertyTypeId);
            
            Property property = new Property(propertyName, user, propertyAddress, 
                    propertyType, propertyDescription, propertyPrice, propertyArea, propertyTotal, createdDate);
            
            System.out.println(property);
            int propertyID = propertyDAO.insertProperty(property); //insert property to DB
            System.out.println("PropertyID: " + propertyID);
            //insert each property utility to DB
            for (int i = 0; i < uName.length; i++) {
                PropertyUtility pUtility = new PropertyUtility(propertyID, uName[i], Double.parseDouble(uPrice[i]), uPeriod[i]);
                System.out.println(pUtility);
                propertyUtilityDAO.insertPropertyUtility(pUtility); //insert utility to DB
            }
            
            List<String> listFile = fileUtils.uploadFiles("/assets/images", request);
            for (String fileName : listFile) {
                PropertyImage propertyImage = new PropertyImage(propertyID, fileName);
                System.out.println(propertyImage);
                propertyImageDAO.insertPropertyImage(propertyImage);
            }

            for (int i = 0; i < uName.length; i++) {
                System.out.println("NAME: " + uName[i]);
                System.out.println("FEE: " + uPrice[i]);
                System.out.println("PERIOD: " + uPeriod[i]);
            }


        } catch (Exception e) {
            request.setAttribute("message", e);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
