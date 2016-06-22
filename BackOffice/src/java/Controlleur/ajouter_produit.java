/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Beans.Categorie;
import Beans.Produit;
import Model.CategorieDAO;
import Model.ProduitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ayoub
 */
public class ajouter_produit extends HttpServlet {

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
        Produit p=new Produit();
       Categorie c=new Categorie();
             ProduitDAO pd=null;
               try {
            pd = new ProduitDAO();
                 } 
               catch (SQLException ex) {}
           catch (ClassNotFoundException ex) {}
               int id_categorie=Integer.parseInt(request.getParameter("categorie"));
               c.setIdCategorie(id_categorie);
               String libelle=request.getParameter("libelle");
               String model=request.getParameter("model");
              int prix=Integer.parseInt(request.getParameter("prix"));
              int qte_stock=Integer.parseInt(request.getParameter("qte_stock"));
              String image="css/images/"+request.getParameter("image");
             p.setCategorie(c);
             p.setLibProduit(libelle);
             p.setModel(model);
             p.setPrix(prix);
             p.setImage(image);
             p.setQteStock(qte_stock);
        try {
           pd.ajouterProduit(p);
       this.getServletContext().getRequestDispatcher("/gestion_produits.jsp?produit_ajoute").forward(request, response);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
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
