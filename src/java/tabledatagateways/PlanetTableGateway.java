/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Planet Table Data Gateway class which creates a gateway between 
* Planet class and corresponding table in database.
* It does not have any state.
* It defines a bunch of find methods to run queries on the data and return the domain objects.
*/

package tabledatagateways;

import classes.Planet;
import logger.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlanetTableGateway extends TableDataGateway{
    
    public  PlanetTableGateway(String username,String password){
        super(username,password);
    }
    
    public  PlanetTableGateway (){
        super();
    }
    
    /*
    * This method returns the Planet object for the passed planet id
    */
    public Planet findPlanetDetails(int planetId) throws ClassNotFoundException, IOException {
        Planet planetObj = new Planet();
        String q = "SELECT * FROM planets WHERE planet_id="+planetId;
        try{
            Logger.getInstance().log("Query posed on planets for details of planet with id: "+ planetId);
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(q);
                while(rs.next()){
                    planetObj.setPlanetId(planetId);
                    planetObj.setName(rs.getString(2));
                    planetObj.setClimate(rs.getString(3));
                    planetObj.setTerrain(rs.getString(4));
                    planetObj.setPopulation(rs.getString(5));
                }
                rs.close();
            }
        }
        catch(SQLException e){
            
        }
        return planetObj;
    }
    
    /*
    * This method returns the list of all Planet objects which exist in planet table
    */
    public ArrayList<Planet> findAll() throws ClassNotFoundException, SQLException, IOException{
        ArrayList<Planet> list = new ArrayList<>();
    
        String query = "SELECT * FROM planets";
        
            try {
                Logger.getInstance().log("Query posed on planets for details of all planets. ");
                Connection con = TableDataGateway.connect(username, password);
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        Planet temp= new Planet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                        list.add(temp);
                    }
                }  
            }   catch (ClassNotFoundException ex) {
           
        }
            return list;
    }
    
    /*
    * This method returns the Planet object for the passed planet name
    */
    public Planet findPlanetDetailsWithName(String planetName) throws ClassNotFoundException, IOException{
        Planet planetObj = new Planet();
        String query = "SELECT * FROM planets WHERE name='"+planetName+"'";
        try{
            Connection con=TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    planetObj.setPlanetId(rs.getInt(1));
                    planetObj.setName(planetName);
                    planetObj.setClimate(rs.getString(3));
                    planetObj.setTerrain(rs.getString(4));
                    planetObj.setPopulation(rs.getString(5));
                }
                rs.close();
            }
        }
        catch(SQLException e){
            
        }
        return planetObj;
    }
}