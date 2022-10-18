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
import dal.impl.PropertyDAOImpl;
import dal.impl.PropertyTypeDAOImpl;
import dal.impl.PropertyImageDAOImpl;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Property;
import model.PropertyImage;
import model.PropertyType;
import model.PropertyUtility;
import model.User;
import utils.FileUtility;
import utils.ValidateUtility;

/**
 * This is a Servlet responsible for handling add new property function 
 * /dashboard/addproperty is the URL
 * Bugs: Haven't found yet
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
        User user = (User) session.getAttribute("user"); //get user from session

        //check if user is not login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect="+ request.getServletPath()); //redirect to login page
            return;
        }

        //check if user role is equal to 2
        if (user.getRole() == 2) {
            request.setAttribute("user", user);
            request.setAttribute("page", "Add Property"); //set page name
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response); //forward to add property page
        } else {
            request.setAttribute("message", "You don't have right to access this page!");
            request.getRequestDispatcher("../views/error.jsp").forward(request, response); //forward to error page
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
        User user = (User) session.getAttribute("user"); //get user from session

        //if user is not login
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect="+ request.getServletPath()); //redirect to login page
            return;
        }

        //check if role of user is host
        if (user.getRole() != 2) {
            request.setAttribute("message", "You don't have right to access this page!");
            request.getRequestDispatcher("../views/error.jsp").forward(request, response); //redirect error page
        }

        ValidateUtility validate = new ValidateUtility();
        FileUtility fileUtils = new FileUtility();
        IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
        IPropertyImageDAO propertyImageDAO = new PropertyImageDAOImpl();
        IPropertyUtilityDAO propertyUtilityDAO = new PropertyUtilityDAOImpl();
        IPropertyDAO propertyDAO = new PropertyDAOImpl();

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
            propertyName = validate.getField(request, "name", true, 5, 30); //require to get field name, field must between 5 and 30 character
            propertyAddress = validate.getField(request, "address", true, 5, 50); //require to get field name, field must between 5 and 30 character
            propertyTypeId = validate.fieldInt(request, "typeid", 1, 100); //require to get field typeid, field must greater than 1 and less than 100
            propertyDescription = validate.getField(request, "description", true, 10, 255); //require to get field description, field must between 10 and 255 character
            propertyPrice = validate.fieldDouble(request, "price", 100000, 10000000); //require to get field price, field must greater than 100000 and less than 10000000
            propertyArea = validate.fieldDouble(request, "area", 1, 100); //require to get field area, field must greater than 1 and less than 100
            propertyTotal = validate.fieldInt(request, "total", 1, 100); //require to get field total, field must greater than 1 and less than 100
            createdDate = Date.valueOf(LocalDate.now());

            uName = request.getParameterValues("uname");
            uPrice = request.getParameterValues("ufee");
            uPeriod = request.getParameterValues("uperiod");
        } catch (Exception ex) {
            Logger.getLogger(AddPropertyController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", ex.getMessage());
            request.setAttribute("page", "Add Property"); //set page name
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response); //redirect to add property page
        }

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

            List<String> listFile = fileUtils.uploadFiles("/assets/images", request); //upload list of file to storage

            //loop until last file name in list of file
            for (String fileName : listFile) {
                PropertyImage propertyImage = new PropertyImage(propertyID, fileName);
                propertyImageDAO.insertPropertyImage(propertyImage); //insert this file to DB
            }
            
            request.setAttribute("message", "Add successfully!"); //set message
            request.setAttribute("page", "Add Property"); //set page name
            request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response); //redirect to add property page

        } catch (Exception ex) {
            Logger.getLogger(AddPropertyController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response); //redirect to error page
        }
    }

}
