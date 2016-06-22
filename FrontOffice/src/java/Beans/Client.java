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
public class Client {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    private String login;
    private String nomClient;
    private String prenomClient;
    private String emailClient;
    private String dateInscription;
    private String motdepasse;
    private String sexe;
    private String dateNaissance;
    private String adresse;
    private Collection<Commande> commandeCollection;
    private Collection<Panier> panierCollection;

    public Client() {
    }

    public Client(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public Collection<Panier> getPanierCollection() {
        return panierCollection;
    }

    public void setPanierCollection(Collection<Panier> panierCollection) {
        this.panierCollection = panierCollection;
    }

       
}

