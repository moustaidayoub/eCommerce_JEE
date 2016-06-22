/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author Ayoub
 */

public class PanierProduit implements Serializable {
 
    protected PanierProduitPK panierProduitPK; 
    private Integer quantite;
    private Produit produit;
    private Panier panier;

    public PanierProduit() {
    }

    public PanierProduit(PanierProduitPK panierProduitPK) {
        this.panierProduitPK = panierProduitPK;
    }

    public PanierProduit(String model, int idPanier) {
        this.panierProduitPK = new PanierProduitPK(model, idPanier);
    }

    public PanierProduitPK getPanierProduitPK() {
        return panierProduitPK;
    }

    public void setPanierProduitPK(PanierProduitPK panierProduitPK) {
        this.panierProduitPK = panierProduitPK;
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

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }  
}
