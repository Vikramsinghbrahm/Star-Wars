/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Species Table Data Gateway class which creates a gateway between 
* Species class and corresponding table in database.
* It does not have any state.
* It defines a bunch of find methods to run queries on the data and return the domain objects.
*/

package tabledatagateways;

import classes.Species;
import logger.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SpeciesTableGateway extends TableDataGateway {    
    
    public  SpeciesTableGateway(String username,String password){
        super(username,password);
    }
    public  SpeciesTableGateway() {
        super();
    }
    
    /*
    * This method retuns the Species object for the passed species id
    */
    public Species findSpeciesDetails(int speciesId) throws ClassNotFoundException, IOException {
        Species speciesObj = new Species();
        String q = "SELECT * FROM species WHERE species_id="+speciesId;
        try{
            Logger.getInstance().log("Query posed on species for details of species with id: "+ speciesId);
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(q);
                while(rs.next()){
                    speciesObj.setSpeciesId(speciesId);
                    speciesObj.setClassification(rs.getString(2));
                    speciesObj.setLanguage(rs.getString(3));
                    speciesObj.setDesignation(rs.getString(4));
                    speciesObj.setHomeworld(rs.getInt(5));
                    speciesObj.setName(rs.getString(6));
                }
                rs.close();
            }
        }
        catch(SQLException e){
            
        }
        return speciesObj;
    }
    
}
