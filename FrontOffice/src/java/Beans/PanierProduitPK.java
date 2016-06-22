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

public class PanierProduitPK implements Serializable {

    private String model;
    private int idPanier;

    public PanierProduitPK() {
    }

    public PanierProduitPK(String model, int idPanier) {
        this.model = model;
        this.idPanier = idPanier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }


}
