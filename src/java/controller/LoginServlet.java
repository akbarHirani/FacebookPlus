/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Kal
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession(true);           
            String personID = request.getParameter("personID");            
            long userID = Long.parseLong(personID);
            long personIDLong = Long.parseLong(personID);
            
            String type = request.getParameter("type");
            
            if(type.equals("user")) { 
                
                if(!isAUser(userID)) {
                    //Failed to login...
                    out.println("Failed to login!");
                    return;
                }
                
                //Create the Bean!

                UserSessionBean psBean = new UserSessionBean(userID);
                UserClient userClient = psBean.getUserClient();
                
                String firstName = userClient.getFirstName();
                String lastName = userClient.getLastName();   
                
                psBean.setFirstName(firstName);
                psBean.setLastName(lastName);
                psBean.setUserID(userID);
                
                out.println("First Name:" + firstName);
                out.println("Last Name:" + lastName);

                session.setAttribute("person", psBean);

                //Suppose PersonID = SSN at the moment and only users log on 
                response.sendRedirect("/Facebook/user/account_selection.jsp");
                
            } else if(type.equals("employee")) { 
out.println("You are attempting to log in as employee ID " + personIDLong);
                if (!isAEmployee(personIDLong)) {
                    //Failed to login...
                    out.println("Failed to login!");
                    out.println("Person ID was " + personIDLong);
                    return;
                }
                out.println("you got in!");
                
                //###########################################################################
                EmployeeSessionBean esBean = new EmployeeSessionBean(personIDLong);
                EmployeeClient employeeClient = esBean.getEmployeeClient();
                
                String firstName = employeeClient.getFirstName();
                out.println("got first, last coming");
                String lastName = employeeClient.getLastName();
                out.println("got last,  id coming");

                long employeeId = employeeClient.getEmployeeID();
                out.println("got id");

                esBean.setFirstName(firstName);
                esBean.setLastName(lastName);
                esBean.setEmployeeID(employeeId);

                out.println("First Name:" + firstName);
                out.println("Last Name:" + lastName);

                session.setAttribute("person", esBean);
                //always use sendredirect
                response.sendRedirect(request.getContextPath() + "/Employee/employee_home.jsp");

                //###########################################################################                
                
            } else if(type.equals("manager")) { 
                
                if(!isAManager(personIDLong)) {
                    //Failed to login...
                    out.println("Failed to login!");
                    return;
                } 
                
                ManagerClient managerClient = new ManagerClient(personIDLong);
                
            } else {
                out.println("Could not find your account...");
            }
        } catch (SQLException e) {
                out.println(e.toString());
           }
         finally {            
                out.close();
            }
    }    

    protected boolean isAUser(long personID) throws SQLException{
        SQLManager sqlManager = new SQLManager();
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        
        ResultSet rs = ps.executeQuery();
                
        if (!rs.next()){        
            con.close();
            return false;
        } else {
            con.close();
            return true;
        }
        
    }
    
    protected boolean isAEmployee(long personID) throws SQLException {
        SQLManager sqlManager = new SQLManager();
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM employee WHERE Employee_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        
        ResultSet rs = ps.executeQuery();
        
        if (!rs.next()){
            return false;
        } else {
            return true;
        }
    }
    
    protected boolean isAManager(long personID) throws SQLException {
        SQLManager sqlManager = new SQLManager();
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM manager WHERE Manager_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        
        ResultSet rs = ps.executeQuery();
        
        if (!rs.next()){
            return false;
        } else {
            return true;
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
        processRequest(request, response);
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
