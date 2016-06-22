/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.Client;
import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Ayoub
 */

public class Panier implements Serializable {

    private Integer idPanier;
    private Float prixTotalPanier;
    private String dateEnregistrement;
    private Collection<PanierProduit> panierProduitCollection;
    private Client client;

    public Panier() {
    }

    public Panier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Float getPrixTotalPanier() {
        return prixTotalPanier;
    }

    public void setPrixTotalPanier(Float prixTotalPanier) {
        this.prixTotalPanier = prixTotalPanier;
    }

    public String getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(String dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Collection<PanierProduit> getPanierProduitCollection() {
        return panierProduitCollection;
    }

    public void setPanierProduitCollection(Collection<PanierProduit> panierProduitCollection) {
        this.panierProduitCollection = panierProduitCollection;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
