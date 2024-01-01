/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is MoviePeopleAssociation Table Data Gateway class which creates a gateway between 
* MoviePeopleAssociation class and corresponding table in database.
* It does not have any state.
* It defines a bunch of find methods to run queries on the data and return the domain objects.
*/

package tabledatagateways;
import logger.Logger;
import classes.MoviePeopleAssociation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;

public class MoviePeopleAssociationGateway extends TableDataGateway {
    
    
    public MoviePeopleAssociationGateway(String username, String password){
        super(username,password);
    }
    
    public MoviePeopleAssociationGateway() {
        super();
    }
    
    /*
    * This method returns the list of MoviePeopleAssociation objects for the passed movie id
    */
    
    public ArrayList<MoviePeopleAssociation> findCharactersOfMovie(int movieId) throws ClassNotFoundException, IOException {
        ArrayList<MoviePeopleAssociation> moviePeopleRecords = new ArrayList<>();
        String q = "SELECT * FROM movie_people WHERE movie_id = "+ movieId;
        
        Logger.getInstance().log("Query posed on movie_people for movie_id: "+ movieId);
        try{
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(q);
                while(rs.next()){
                    moviePeopleRecords.add(new MoviePeopleAssociation(rs.getInt(1), rs.getInt(2)));
                }
                rs.close();
            }
        }
        catch(SQLException e){
        
        }
        return moviePeopleRecords;      
    }
    
    /*
    * This method returns the list of MoviePeopleAssociation objects for the passed character id
    */
    
    public ArrayList<MoviePeopleAssociation> findMoviesOfCharacter(int characterID) throws ClassNotFoundException, IOException{
        ArrayList<MoviePeopleAssociation> moviePeopleIDs = new ArrayList<>();
        String query = "SELECT * FROM movie_people WHERE character_id = "+ characterID;
        
        Logger.getInstance().log("Query posed on movie_people for character_id: "+ characterID);
        try{
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next()){
                    moviePeopleIDs.add(new MoviePeopleAssociation(rs.getInt(1), rs.getInt(2)));
                }
                rs.close();
            }
        }
        catch(SQLException e){
        }
        return moviePeopleIDs;
    }
    
    /*
    * This method returns the list of all MoviePeopleAssociation objects which exist in 
    * MoviePeopleAssociation table
    */
    
    public ArrayList<MoviePeopleAssociation> findAll() throws ClassNotFoundException, IOException{
        ArrayList<MoviePeopleAssociation> moviePeopleIDs = new ArrayList<>();
        String query = "SELECT * FROM movie_people";
        
        Logger.getInstance().log("Query posed on movie_people table for details.");
        try{
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next()){
                    moviePeopleIDs.add(new MoviePeopleAssociation(rs.getInt(1), rs.getInt(2)));
                }
                rs.close();
            }
        }
        catch(SQLException e){
        }
        return moviePeopleIDs;
    }
}
