/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is a JUnit test class which contains tests for all the methods in the corresponding TDG class.
* All the test methods have self explanatory names.
*/

package tabledatagateways;

import classes.Movie;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTableGatewayTest {
    
    public MovieTableGatewayTest() {
    }
    
     /**
     * Test of findAllMovies method, of class MovieTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectCount_When_AllMoviesQueried() throws Exception {
        MovieTableGateway instance = new MovieTableGateway();
        int expected = 6;
        ArrayList<Movie> result = instance.findAllMovies();
        assertEquals(expected, result.size());
    }

    /**
     * Test of findDetailsOfMovie method, of class MovieTableGateway.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    @Test
    public void shouldReturnCorrectMovieDetails_when_correctIdPassed() 
        throws SQLException, ClassNotFoundException, IOException, ParseException{
        
        String date = "1977-05-25";
        java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date dt = new java.sql.Date(d.getTime());
        Movie expected = new Movie(1, "A New Hope", "Gary Kurtz, Rick McCallum", "George Lucas", dt);
        
        MovieTableGateway movieGateway = new MovieTableGateway(); 
        Movie actual = movieGateway.findDetailsOfMovie(1);
        
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getProducers(), actual.getProducers());
        assertEquals(expected.getDirector(), actual.getDirector());
        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
    }

    /**
     * Test of findMoviesReleasedAfter method, of class MovieTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectCount_When_CorrectReleaseDatePassed() throws Exception {
        String date = "1977-05-25";
        java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date dt = new java.sql.Date(d.getTime());
        MovieTableGateway instance = new MovieTableGateway();
        ArrayList<Movie> result = instance.findMoviesReleasedAfter(dt);
        
        int expected = 5;
        
        assertEquals(expected, result.size());
    }    
}
