/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.connection;
import Beans.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Ayoub
 */
public class CategorieDAO {
      private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public CategorieDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
      
    public void ajouterCategorie(String lib) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("insert into Categorie(lib_categorie) values('"+lib+"');");
    }
    
     public Vector<Categorie> getAllCategories() throws SQLException, ClassNotFoundException
    {
        Vector<Categorie> vc=new Vector<Categorie>();
        
        rs=st.executeQuery("select * from categorie;");

        while(rs.next())
        {
            Categorie c=new Categorie();
            c.setIdCategorie(rs.getInt("id_categorie"));
        c.setLibCategorie(rs.getString("lib_categorie"));
        vc.add(c);
               
        }
        return vc;
    }
     public String getLibCategorie(int id) throws SQLException
     {
          rs=st.executeQuery("select lib_categorie from categorie where id_categorie="+id+";");
          rs.next();
          return rs.getString("lib_categorie");
     }
     public void modifierCategorie(int id,String lib) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("update Categorie set lib_categorie='"+lib+"' where id_categorie="+id+";");
    }
       public void supprimerCategorie(int id) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("delete from produit where id_categorie="+id+";");
        st.executeUpdate("delete from categorie where id_categorie="+id+";");
    }
     
}    

