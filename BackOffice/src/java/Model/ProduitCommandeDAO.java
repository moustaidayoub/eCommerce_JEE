/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ayoub
 */
public class ProduitCommandeDAO {
     private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public ProduitCommandeDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
          public void ajouterProduitCommande(String model,int id_cmd,int qte) throws SQLException, ClassNotFoundException
    {
    st.executeUpdate("insert into produit_commande(model,id_cmd,quantite) values('"+model+"',"+id_cmd+","+qte+");");
    }
}
