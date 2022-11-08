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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
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
 * The class contains method find update, delete, insert staff information from
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author ThuongTTHE163555
 */
@MultipartConfig
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
        
        IPropertyDAO propertyDAO = new PropertyDAOImpl();
        IPropertyUtilityDAO propertyUltilityDAO = new PropertyUtilityDAOImpl();
        
        List<PropertyUtility> listUtility = null;
        Property property = null;
        
        
        //check if user role is equal to 2
        if (user.getRole() == 2) {    
            // set last information to front end
            try {            
            String pid = request.getParameter("pid");
            int id = Integer.parseInt(pid);           
            
            listUtility = propertyUltilityDAO.getUtilitiesByPID(id);
            property =propertyDAO.getPropertyById(id);
                 
            
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePropertyController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                 Logger.getLogger(UpdatePropertyController.class.getName()).log(Level.SEVERE, null, ex);
             }
            

            request.setAttribute("property", property);
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
            ValidateUtility validate = new ValidateUtility();
            //check if user role is admin or hostpid
            if (user.getRole() == 2 || user.getRole() == 1) {
                String pid = request.getParameter("propertyid");
                System.out.println("Hahahahaha " + pid);
                int id = Integer.parseInt(pid);
                IPropertyDAO propertyDAO = new PropertyDAOImpl();

                //get property by id
                Property property = propertyDAO.getPropertyById(id);

                
                FileUtility fileUtils = new FileUtility();
                IPropertyTypeDAO propertyTypeDAO = new PropertyTypeDAOImpl();
                IPropertyImageDAO propertyImageDAO = new PropertyImageDAOImpl();
                IPropertyUtilityDAO propertyUtilityDAO = new PropertyUtilityDAOImpl();

                String propertyName = validate.getField(request, "name", true, 5, 30);
                String propertyAddress = validate.getField(request, "address", true, 5, 50);
                int propertyTypeId = validate.fieldInt(request, "typeid", 1, 100);
                String propertyDescription = validate.getField(request, "description", true, 10, 255);
                double propertyPrice = validate.fieldDouble(request, "price", 100000, 10000000);
                double propertyArea = validate.fieldDouble(request, "area", 1, 100);
                int propertyTotal = validate.fieldInt(request, "total", 1, 100);
                Date createdDate = Date.valueOf(LocalDate.now());
                String[] uName = request.getParameterValues("uname");
                String[] uPrice = request.getParameterValues("ufee");
                String[] uPeriod = request.getParameterValues("uperiod");

                //set peoperty with infromation
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
                    propertyDAO.updateProperty(property);
                    
                    //update utility fee
                    for (int i = 0; i < uName.length; i++) {
                        PropertyUtility pUtility = new PropertyUtility(id, uName[i], Double.parseDouble(uPrice[i]), uPeriod[i].toLowerCase());
                        propertyUtilityDAO.updatePropertyUtility(pUtility); 
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
                    request.getRequestDispatcher("../views/dashboard/property/editproperty.jsp").forward(request, response);


            } else {
                throw new Exception("Don't have permission to access this page!");
            }
        } catch (Exception e) {
            Logger.getLogger(UpdatePropertyController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("../views/error.jsp").forward(request, response);
        }
    }

}
