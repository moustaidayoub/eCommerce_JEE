/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import Beans.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Ayoub
 */
public class PanierProduitDAO {
       private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public PanierProduitDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
      
    public void SupprimerAllByLogin(String login) throws SQLException, ClassNotFoundException
    {
        PanierDAO pand=null;
        pand=new PanierDAO();
        int id=pand.getPanier(login).getIdPanier();
        st.executeUpdate("delete from panier_produit where id_panier="+id+";");
    }
      public void ajouterProduitPanier(String model,int id_panier,int qte) throws SQLException, ClassNotFoundException
    {
    st.executeUpdate("insert into panier_produit(model,id_panier,quantite) values('"+model+"',"+id_panier+","+qte+");");
    }
      public HashMap<Produit,Integer> getAllProduitsPanier(int id_panier) throws SQLException, ClassNotFoundException
    {
        ProduitDAO pd=new ProduitDAO();
        HashMap<Produit,Integer> panier=new HashMap<Produit,Integer>();
        rs=st.executeQuery("select * from panier_produit where id_panier="+id_panier+";");

        while(rs.next())
        {
           Produit p=new Produit();
           p=pd.getProduit(rs.getString("model"));
            int qte=rs.getInt("quantite");
          panier.put(p, qte);       
        }
        return panier;
    }
}
