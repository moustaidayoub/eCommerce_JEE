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
public class FactureDAO {
     private Statement st=null;
    private connection cnx=null;
    private ResultSet rs=null;
    
      public FactureDAO() throws SQLException, ClassNotFoundException
    {
    cnx=new connection();
    st=cnx.getStatement();
    }
         public void ajouterFacture(int id_cmd,int prix_total) throws SQLException, ClassNotFoundException
    {
        st.executeUpdate("insert into Facture(num_facture,id_cmd,prix_total) values('F"+id_cmd+"',"+id_cmd+","+prix_total+");");
    }
               public float getPrixFacture(String num_facture) throws SQLException, ClassNotFoundException
    {
        
        rs=st.executeQuery("select prix_total from facture where num_facture='"+num_facture+"';");
          rs.next();
        return rs.getFloat("prix_total");
    }
}
