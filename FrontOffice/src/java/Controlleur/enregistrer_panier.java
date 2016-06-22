/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Beans.Produit;
import Model.PanierDAO;
import Model.PanierProduitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
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
public class enregistrer_panier extends HttpServlet {

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
        PrintWriter pr=response.getWriter();
        HttpSession ses=request.getSession();
        PanierDAO pand=null;
        PanierProduitDAO ppd=null;
        try {
            pand=new PanierDAO();
            ppd=new PanierProduitDAO();
        } 
        catch (SQLException ex) { }
        catch (ClassNotFoundException ex) {}
        HashMap<Produit,Integer> panier=(HashMap<Produit,Integer>) ses.getAttribute("panier");
        String login=(String) ses.getAttribute("login");
        int total=Integer.parseInt(request.getQueryString());
        try {
            if(!pand.hasPanier(login))
                pand.ajouterPanier(login, total);
           
           ppd.SupprimerAllByLogin(login);
            
            for (Entry<Produit, Integer> entry : panier.entrySet()) {
                    ppd.ajouterProduitPanier(entry.getKey().getModel(), pand.getPanier(login).getIdPanier(), entry.getValue());
            }
            pand.modifierPanier(pand.getPanier(login).getIdPanier(),total); 
     this.getServletContext().getRequestDispatcher("/consulter_panier.jsp?enregistrer_panier").forward(request, response);

        }
        catch (SQLException ex) {}
        catch (ClassNotFoundException ex) {}
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
