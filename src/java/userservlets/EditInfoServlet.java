/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserSessionBean;
import model.UserClient;

/**
 *
 * @author Kal
 */
@WebServlet(name = "EditInfoServlet", urlPatterns = {"/EditInfoServlet"})
public class EditInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            UserSessionBean psBean = (UserSessionBean) request.getSession().getAttribute("person");
            UserClient userClient = psBean.getUserClient();
            String addr = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCodeString = request.getParameter("zipcode");
            String telephoneString = request.getParameter("telephone");
            String email = request.getParameter("email");
            
            if(!addr.isEmpty()) {
                userClient.updateAddress(addr);
            }            
            
            if(!city.isEmpty()) {
                userClient.updateCity(city);
            }            
            
            if(!state.isEmpty()) {
                userClient.updateState(state);
            }            
            
            if(!zipCodeString.isEmpty()) {
                long zipCode = Long.parseLong(zipCodeString);
                userClient.updateZipcode(zipCode);
            }           
            
            if(!telephoneString.isEmpty()) {
                long telephone = Long.parseLong(telephoneString);
            }
            
            if(!email.isEmpty()) {
                userClient.updateEmail(email);
            }
            
            //Go back!
            response.sendRedirect(request.getContextPath() + "/account_information.jsp");
        } catch (Exception ex) {
            out.println(ex.toString());
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
            response.getWriter().write(ex.toString());
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
            response.getWriter().write(ex.toString());
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
    }// </editor-fold>
}
