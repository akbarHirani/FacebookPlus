/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeServlets;

import controller.RegistrationServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "TransactionServlet", urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            EmployeeSessionBean esBean = (EmployeeSessionBean) request.getSession().getAttribute("person");
            EmployeeClient employeeClient = esBean.getEmployeeClient();

            String advertisement = request.getParameter("advertisement");
            String quantity = request.getParameter("quantity");
            String account = request.getParameter("accountNumber");

            Date dateOfCreation = new Date(System.currentTimeMillis());
            long ad = Long.parseLong(advertisement.trim());
            long units = Long.parseLong(quantity);
            long acc = Long.parseLong(account);
            long uID = employeeClient.getUserFromAccount(acc);
            employeeClient.recordTransaction(employeeClient.getNextTransactionId(), ad, dateOfCreation, units, acc, uID);
            //Go back!
            out.println("Begining redirecting...no error occured...");
            response.sendRedirect(request.getContextPath()+"/Employee/employee_home.jsp");
        }catch(Exception e){
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
