/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is MoviePeopleAssociation class which defines a MoviePeopleAssociation type having below instance variables
* movie id: Ihe id of movie
* people id: character id of the person
* It also includes the corresponding getter and setter methods.
*/

package classes;
import logger.Logger;
import java.util.ArrayList;
import java.io.IOException;

public class MoviePeopleAssociation {
    private ArrayList<Integer> moviePeople;
    
    public MoviePeopleAssociation(int movieId, int peopleId) throws IOException {
        moviePeople = new ArrayList<>();
        moviePeople.add(movieId);
        moviePeople.add(peopleId);
        Logger.getInstance().log("MoviePeopleAssociation Instance created with passed values.");
    }
    
    public ArrayList<Integer> getMoviesPeople() {
        return moviePeople;
    }
    
    public void setMoviesPeople(ArrayList<Integer> moviePeople) {
        this.moviePeople = moviePeople;
    }
}
