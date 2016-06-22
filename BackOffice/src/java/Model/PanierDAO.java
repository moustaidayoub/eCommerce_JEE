/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import Beans.Client;
import Beans.Panier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ayoub
 */
public class PanierDAO {
    private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public PanierDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
      
    public void ajouterPanier(String login,int prix_total) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("insert into Panier(login,prix_total_panier) values('"+login+"',"+prix_total+");");
    }
      public void modifierPanier(int id_panier,int prix_total) throws SQLException, ClassNotFoundException
    {
        
        st.executeUpdate("update Panier set prix_total_panier="+prix_total+" where id_panier="+id_panier+";");
        System.out.print("khrij");
    }
    
     public boolean hasPanier(String login) throws SQLException
     {
          rs=st.executeQuery("select count(*) from panier where login='"+login+"';");
          rs.next();
          boolean bool=false;
          
                  if(rs.getInt(1)==0)
                      bool=false;
                  else 
                      bool=true;
          return bool;
     }
       public Panier getPanier(String login) throws SQLException
     {
         Panier p=new Panier();
         Client c=new Client();
          rs=st.executeQuery("select * from panier where login='"+login+"';");
          rs.next();
         p.setIdPanier(rs.getInt("id_panier"));
         c.setLogin(rs.getString("login"));
         p.setClient(c);
         p.setPrixTotalPanier(rs.getFloat("prix_total_panier"));
         p.setDateEnregistrement(rs.getString("date_enregistrement"));
          return p;
     }
       
} 
