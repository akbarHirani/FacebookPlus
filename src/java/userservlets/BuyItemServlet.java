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
import user.AdItem;
import user.Purchase;

/**
 *
 * @author Kal
 */
@WebServlet(name = "BuyItemServlet", urlPatterns = {"/BuyItemServlet"})
public class BuyItemServlet extends HttpServlet {

    /*
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
            String adID = request.getParameter("adId");            
            String amountToBuy = request.getParameter("numUnitsToBuy_" + adID);
            
            if(amountToBuy == null || adID == null ){
                out.println("Some params are empty");
                return;
            }
            
            long adIDL = Long.parseLong(adID);
            long amountToBuyL = Long.parseLong(amountToBuy);
            
            if(amountToBuyL < 1) {
                out.println("Only numbers bigger then 1");
                return;
            }
                                    
            UserSessionBean usBean = (UserSessionBean) request.getSession().getAttribute("person");
            UserClient uClient = usBean.getUserClient();
            
            AdItem adItem = uClient.getAdItemById(adIDL);
           
            if(amountToBuyL > adItem.getAvailUnits()) {
                out.println("Only buy amount within the available units");
                return;
            }

            long nextId = uClient.getNextPurchaseId();
            Date date = new Date(System.currentTimeMillis());
            
            Purchase purchase = new Purchase(nextId, date, adIDL, amountToBuyL, usBean.getCurrentAccount(), usBean.getUserID() );
            
            uClient.addPurchase(purchase);
            out.println("You successfully bought " + amountToBuyL + " of " + adItem.getItemName());
            out.println("<br/>");
            out.println("<a href='"+request.getContextPath()+"user/shopping.jsp'>Go back to shopping</a>");
            response.sendRedirect(request.getContextPath()+"/user/shopping.jsp");                
            
        } catch (SQLException ex) {
            out.println(ex.toString());
        } catch(NumberFormatException ex) {
            out.println("Only numbers for the number field");
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
