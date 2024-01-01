/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Species class which defines a Species type having below instance variables
* Species id: An id which uniquely identifies each species object
* Classification: Class to which species belong
* Language: Language which species speaks
* Designation: Designation of species
* Home World: Planet which is the homeworld of species.
* Name: name of species
* It also includes the corresponding getter and setter methods.
*/


package classes;
import logger.Logger;
import java.io.IOException;

public class Species {
    private int speciesId;
    private String classification;
    private String language;
    private String designation;
    private int homeworld;
    private String name;
    
    public Species() throws IOException {
        Logger.getInstance().log("Default Species Instance created.");
    }

    public Species(int speciesId, String classification, String language, String designation, int homeworld, String name) throws IOException {
        this.speciesId = speciesId;
        this.classification = classification;
        this.language = language;
        this.designation = designation;
        this.homeworld = homeworld;
        this.name = name;
        Logger.getInstance().log("Species Instance created with passed parameters");
    }
    
    public int getSpeciesId() {
        return speciesId;
    }

    public String getClassification() {
        return classification;
    }

    public String getLanguage() {
        return language;
    }

    public String getDesignation() {
        return designation;
    }

    public int getHomeworld() {
        return homeworld;
    }
    
    public String getName() {
        return name;
    }
    
    public void setSpeciesId(int speciesId) throws IOException {
        this.speciesId = speciesId;
        Logger.getInstance().log("Setting the species id to "+ this.speciesId);
    }

    public void setClassification(String classification) throws IOException {
        this.classification = classification;
        Logger.getInstance().log("Setting the species classification to "+ this.classification);
    }

    public void setLanguage(String language) throws IOException {
        this.language = language;
        Logger.getInstance().log("Setting the species language to "+ this.language);
    }

    public void setDesignation(String designation) throws IOException {
        this.designation = designation;
        Logger.getInstance().log("Setting the species designation to "+ this.designation);
    }

    public void setHomeworld(int homeworld) throws IOException {
        this.homeworld = homeworld;
        Logger.getInstance().log("Setting the species homeworld to "+ this.homeworld);
    }
    
    public void setName(String name) throws IOException {
        this.name = name;
        Logger.getInstance().log("Setting the species name to "+ this.name);
    }
    
}
