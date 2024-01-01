/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is a JUnit test class which contains tests for all the methods in the corresponding TDG class.
* All the test methods have self explanatory names.
*/

package tabledatagateways;

import classes.Planet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanetTableGatewayTest {
    
    public PlanetTableGatewayTest() {
    }

    /**
     * Test of findPlanetDetails method, of class PlanetTableGateway.
     */
    @Test
    public void shouldReturnCorrectPlanetDetails_when_correctIdPassed() throws SQLException, ClassNotFoundException, IOException{
        
        Planet expected = new Planet (1, "Tatooine", "arid", "desert", "200000");
        
        PlanetTableGateway planetGateway = new PlanetTableGateway();
        Planet actual = planetGateway.findPlanetDetails(1);
        
        assertEquals(expected.getPlanetId(),actual.getPlanetId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getClimate(),actual.getClimate());
        assertEquals(expected.getTerrain(),actual.getTerrain());
        assertEquals(expected.getPopulation(),actual.getPopulation());
    }

    /**
     * Test of findAll method, of class PlanetTableGateway.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    @Test
    public void shouldReturnCorrectPlanetsCount() throws ClassNotFoundException, SQLException, IOException{
        PlanetTableGateway planetGateway = new PlanetTableGateway();
        ArrayList<Planet> planetList = planetGateway.findAll();
        int expected = 61;
        assertEquals(expected,planetList.size());
    }

    /**
     * Test of findPlanetDetailsWithName method, of class PlanetTableGateway.
     * @throws java.lang.Exception
     */
    @Test
    public void shouldReturnCorrectPlanetDetails_when_CorrectNamePassed() throws Exception {
        Planet expected = new Planet (1, "Tatooine", "arid", "desert", "200000");
        String planetName = "Tatooine";
        PlanetTableGateway planetGateway = new PlanetTableGateway();
        Planet actual = planetGateway.findPlanetDetailsWithName(planetName);
        
        assertEquals(expected.getPlanetId(),actual.getPlanetId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getClimate(),actual.getClimate());
        assertEquals(expected.getTerrain(),actual.getTerrain());
        assertEquals(expected.getPopulation(),actual.getPopulation());
    }
    
}
