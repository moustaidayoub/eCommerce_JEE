/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import Beans.Categorie;
import Beans.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Ayoub
 */
public class ProduitDAO {
              private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public ProduitDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
      
    public void ajouterProduit(Produit p) throws SQLException, ClassNotFoundException
    {
         st.executeUpdate("insert into Produit(id_categorie,lib_produit,model,prix,image,qte_stock) values('"+p.getCategorie().getIdCategorie()+"','"+p.getLibProduit()+"','"+p.getModel()+"','"+p.getPrix()+"','"+p.getImage()+"',"+p.getQteStock()+");");
    }
    
     public Vector<Produit> getAllProduits() throws SQLException, ClassNotFoundException
    {
        Vector<Produit> vp=new Vector<Produit>();
        CategorieDAO cd=new CategorieDAO();
        rs=st.executeQuery("select * from produit;");

        while(rs.next())
        {
            Produit p=new Produit();
            Categorie c=new Categorie();
            c.setIdCategorie(rs.getInt("id_categorie"));
            c.setLibCategorie(cd.getLibCategorie(rs.getInt("id_categorie")));
           p.setCategorie(c);
           p.setLibProduit(rs.getString("lib_produit"));
           p.setModel(rs.getString("model"));
           p.setPrix(rs.getInt("prix"));
           p.setDateAjout(rs.getString("date_ajout"));
           p.setImage(rs.getString("image"));
           p.setQteStock(rs.getInt("qte_stock"));
          
        vp.add(p);
               
        }
        return vp;
    }
       public Produit getProduit(String model) throws SQLException
     {
         Produit p=new Produit();
         Categorie c=new Categorie();
          rs=st.executeQuery("select * from produit where model='"+model+"';");
          rs.next();
          c.setIdCategorie(rs.getInt("id_categorie"));
          p.setCategorie(c);
          p.setLibProduit(rs.getString("lib_produit"));
          p.setModel(rs.getString("model"));
          p.setPrix(rs.getInt("prix"));
          p.setDateAjout(rs.getString("date_ajout"));
          p.setImage(rs.getString("image"));
          p.setQteStock(rs.getInt("qte_stock"));

          return p;
     }
     public void modifierProduit(String model,int id_categorie,String lib,int prix) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("update Produit set id_categorie="+id_categorie+",lib_produit='"+lib+"',prix="+prix+" where model='"+model+"';");
    }
          public void modifierQteProduit(String model,int qte_stock) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("update Produit set qte_stock="+qte_stock+" where model='"+model+"';");
    }
       public void supprimerProduit(String model) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("delete from produit where model='"+model+"';");
    }
            public Vector<Produit> getNewProduits() throws SQLException
     {
         Vector<Produit> vp=new Vector<Produit>();
         
         Categorie c=new Categorie();
          rs=st.executeQuery("select * from produit where qte_stock>0 order by date_ajout DESC LIMIT 6;");
          while(rs.next()){
              Produit p=new Produit();
          c.setIdCategorie(rs.getInt("id_categorie"));
          p.setCategorie(c);
          p.setLibProduit(rs.getString("lib_produit"));
          p.setModel(rs.getString("model"));
          p.setPrix(rs.getInt("prix"));
           p.setDateAjout(rs.getString("date_ajout"));
          p.setImage(rs.getString("image"));
          p.setQteStock(rs.getInt("qte_stock"));

          vp.add(p);
          }
          return vp;
     }
             public Vector<Produit> getProduitsByCategorie(int id_categorie) throws SQLException
     {
         Vector<Produit> vp=new Vector<Produit>();
         
         Categorie c=new Categorie();
          rs=st.executeQuery("select * from produit where id_categorie="+id_categorie+" and qte_stock>0;");
          while(rs.next()){
              Produit p=new Produit();
          c.setIdCategorie(rs.getInt("id_categorie"));
          p.setCategorie(c);
          p.setLibProduit(rs.getString("lib_produit"));
          p.setModel(rs.getString("model"));
          p.setPrix(rs.getInt("prix"));
          p.setDateAjout(rs.getString("date_ajout"));
          p.setImage(rs.getString("image"));
        p.setQteStock(rs.getInt("qte_stock"));
          vp.add(p);
          }
          return vp;
     }
}
