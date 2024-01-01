/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is a JUnit test class which contains tests for all the methods in the corresponding TDG class.
* All the test methods have self explanatory names.
*/

package tabledatagateways;

import classes.MoviePeopleAssociation;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoviePeopleAssociationGatewayTest {
    
    public MoviePeopleAssociationGatewayTest() {
    }

    /**
     * Test of findCharactersOfMovie method, of class MoviePeopleAssociationGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectNumberOfCharacters_when_CorrectMovieIdPassed() throws Exception {
        int movieId = 1;
        MoviePeopleAssociationGateway instance = new MoviePeopleAssociationGateway();
        ArrayList<MoviePeopleAssociation> result = instance.findCharactersOfMovie(movieId);
        
        int expected = 18;
        assertEquals(expected, result.size());

    }

    /**
     * Test of findMoviesOfCharacter method, of class MoviePeopleAssociationGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectNumberOfMovies_when_CorrectCharacterIdPassed() throws Exception {
        int characterID = 1;
        MoviePeopleAssociationGateway instance = new MoviePeopleAssociationGateway();
        ArrayList<MoviePeopleAssociation> result = instance.findMoviesOfCharacter(characterID);
        int expected = 4;
        assertEquals(expected, result.size());
    }

    /**
     * Test of findAll method, of class MoviePeopleAssociationGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectCount() throws Exception {
        MoviePeopleAssociationGateway instance = new MoviePeopleAssociationGateway();
        ArrayList<MoviePeopleAssociation> result = instance.findAll();
        int expected = 162;
        assertEquals(expected, result.size());
    }
    
}
