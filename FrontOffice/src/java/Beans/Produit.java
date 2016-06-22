/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import Beans.Categorie;
import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Ayoub
 */

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    private String libProduit;
    private String model;
    private String image;
    private Categorie categorie;
    private int prix;
    private String dateAjout;
    private int qteStock;
    private Collection<PanierProduit> panierProduitCollection;
    private Collection<ProduitCommande> produitCommandeCouleurCollection;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Produit() {
    }

    public Produit(String model) {
        this.model = model;
    }

    public String getLibProduit() {
        return libProduit;
    }

    public void setLibProduit(String libProduit) {
        this.libProduit = libProduit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Collection<PanierProduit> getPanierProduitCollection() {
        return panierProduitCollection;
    }

    public void setPanierProduitCollection(Collection<PanierProduit> panierProduitCollection) {
        this.panierProduitCollection = panierProduitCollection;
    }

    public Collection<ProduitCommande> getProduitCommandeCouleurCollection() {
        return produitCommandeCouleurCollection;
    }

    public void setProduitCommandeCouleurCollection(Collection<ProduitCommande> produitCommandeCouleurCollection) {
        this.produitCommandeCouleurCollection = produitCommandeCouleurCollection;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

}
