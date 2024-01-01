/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is People class which defines a People type having below instance variables
* people id: An Id which uniquely identifies a people object
* name: Name of the character/people
* species Id: the species id which the character belong to
* Height: height of the character
* Home world: Home world of character. An id of a planet which is character's home world.
* Birth Year: Year in which character was born.
* Gender: Gender of character
* Eye Color: Color of character's eyes
* Skin Color: Color of character's skin
* Hair Color: Color of character's hair
* It also includes the corresponding getter and setter methods.
*/

package classes;
import logger.Logger;
import java.io.IOException;

public class People{

    private int peopleId;
    private String name;
    private int speciesId;
    private int height;
    private int homeWorld;
    private String birthYear;
    private String gender;
    private String eyeColor;
    private String hairColor;
    private String skinColor;
    
    public People() throws IOException {
        Logger.getInstance().log("Default People Instance created.");
    }

    public People(int peopleId, String name, int speciesId, int height, int homeWorld, String birthYear, String gender, String eyeColor, String hairColor, String skinColor) throws IOException {
        this.peopleId = peopleId;
        this.name = name;
        this.height = height;
        this.speciesId=speciesId;
        this.homeWorld = homeWorld;
        this.birthYear = birthYear;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        Logger.getInstance().log("People Instance created with passed parameters.");
    }

    public int getPeopleId() {
        return peopleId;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public int getHomeWorld() {
        return homeWorld;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }
    
    public void setPeopleId(int peopleId) throws IOException {
        this.peopleId = peopleId;
        Logger.getInstance().log("Setting the people id to "+ this.peopleId);
    }

    public void setName(String name) throws IOException {
        this.name = name;
        Logger.getInstance().log("Setting the people name to "+ this.name);
    }

    public void setHeight(int height) throws IOException {
        this.height = height;
        Logger.getInstance().log("Setting the people heightto "+ this.height);
    }

    public void setSpeciesId(int speciesId) throws IOException {
        this.speciesId = speciesId;
        Logger.getInstance().log("Setting the people species id to "+ this.speciesId);
    }

    public void setHomeWorld(int homeWorld) throws IOException {
        this.homeWorld = homeWorld;
        Logger.getInstance().log("Setting the people home world to "+ this.homeWorld);
    }

    public void setBirthYear(String birthYear) throws IOException {
        this.birthYear = birthYear;
        Logger.getInstance().log("Setting the people birthYear to "+ this.birthYear);
    }

    public void setGender(String gender) throws IOException {
        this.gender = gender;
        Logger.getInstance().log("Setting the people gender to "+ this.gender);
    }

    public void setEyeColor(String eyeColor) throws IOException {
        this.eyeColor = eyeColor;
        Logger.getInstance().log("Setting the people eyeColor to "+ this.eyeColor);
    }

    public void setHairColor(String hairColor) throws IOException {
        this.hairColor = hairColor;
        Logger.getInstance().log("Setting the people hairColor to "+ this.hairColor);
    }

    public void setSkinColor(String skinColor) throws IOException {
        this.skinColor = skinColor;
        Logger.getInstance().log("Setting the people skinColor to "+ this.skinColor);
    }
}