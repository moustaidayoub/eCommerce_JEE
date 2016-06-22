/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Ayoub
 */

public class Categorie implements Serializable {

    private Integer idCategorie;
    private String libCategorie;
    private Collection<Produit> produitCollection;

    public Categorie() {
    }

    public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibCategorie() {
        return libCategorie;
    }

    public void setLibCategorie(String libCategorie) {
        this.libCategorie = libCategorie;
    }

    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }
}