/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.Commande;
import java.io.Serializable;


/**
 *
 * @author Ayoub
 */

public class ProduitCommande implements Serializable {
   
    protected ProduitCommandePK produitCommandePK; 
    private Integer quantite;
    private Produit produit;
    private Commande commande;

    public ProduitCommande() {
    }

    public ProduitCommande(ProduitCommandePK produitCommandePK) {
        this.produitCommandePK = produitCommandePK;
    }

    public ProduitCommande(String model, int idCmd) {
        this.produitCommandePK = new ProduitCommandePK(model, idCmd);
    }

    public ProduitCommandePK getProduitCommandePK() {
        return produitCommandePK;
    }

    public void setProduitCommandePK(ProduitCommandePK produitCommandePK) {
        this.produitCommandePK = produitCommandePK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

}
