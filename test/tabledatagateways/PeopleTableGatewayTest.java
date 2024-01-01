/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is a JUnit test class which contains tests for all the methods in the corresponding TDG class.
* All the test methods have self explanatory names.
*/

package tabledatagateways;

import classes.People;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeopleTableGatewayTest {
    
    public PeopleTableGatewayTest() {
    }

    /**
     * Test of findCharacterDetails method, of class PeopleTableGateway.
     */
    @Test
    public void shouldReturnCorrectPeopleDetails_when_correctIdPassed() throws IOException{
        //arrange
        int characterId = 1;
        People expected = new People(1, "Luke Skywalker", 0, 172, 1, "19BBY", "male", "blue", "blond", "fair");

        //act
        PeopleTableGateway peopleGateway = new PeopleTableGateway();
        People actual = peopleGateway.findCharacterDetails(characterId);

        //assert
        assertEquals(expected.getPeopleId(), actual.getPeopleId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSpeciesId(), actual.getSpeciesId());
        assertEquals(expected.getHeight(), actual.getHeight());
        assertEquals(expected.getHomeWorld(), actual.getHomeWorld());
        assertEquals(expected.getBirthYear(), actual.getBirthYear());
        assertEquals(expected.getGender(), actual.getGender());
        assertEquals(expected.getEyeColor(), actual.getEyeColor());
        assertEquals(expected.getSkinColor(), actual.getSkinColor());
        assertEquals(expected.getHairColor(), actual.getHairColor());
    }

    /**
     * Test of findCharsinMoviesByGenders method, of class PeopleTableGateway.
     * @throws java.lang.Exception
     */
    //@Test
   public void shouldReturnCorrectCountOfGender_When_FemalePassed() throws Exception {
        String gender = "female";
        PeopleTableGateway instance = new PeopleTableGateway();
        int expResult = 17;
        ArrayList<People> result = instance.findCharsinMoviesByGenders(gender);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of findCharsinMoviesByHeight method, of class PeopleTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectCountOfCharsGreaterThanHeight_when_HeightPassed() throws Exception {
        int height = 150;
        PeopleTableGateway instance = new PeopleTableGateway();
        int expected = 69;
        ArrayList<People> result = instance.findCharsinMoviesByHeight(height);
        assertEquals(expected, result.size());
    }

    /**
     * Test of findCharacterDetailsWithName method, of class PeopleTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectPeopleDetails_when_correctNamePassed() throws Exception {
        //arrange
        String name = "Yoda";
        People expected = new People(20, "Yoda", 6, 66, 28, "896BBY", "male", "brown", "white", "green");

        //act
        PeopleTableGateway peopleGateway = new PeopleTableGateway();
        People actual = peopleGateway.findCharacterDetailsWithName(name);

        //assert
        assertEquals(expected.getPeopleId(), actual.getPeopleId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSpeciesId(), actual.getSpeciesId());
        assertEquals(expected.getHeight(), actual.getHeight());
        assertEquals(expected.getHomeWorld(), actual.getHomeWorld());
        assertEquals(expected.getBirthYear(), actual.getBirthYear());
        assertEquals(expected.getGender(), actual.getGender());
        assertEquals(expected.getEyeColor(), actual.getEyeColor());
        assertEquals(expected.getSkinColor(), actual.getSkinColor());
        assertEquals(expected.getHairColor(), actual.getHairColor());
    }

    /**
     * Test of findCharsinPlanets method, of class PeopleTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectCountOfPlanets_when_PlanetNamePassed() throws Exception {
        String planet = "Tatooine";
        PeopleTableGateway instance = new PeopleTableGateway();
        ArrayList<People> result = instance.findCharsinPlanets(planet);
        
        int expected = 10;
        assertEquals(expected, result.size());
    }
    
}
