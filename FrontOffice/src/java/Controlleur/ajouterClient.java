/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Model.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
import Beans.Client;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ayoub
 */
public class ajouterClient extends HttpServlet {

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
             PrintWriter pr=response.getWriter();
        try {
            ch = new ClientDAO();
        } catch (SQLException ex) {
            Logger.getLogger(ajouterClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ajouterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            String login=request.getParameter("login");
             String nom=request.getParameter("nom");
             String prenom=request.getParameter("prenom");
              String email=request.getParameter("email");
             String sexe=request.getParameter("sexe");
             String date_naissance=request.getParameter("date_naissance");
              String addresse=request.getParameter("addresse");
             String mdp=request.getParameter("mdp");
            c.setLogin(login);
            c.setNomClient(nom);
            c.setPrenomClient(prenom);
            c.setEmailClient(email);
            c.setDateInscription(date_naissance);
            c.setMotdepasse(mdp);
            c.setSexe(sexe);
            c.setDateNaissance(date_naissance);
            c.setAdresse(addresse);
        try {
            if(ch.TestLogin(login)==true || ch.TestEmail(email)==true)
                this.getServletContext().getRequestDispatcher("/inscription.jsp?login_existe").forward(request, response);
            else
            { 
                ch.ajouterClient(c);
            this.getServletContext().getRequestDispatcher("/index.jsp?client_ajoute").forward(request, response);

            }
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(ajouterClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(ajouterClient.class.getName()).log(Level.SEVERE, null, ex);
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
