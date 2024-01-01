/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Table Data Gateway class which serves as a base class to all the specific
* table data gateway classes. It contains the common functionality which all the TDGs have.
* It maintains a username and password and a class method called connect which makes connection to
* the database and is used by all the TDG classes.
*/

package tabledatagateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TableDataGateway {
    public String username;
    public String password;

    public TableDataGateway(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public TableDataGateway() {
        this.username = "root";
        this.password = "root";
    }
    
    public static Connection connect(String username,String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars",username,password);
        return con;
    }
    
}
