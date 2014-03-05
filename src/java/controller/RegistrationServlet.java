/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kal
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

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
            
            //Person info
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            long zipCode = Long.parseLong(request.getParameter("zipCode"));
            String gender = request.getParameter("gender");
            String telephoneWithDashes = request.getParameter("telephone");
            String email = request.getParameter("email");  
            String dateOfBirthInString = request.getParameter("dateOfBirth");
            
            //Safe breakup since we had javascript
            int year = Integer.parseInt(dateOfBirthInString.substring(0, 3));
            int month = Integer.parseInt(dateOfBirthInString.substring(5, 6));
            int day = Integer.parseInt(dateOfBirthInString.substring(8, 9));
            Date dateOfBirth = new Date(year, month, day);

            //Break up telephone
            long firstPartOfTel = Integer.parseInt(telephoneWithDashes.substring(0, 3)) * (long) Math.pow(10, 7);
            long secPartOfTel = Integer.parseInt(telephoneWithDashes.substring(4, 7)) * (long) Math.pow(10, 4);
            long thirdPartOfTel = Integer.parseInt(telephoneWithDashes.substring(8, 12));
            long fullTel = firstPartOfTel + secPartOfTel + thirdPartOfTel;
                        
            //Account info
//            String personID = request.getParameter("personID");
//            String password = request.getParameter("password");
            
            SQLManager sqlManager = new SQLManager();
            
            //Insert the person...
            long ret = sqlManager.registerUser(firstName, lastName, address, city, state, zipCode, gender, fullTel, email, dateOfBirth);           
            
            //Insert the user
            
            if(ret > 0){
                out.println("Successfully registered! Your userID is "+ret+"<br/>");
                out.println("<a href='/Facebook/login.jsp'>Log in here!</a>");
            }else{
                out.println("Try again...<br/>");
                out.println("<a href='/Facebook/register.jsp'>Go back!</a>");
            }
            
        }
        catch (SQLException e) {
            out.println("Some SQL Problem... <br/>");
            out.println(e.toString());
        }
        catch (Exception e) {
            out.println(e.toString());
        }
        finally {     
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
    }// </editor-fold>
}
