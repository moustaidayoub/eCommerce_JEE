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

public class Administrateur implements Serializable {
    private String nomAdmin;
    private String prenomAdmin;
    private String login;
    private String motdepasse;
    private String sexe;
    private String emailAdmin;

    public Administrateur() {
    }

    public Administrateur(String login) {
        this.login = login;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

  

    
}
