/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Movie class which defines a Movie type having below instance variables
* movie id: which uniquely identifies every movie object
* title: title of a movie
* producers: A string containing Comma seperated values for producers
* director: Director of the movie
* Release date: Date object representing the release date of movie
* It also includes the corresponding getter and setter methods.
*/

package classes;
import logger.Logger;
import java.util.Date;
import java.io.IOException;

public class Movie {
    private int movieId;
    private String title;
    private String producers;
    private String director;
    private Date releaseDate;
    
    public Movie() throws IOException{
        Logger.getInstance().log("Default Movie Instance created.");
    }
    public Movie(int movieId, String title, String producers, String director, Date releaseDate) throws IOException {
        this.movieId = movieId;
        this.title = title;
        this.producers = producers;
        this.director = director;
        this.releaseDate = releaseDate;
        Logger.getInstance().log("Movie Instance created with passed values.");
    }
    
    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getProducers() {
        return producers;
    }

    public String getDirector() {
        return director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public void setMovieId(int movieId) throws IOException {
        this.movieId = movieId;
        Logger.getInstance().log("Setting the movie Id to " + this.movieId);
    }

    public void setTitle(String title) throws IOException {
        this.title = title;
        Logger.getInstance().log("Setting the movie title to " + this.title);
    }

    public void setProducers(String producers) throws IOException {
        this.producers = producers;
        Logger.getInstance().log("Setting the movie producers to " + this.producers);
    }

    public void setDirector(String director) throws IOException {
        this.director = director;
        Logger.getInstance().log("Setting the movie director to " + this.director);
    }

    public void setReleaseDate(Date releaseDate) throws IOException {
        this.releaseDate = releaseDate;
        Logger.getInstance().log("Setting the movie release date to " + this.releaseDate);
    }
     
}
