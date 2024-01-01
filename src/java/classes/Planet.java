/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Planet class which defines a Planet type having below instance variables
* Planet id: An id which uniquely identifies each planet object
* Name: Name of the planet
* Climate: Climate conditions at the planet
* Terrain: Terrain of planet
* Population: population on the planet
* It also includes the corresponding getter and setter methods.
*/

package classes;
import logger.Logger;
import java.io.IOException;

public class Planet {
    private int planetId;
    private String name;
    private String climate;
    private String terrain;
    private String population;
    
    public Planet() throws IOException {
        Logger.getInstance().log("Default Planet Instance created.");
    }

    public Planet(int planetId, String name, String climate, String terrain, String population) throws IOException {
        this.planetId = planetId;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.population = population;
        Logger.getInstance().log("Planet Instance created with passed values.");
    }
    
    public int getPlanetId(){
        return planetId;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getPopulation() {
        return population;
    }
    
    public void setPlanetId(int planetId) throws IOException{
        this.planetId = planetId;
        Logger.getInstance().log("Setting the planet id to "+this.planetId);
    }

    public void setName(String name) throws IOException {
        this.name = name;
        Logger.getInstance().log("Setting the planet name to "+this.name);
    }

    public void setClimate(String climate) throws IOException {
        this.climate = climate;
        Logger.getInstance().log("Setting the planet climate to "+this.climate);
    }

    public void setTerrain(String terrain) throws IOException {
        this.terrain = terrain;
        Logger.getInstance().log("Setting the planet terrain to "+this.terrain);
    }

    public void setPopulation(String population) throws IOException {
        this.population = population;
        Logger.getInstance().log("Setting the planet population to "+this.population);
    }
    
}
