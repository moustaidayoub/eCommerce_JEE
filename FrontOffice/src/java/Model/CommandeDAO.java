/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import Beans.Client;
import Beans.Commande;
import Beans.Facture;
import Beans.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Ayoub
 */
public class CommandeDAO {
      private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public CommandeDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
         public void ajouterCommande(String login) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("insert into Commande(login) values('"+login+"');");
    }
              public int getLastIdCmd() throws SQLException
     {
          rs=st.executeQuery("select max(id_cmd) from commande ;");
          rs.next();
         int id=rs.getInt(1);
          return id;
     }
    
     public Vector<Commande> getAllCommandes() throws SQLException, ClassNotFoundException
    {
        Vector<Commande> vc=new Vector<Commande>();
        Client client=new Client();
        Facture f=new Facture();
        rs=st.executeQuery("select * from commande;");

        while(rs.next())
        {
            Commande c=new Commande();
            c.setIdCmd(rs.getInt("id_cmd"));
        c.setDateCmd(rs.getString("date_cmd"));
        c.setEtatCmd(rs.getString("etat_cmd"));
        client.setLogin(rs.getString("login"));
        c.setClient(client);
        f.setNumFacture(rs.getString("num_facture"));
        c.setFacture(f);
        vc.add(c);
               
        }
        return vc;
    }
       public void validerCmd(int id) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("update Commande set etat_cmd='valide' where id_cmd="+id+";");
    }
         public void modifierCommande(int id_cmd) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("update Commande set num_facture='F"+id_cmd+"' where id_cmd="+id_cmd+";");
    }
           public Vector<Commande> getCommandesByClient(String login) throws SQLException, ClassNotFoundException
    {
        Vector<Commande> vc=new Vector<Commande>();
        Client client=new Client();
        Facture f=new Facture();
        FactureDAO fd=new FactureDAO();
        rs=st.executeQuery("select * from commande where login='"+login+"';");

        while(rs.next())
        {
            Commande c=new Commande();
            c.setIdCmd(rs.getInt("id_cmd"));
        c.setDateCmd(rs.getString("date_cmd"));
        c.setEtatCmd(rs.getString("etat_cmd"));
        client.setLogin(rs.getString("login"));
        c.setClient(client);
        f.setNumFacture(rs.getString("num_facture"));
        f.setPrixTotal(fd.getPrixFacture(rs.getString("num_facture")));
        
        c.setFacture(f);
        vc.add(c);
               
        }
        return vc;
    }
}
