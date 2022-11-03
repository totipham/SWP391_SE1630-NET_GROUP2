/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 25, 2022         1.0           ThuongTTHE163555     First Implement
 */
package controller.dashboard;

import dao.IPropertyDAO;
import dao.IPropertyImageDAO;
import dao.IPropertyTypeDAO;
import dao.IPropertyUtilityDAO;
import dao.impl.PropertyDAOImpl;
import dao.impl.PropertyImageDAOImpl;
import dao.impl.PropertyTypeDAOImpl;
import dao.impl.PropertyUtilityDAOImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 * The class contains method find update, delete, insert staff information from
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author ThuongTTHE163555
 */
public class UpdatePropertyController extends HttpServlet {

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
        
        
        //check if user has logged in
         HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); //get user from session        
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login?redirect="+ request.getServletPath()); //redirect to login page
            return;
        }
        List<PropertyUtility> listUtility = null;
        //check if user role is equal to 2
        if (user.getRole() == 2) {    
            // set ultitlity list to front end
            try {            
            String pid = request.getParameter("pid");
            int id = Integer.parseInt(pid);
            IPropertyUtilityDAO propertyUltilityDAO = new PropertyUtilityDAOImpl();
            listUtility = propertyUltilityDAO.getUtilitiesByPID(id);
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAaaaa" + listUtility);
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePropertyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("listUtility", listUtility);            
            request.setAttribute("user", user);
            request.setAttribute("page", "Edit Property"); //set page name
            request.getRequestDispatcher("../views/dashboard/property/editproperty.jsp").forward(request, response); //forward to add property page
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
        // Update         
        try {
            //get id from front end
            String pid = request.getParameter("pid");
            //check if user role is admin or host
            if (user.getRole() == 2 || user.getRole() == 1) {
                int id = Integer.parseInt(pid);
                IPropertyDAO propertyDAO = new PropertyDAOImpl();

                //get property by id
                Property property = propertyDAO.getPropertyById(id);

                ValidateUtility validate = new ValidateUtility();
                FileUtility fileUtils = new FileUtility();
                List<PropertyUtility> propertyUtilityList = new ArrayList<>();
                IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
                IPropertyImageDAO propertyImageDAO = new PropertyImageDAOImpl();
                IPropertyUtilityDAO propertyUtilityDAO = new PropertyUtilityDAOImpl();

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

                //get property with infromation from front end
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
                    Logger.getLogger(AddPropertyController.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("error", ex.getMessage());
                    request.setAttribute("page", "Add Property");
                    request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response);
                }

                String filename = null;
                //set peoperty with infromation
                try {
                    PropertyType propertyType = propertyTypeDAO.getTypeByID(propertyTypeId);
                    //update property from database
                    property.setName(propertyName);
                    property.setAddress(propertyAddress);
                    property.setType(propertyType);
                    property.setDescription(propertyDescription);
                    property.setPrice(propertyPrice);
                    property.setArea(propertyArea);
                    property.setTotal(propertyTotal);
                    property.setCreatedDate(createdDate);
                    //update utility fee
                    for (int i = 0; i < uName.length; i++) {
                        PropertyUtility pUtility = new PropertyUtility(id, uName[i], Double.parseDouble(uPrice[i]), uPeriod[i].toLowerCase());
                        propertyUtilityDAO.insertPropertyUtility(pUtility); //insert utility to DB
                    }
                    //update image
                    List<String> listFile = fileUtils.uploadFiles("/assets/images", request); //upload list of file to storage

                    //loop until last file name in list of file
                    for (String fileName : listFile) {
                        PropertyImage propertyImage = new PropertyImage(id, fileName);
                        propertyImageDAO.insertPropertyImage(propertyImage); //insert this file to DB
                    }

                    request.setAttribute("message", "Update successfully!");
                    request.setAttribute("page", "Update Property");

                    //re-load                    
                    request.getRequestDispatcher("../views/dashboard/property/addproperty.jsp").forward(request, response);

                } catch (Exception ex) {
                    Logger.getLogger(AddPropertyController.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", ex);
                    request.getRequestDispatcher("../views/error.jsp").forward(request, response);
                }

            } else {
                throw new Exception("Don't have permission to access this page!");
            }
        } catch (Exception e) {
            Logger.getLogger(UpdatePropertyController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e);
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
