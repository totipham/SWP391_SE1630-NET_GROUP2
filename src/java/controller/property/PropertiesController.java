package controller.property;

import dal.impl.PropertyDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Property;

/**
 *
 * @author Asus
 */
public class PropertiesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PropertyController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PropertyController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        PropertyDAOImpl pd = new PropertyDAOImpl();
        List<Property> list = null;
        if (request.getParameter("advanced-search") == null && request.getParameter("keyword") != null) {
            list = pd.getPropertiesByKeyword(request.getParameter("keyword"));
            String minPrice = request.getParameter("fromPrice");
            System.out.println("minPrice: " + minPrice);
            request.setAttribute("keyword", request.getParameter("keyword"));
        } else if (request.getParameter("advanced-search") != null) {
            String keyword = request.getParameter("keyword");
            String dateSort_raw = request.getParameter("created-date-sort");
            String priceSort_raw = request.getParameter("price-sort");
            String minPrice_raw = request.getParameter("fromPrice");
            String maxPrice_raw = request.getParameter("toPrice");
            String area_raw = request.getParameter("area-num");

            double minPrice = 0, maxPrice = 5000000, area = -1;
            int dateSort = -1, priceSort = -1;
            if (dateSort_raw.equals("lastest")) {
                dateSort = 0;
            } else if (dateSort_raw.equals("oldest")) {
                dateSort = 1;
            }
            
            if (priceSort_raw.equals("highest-first")) {
                priceSort = 0;
            } else if (priceSort_raw.equals("lowest-first")) {
                priceSort = 1;
            }

            try {
                minPrice = Double.parseDouble(minPrice_raw);
                maxPrice = Double.parseDouble(maxPrice_raw);

                if (area_raw == "") {
                    area = -1;
                } else {
                    area = Integer.parseInt(area_raw);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("price sort " + priceSort );
            
            list = pd.getPropertiesByFiter(keyword, dateSort, priceSort,
                    maxPrice, minPrice, area);
            request.setAttribute("advancedSearch", 1);
            request.setAttribute("keyword", request.getParameter("keyword"));
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("minPrice", minPrice);
            request.setAttribute("area", area);
            request.setAttribute("priceSort", priceSort);
            request.setAttribute("dateSort", dateSort);

        } else {
            list = pd.getAllProperties();
        }

        List<Property> finalList = null;
        int numPerPage = 5;
        int numPs = list.size();
        
        int numPage = numPs / numPerPage + (numPs % numPerPage == 0 ? 0 : 1);
        int start, end;
        String page_raw = request.getParameter("page");
        int page;

        try {
            page = Integer.parseInt(page_raw);

        } catch (NumberFormatException e) {
            page = 1;
        }
        start = (page - 1) * numPerPage;
        if (page * numPerPage > numPs) {
            end = numPs;
        } else {
            end = page * numPerPage;
        }
        
//        finalList = pd.getPropertyByPage(list, start, end);

        //elements per page
        request.setAttribute("finalList", finalList);

        //number of page
        request.setAttribute("num", numPage);
        request.setAttribute("page", page);
        System.out.println("gt la: " + numPage);

        
//        List<PriceTrending> priceTrendingList = pd.getPriceTrending();
//        request.setAttribute("priceTrendingList", priceTrendingList);
        request.setAttribute("listProperty", list);
        request.getRequestDispatcher("views/property/properties.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
