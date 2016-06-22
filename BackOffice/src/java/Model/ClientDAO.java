/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Beans.Client;
import BD.connection;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Ayoub
 */
public class ClientDAO {
   
    private Statement st;
    private connection cnx;
    private ResultSet rs;
    public ClientDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
    public void ajouterClient(Client c) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("insert into Client values('"+c.getLogin()+"','"+c.getNomClient()+"','"+c.getPrenomClient()+"','"+c.getEmailClient()+"','"+c.getDateNaissance()+"','"+c.getMotdepasse()+"','"+c.getSexe()+"','"+c.getDateNaissance()+"','"+c.getAdresse()+"');");
    }
    
      public void supprimerClient(String login) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("delete from Client where login='"+login+"';");
    }
    
    
    
    public boolean TestLogin(String login) throws SQLException
    {
        rs=st.executeQuery("select count(*) from Client where login='"+login+"';");
        rs.first();
        if(rs.getInt(1)==0)
            return false;
        else 
            return true;
 
   }
    
    
    
    public Boolean connexion(String login,String motdepasse) throws SQLException{
        rs=st.executeQuery("select count(*) from Client where login='"+login+"' and motdepasse='"+motdepasse+"';");
        rs.first();
        if(rs.getInt(1)==0)
            return false;
        else 
            return true;
 
    }
    
    public Vector<Client> getAllClients() throws SQLException, ClassNotFoundException
    {
        Vector<Client> vc=new Vector<Client>();
        
        rs=st.executeQuery("select * from client;");

        while(rs.next())
        {
            Client c=new Client();
            c.setLogin(rs.getString("login"));
        c.setNomClient(rs.getString("nom_client"));
        c.setPrenomClient(rs.getString("prenom_client"));
        c.setEmailClient(rs.getString("email_client"));
        c.setDateInscription(rs.getString("date_inscription"));
        c.setMotdepasse(rs.getString("motdepasse"));
        c.setSexe(rs.getString("sexe"));
        c.setDateNaissance(rs.getString("date_naissance"));
        c.setAdresse(rs.getString("adresse"));
        vc.add(c);
               
        }
        return vc;
    }
}
