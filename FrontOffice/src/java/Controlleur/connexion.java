/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Beans.Client;
import Model.ClientDAO;
import Model.PanierDAO;
import Model.PanierProduitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ayoub
 */
public class connexion extends HttpServlet {

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
        doPost(request, response);
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
        Client c=new Client();
             ClientDAO ch=null;
             PanierProduitDAO ppd=null;
             PanierDAO pand=null;
             HttpSession ses=request.getSession();
             PrintWriter pr=response.getWriter();
             String login=request.getParameter("login");
              String password=request.getParameter("password");
        try {
            ch = new ClientDAO();
            pand=new PanierDAO();
            ppd=new PanierProduitDAO();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        
        try {
            if(ch.connexion(login,password)==true)
            { ses.setAttribute("login", login);
                try {
                    if(pand.hasPanier(login))
                    ses.setAttribute("panier",ppd.getAllProduitsPanier(pand.getPanier(login).getIdPanier()) );
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            { 
        this.getServletContext().getRequestDispatcher("/connexion.jsp?erreur_connexion").forward(request, response);
}
        }
        catch (SQLException ex) {
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
