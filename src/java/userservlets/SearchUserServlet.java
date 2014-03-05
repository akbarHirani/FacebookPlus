/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserClient;
import model.UserSessionBean;
import user.SearchedUser;

/**
 *
 * @author Kal
 */
@WebServlet(name = "SearchUserServlet", urlPatterns = {"/SearchUserServlet"})
public class SearchUserServlet extends HttpServlet {

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
        try {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String circle_id = request.getParameter("circle_id");
            if(firstName == null && lastName == null) {
                out.write("Enter a first name and/or last name");
            } else {
                UserSessionBean usBean = (UserSessionBean) request.getSession().getAttribute("person");
                UserClient uClient = usBean.getUserClient();
                ArrayList<SearchedUser> users= uClient.searchUsersLike(firstName, lastName);
                
                if(users.size() > 0) {
                out.write("Click to add: <br/>");
                } else {
                    out.write("No results");
                }
                for(SearchedUser su : users) {
                    //Create add links
                    
//                    out.write("<a href='"+request.getContextPath()+"/AddFriendToCircle?circleToAddFriendTo="
//                            + circle_id
//                            + "&friend_to_add="
//                            + su.getUserID()
//                            + "'>"
//                            + su.getFirstName() + " " + su.getLastName()
//                            + "</a><br/>");
                    out.write("<a href='"+request.getContextPath() + 
                                "/user/user.jsp?user="+su.getUserID()+"'>" +
                                su.getFirstName() + " " + su.getLastName()
                                +"</a>");
                    
                    out.write(" --- ID: " + su.getUserID() + "<br />");
                }
            }  
            
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
