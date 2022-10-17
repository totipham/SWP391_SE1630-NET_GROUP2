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
            response.sendRedirect(request.getContextPath() + "/login?redirect="+ request.getServletPath());
            return;
        }

        //check if user role is equal to 1
        if (u.getRole() == 1) {

        } else if (u.getRole() == 2) { //check if role of user equal to 2
            request.setAttribute("user", u);
            request.setAttribute("page", "Add Property");
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response);
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
            response.sendRedirect(request.getContextPath() + "/login?redirect="+ request.getServletPath());
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
        String propertyName = "";
        String propertyAddress = "";
        int propertyTypeId = 0;
        String propertyDescription = "";
        double propertyPrice = 0;
        double propertyArea = 0;
        int propertyTotal = 0;
        Date createdDate = null;
        String[] uName = null;
        String[] uPrice = null;
        String[] uPeriod = null;
        
        try {
            propertyName = validate.getField(request, "name", true, 5, 30);
            propertyAddress = validate.getField(request, "address", true, 5, 50);
            propertyTypeId = validate.fieldInt(request, "typeid", 1, 100);
            propertyDescription = validate.getField(request, "description", true, 10, 255);
            propertyPrice = validate.fieldDouble(request, "price", 100000, 10000000);
            propertyArea = validate.fieldDouble(request, "area", 1, 100);
            propertyTotal = validate.fieldInt(request, "total", 1, 100);
            createdDate = Date.valueOf(LocalDate.now());

            uName = request.getParameterValues("uname");
            uPrice = request.getParameterValues("ufee");
            uPeriod = request.getParameterValues("uperiod");
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.setAttribute("page", "Add Property");
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response);
        }

        String filename = null;

        try {
            PropertyType propertyType = propertyTypeDAO.getTypeByID(propertyTypeId);

            Property property = new Property(propertyName, user, propertyAddress,
                    propertyType, propertyDescription, propertyPrice, propertyArea, propertyTotal, createdDate);

            int propertyID = propertyDAO.insertProperty(property); //insert property to DB

            //loop until last file name in list of file
            for (int i = 0; i < uName.length; i++) {
                PropertyUtility pUtility = new PropertyUtility(propertyID, uName[i], Double.parseDouble(uPrice[i]), uPeriod[i].toLowerCase());
                propertyUtilityDAO.insertPropertyUtility(pUtility); //insert utility to DB
            }

            List<String> listFile = fileUtils.uploadFiles("/assets/images", request);

            //loop until last file name in list of file
            for (String fileName : listFile) {
                PropertyImage propertyImage = new PropertyImage(propertyID, fileName);
                propertyImageDAO.insertPropertyImage(propertyImage);
            }
            
            request.setAttribute("message", "Add successfully!");
            request.setAttribute("page", "Add Property");
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("message", e);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
