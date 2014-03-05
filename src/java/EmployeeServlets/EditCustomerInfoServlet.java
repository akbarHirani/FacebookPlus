/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeServlets;

import controller.RegistrationServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeClient;
import model.EmployeeSessionBean;

/**
 *
 * @author jacliang
 */
@WebServlet(name = "EditCustomerInfoServlet", urlPatterns = {"/EditCustomerInfoServlet"})
public class EditCustomerInfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            EmployeeSessionBean esBean = (EmployeeSessionBean) request.getSession().getAttribute("person");
            EmployeeClient employeeClient = esBean.getEmployeeClient();

            String user = request.getParameter("user_ID");
            long uID = Long.parseLong(user.trim());
            String address = request.getParameter("address");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String zipcode = (request.getParameter("zipcode")).trim();
            String email = request.getParameter("email");
            String telephone = (request.getParameter("telephone")).trim();
            String rating = (request.getParameter("rating")).trim();

            //if a field is empty, that signifies a future of deletion aka setting to null
            if (address.isEmpty()) {
                employeeClient.deleteUserAddress(uID);
            } else {
                employeeClient.setUserAddress(uID, address);
            }

            if (state.isEmpty()) {
                employeeClient.deleteUserState(uID);
            } else {
                employeeClient.setUserState(uID, state);
            }

            if (city.isEmpty()) {
                employeeClient.deleteUserCity(uID);
            } else {
                employeeClient.setUserCity(uID, city);
            }

            if (zipcode.isEmpty()) {
                employeeClient.deleteUserZipcode(uID);
            } else {
                employeeClient.setUserZipcode(uID, Long.parseLong(zipcode));
            }

            if (email.isEmpty()) {
                employeeClient.deleteUserEmail(uID);
            } else {
                employeeClient.setUserEmail(uID, email);
            }

            if (telephone.isEmpty()) {
                employeeClient.deleteUserTelephone(uID);
            } else {
                employeeClient.setUserTelephone(uID, Long.parseLong(telephone));
            }

            if (rating.isEmpty()) {
                employeeClient.deleteUserRating(uID);
            } else {
                employeeClient.setUserRating(uID, Long.parseLong(rating));
            }

            out.println("Begining redirecting...no error occured...");
            response.sendRedirect(request.getContextPath() + "/Employee/edit_customer_data.jsp?user_id=" + uID);
        } catch (Exception e) {
            out.println(e.toString());
        } finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>*/
}
