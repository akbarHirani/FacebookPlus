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
import user.Message;
import model.UserClient;
import model.UserSessionBean;

/**
 *
 * @author Kal
 */
@WebServlet(name = "SendMessageServlet", urlPatterns = {"/SendMessageServlet"})
public class SendMessageServlet extends HttpServlet {

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
            UserSessionBean usBean =  (UserSessionBean) request.getSession().getAttribute("person");
            UserClient userClient = usBean.getUserClient();
            String content = request.getParameter("content");
            String subject = request.getParameter("subject");
            String senderStr = request.getParameter("sender");
            String recieverStr = request.getParameter("reciever");

            Date date = new Date(System.currentTimeMillis());
            long messageID = userClient.getNextMessageID();
            
            long sender = Long.parseLong(senderStr);
            long reciever = Long.parseLong(recieverStr);
            
            Message messageToSend = new Message(messageID, date, sender, reciever, content, subject);
            
            while(userClient.insertMessage(messageToSend)<0){
                //Try again
                userClient.insertMessage(messageToSend);
            }
            
            response.sendRedirect(request.getContextPath() + "/user/messaging.jsp?partner=" + recieverStr);
            
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
