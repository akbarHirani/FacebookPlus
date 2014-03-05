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
 * @author Jacky
 */
@WebServlet(name = "CreditCardEditServlet", urlPatterns = {"/CreditCardEditServlet"})
public class CreditCardEditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            EmployeeSessionBean esBean = (EmployeeSessionBean) request.getSession().getAttribute("person");
            EmployeeClient employeeClient = esBean.getEmployeeClient();

            String newCardN = request.getParameter("card");
            String cardN = request.getParameter("cardNumber");
            long cardNumber = Long.parseLong(cardN);
            long newCardNumber = Long.parseLong(newCardN);

            employeeClient.editCreditCard(cardNumber, newCardNumber);
            long owner = employeeClient.getCreditCardOwner(newCardNumber);
            response.sendRedirect(request.getContextPath() + "/Employee/edit_customer_data.jsp?user_id=" + owner);

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
            Logger.getLogger(RegistrationServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistrationServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
