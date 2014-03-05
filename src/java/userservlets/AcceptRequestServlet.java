/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserClient;
import model.UserSessionBean;

/**
 *
 * @author Kal
 */
@WebServlet(name = "AcceptRequestServlet", urlPatterns = {"/AcceptRequestServlet"})
public class AcceptRequestServlet extends HttpServlet {

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
            UserSessionBean usBean = (UserSessionBean) request.getSession().getAttribute("person");
            UserClient uClient = usBean.getUserClient();
            
            String pUser = request.getParameter("pending_user");
            long pUserID = Long.parseLong(pUser);
            
            String circleIDS = request.getParameter("circle_id");
            long circleID = Long.parseLong(circleIDS);
            
            //Remove the tuple in the join requests, and insert into addedto
            int ret = uClient.addUserToCircle(pUserID, circleID);
            if(ret < 0) {            
                response.sendRedirect(request.getContextPath() +"/user/circle_members.jsp?circle_id=" + circleIDS);            
            }
            out.println("Failed to add user... try again");
        } 
        catch (Exception e) {
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
