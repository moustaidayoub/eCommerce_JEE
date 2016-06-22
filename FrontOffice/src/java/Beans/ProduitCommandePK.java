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
public class ProduitCommandePK implements Serializable {

    private String model;
    private int idCmd;

    public ProduitCommandePK() {
    }

    public ProduitCommandePK(String model, int idCmd) {
        this.model = model;
        this.idCmd = idCmd;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(int idCmd) {
        this.idCmd = idCmd;
    }



  
}
