/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userservlets;

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
import model.UserClient;
import model.UserSessionBean;
import user.Comment;
import user.Post;

/**
 *
 * @author Kal
 */
@WebServlet(name = "AddPostServlet", urlPatterns = {"/AddPostServlet"})
public class AddPostServlet extends HttpServlet {

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

            String circleID = request.getParameter("circle_id");
            String pageID = request.getParameter("page_id");

            //Build Comment
            long pageIDLong = Long.parseLong(pageID);
            long nextId = uClient.getNextPostID();
            long userID = usBean.getUserID();
            Date date = new Date(System.currentTimeMillis());
            String content = request.getParameter("add_post_content");
            
            Post post = new Post(nextId, date, content, 0, pageIDLong, userID, 0);
            uClient.insertPost(post);

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
