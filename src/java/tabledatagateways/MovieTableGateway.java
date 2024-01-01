/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Movie Table Data Gateway class which creates a gateway between 
* Movie class and corresponding table in database.
* It does not have any state.
* It defines a bunch of find methods to run queries on the data and return the domain objects.
*/

package tabledatagateways;
import classes.Movie;
import logger.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieTableGateway extends TableDataGateway {
    
    
    public  MovieTableGateway(String username, String password){
        super(username,password);
    }
    
    public MovieTableGateway() {
        super();
    }
    
    /*
    * This method returns the list of all Movie objects which exist in movie table
    */
    
    public ArrayList<Movie> findAllMovies() throws SQLException, ClassNotFoundException, IOException{
        String ALL_MOVIES = "SELECT * FROM movies";
        ArrayList<Movie> res = new ArrayList<>();
        //ArrayList<MoviePeopleAssociation> associations = new ArrayList<>();
        
        try{
            Connection con = TableDataGateway.connect(username, password);
            Logger.getInstance().log("Query posed on movies for all movies. ");
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(ALL_MOVIES);
                while(rs.next()){
                    Movie temp = new Movie(rs.getInt(1),
                            rs.getString(2),rs.getString(3),
                            rs.getString(4),rs.getDate(5));
                    res.add(temp);
                }
                rs.close();
            }
        }
        catch(SQLException e){}
        return res;        
    }
    
    /*
    * This method returns a Movie object for the passed movie Id
    */
    
    public Movie findDetailsOfMovie(int movieId) throws SQLException, ClassNotFoundException, IOException{
        
        String query = "SELECT * FROM movies WHERE movie_id = "+movieId;
        Movie m = new Movie();
        try{
            Connection con = TableDataGateway.connect(username, password);          
            Logger.getInstance().log("Query posed on movies for details of movie with movie_id: "+ movieId);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    m.setMovieId(rs.getInt(1));
                    m.setTitle(rs.getString(2));
                    m.setProducers(rs.getString(3));
                    m.setDirector(rs.getString(4));
                    java.sql.Date d = rs.getDate(5);
                    java.util.Date  utilDate = new java.util.Date(d.getTime());
                    m.setReleaseDate(utilDate);
                }
                rs.close();
            }
        }
        catch(SQLException e){ }
        return m;  
    }
    
    
    /*
    * This method returns the list  of Movie objects which have a release date greater than the
    * passed date
    */
    
    public ArrayList<Movie> findMoviesReleasedAfter(java.sql.Date d) throws ClassNotFoundException, IOException, SQLException {
        
        String q = "SELECT * FROM movies WHERE release_date > '" + d + "'";
        ArrayList<Movie> movieList = new ArrayList<>();
        System.out.println(q);
        try {
            Connection con = TableDataGateway.connect(username, password);          
            Logger.getInstance().log("Query posed on movies for details of movie greater than date: "+ d);
            try (Statement stmt = con.createStatement()) {
                ResultSet rs=stmt.executeQuery(q);
                while(rs.next()){
                    movieList.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                }
            }
        }
        catch(SQLException e){ }
        return movieList;
    }
}
