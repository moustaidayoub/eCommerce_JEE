package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayoub
 */
public class connection {
     private Connection cnx;
    private Statement st;
    String username = "root";
    String password = null;
    private String url="jdbc:mysql://localhost:3306/ecom_bd";
    
    public connection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
    cnx = DriverManager.getConnection(url, username, password);
    st = cnx.createStatement();
    }
    
    public Statement getStatement()
    {
    return st;
    }
}
