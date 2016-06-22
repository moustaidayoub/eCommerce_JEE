/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.Commande;
import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Ayoub
 */

public class Facture implements Serializable {

    private String numFacture;
    private int idCmd;
    private Float prixTotal;
    private Collection<Commande> commandeCollection;

    public Facture() {
    }

    public Facture(String numFacture) {
        this.numFacture = numFacture;
    }

    public Facture(String numFacture, int idCmd) {
        this.numFacture = numFacture;
        this.idCmd = idCmd;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public int getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(int idCmd) {
        this.idCmd = idCmd;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }
}
