/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is a JUnit test class which contains tests for all the methods in the corresponding TDG class.
* All the test methods have self explanatory names.
*/

package tabledatagateways;

import classes.Species;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpeciesTableGatewayTest {
    
    public SpeciesTableGatewayTest() {
    }

    /**
     * Test of findSpeciesDetails method, of class SpeciesTableGateway.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    @Test
    public void shouldReturnCorrectSpeciesDetails_when_correctIdPassed() 
        throws SQLException, ClassNotFoundException, IOException{
        
        Species expected = new Species (6, "mammal", "Galactic basic", "sentient", 28,"Yodas species");
        
        SpeciesTableGateway speciesGateway = new SpeciesTableGateway();
        Species actual = speciesGateway.findSpeciesDetails(6);
        
        assertEquals(expected.getSpeciesId(),actual.getSpeciesId());
        assertEquals(expected.getClassification(),actual.getClassification());
        assertEquals(expected.getLanguage(),actual.getLanguage());
        assertEquals(expected.getDesignation(),actual.getDesignation());
        assertEquals(expected.getHomeworld(),actual.getHomeworld());
        assertEquals(expected.getName(),actual.getName());
    }
    
}
