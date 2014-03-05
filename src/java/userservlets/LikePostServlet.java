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
@WebServlet(name = "LikePostServlet", urlPatterns = {"/LikePostServlet"})
public class LikePostServlet extends HttpServlet {

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
            
            String postID = request.getParameter("post_id");
            long postIDLong  = Long.parseLong(postID);
            long userID = usBean.getUserID();
            String circleID = request.getParameter("circle_id");
            
            if(uClient.userLikesPost(postIDLong)) {
                //Change to unlike by removing the entry and decrementing the val
                uClient.unlikePost(postIDLong);
            }else{
                //Change to like
                uClient.likePost(postIDLong);
            }
            response.sendRedirect(request.getContextPath() + "/user/circle.jsp?circle_id=" + circleID);
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
