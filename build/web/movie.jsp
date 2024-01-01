<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,classes.*,tabledatagateways.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Details</title>
        <style>
            input[type=submit] {
                background-color: #ffad33;
                color: white;
                padding: 12px;
                font-size: 12px;
                border-radius: 15px;
                border: 2px solid #800000;
                cursor: pointer;
            }

            input[type=text] {
                color: #992600;
                padding: 12px;
                font-size: 12px;
                border-radius: 5px;
                border: 2px solid #800000;
                cursor: pointer;
            }

            body {
                font-family: Arial, Helvetica, sans-serif;
                background-color: #ffffcc;
            }
            
            footer {
                text-align: center;
                padding: 3px;
                background-color: #ff9933;
                color: white;
            }
        </style>
    </head>
    <body>
        <div id="header">
        <img src="images/starwarsImage.png" height="180" style="margin-left: 330px; margin-right: auto; width: 50%;">
        </div>
        <div id="main" style="width:100%; height:80%">
            <div class="col-sm-8" style="float:left; width:50%"> 
                <% 
                    int movieId=0;
                    try{
                        movieId = Integer.parseInt(request.getParameter("movie"));
                    }catch(Exception e){
                        out.println("You have selected an invalid option.");                       
                    }
                   MovieTableGateway movieGateway = new MovieTableGateway();
                   Movie movieDetails = movieGateway.findDetailsOfMovie(movieId);                   
                %>
                <h1> <%out.println("Title: " + movieDetails.getTitle());%> </h1>
                <div> <% out.println("Director: " + movieDetails.getDirector()); %> </div>
                <div> <% out.println("Producers: " + movieDetails.getProducers());%> </div>
                <div> <% out.println("Release Date: " + movieDetails.getReleaseDate());%> </div>
            </div>
            <div class="col-sm-8" style=" width:50%; float:left;"> 
                <br><br><h3>Characters: </h3>
            
                <% 
                   MoviePeopleAssociationGateway moviePeopleAssocGateway = new MoviePeopleAssociationGateway(); 
                   ArrayList<MoviePeopleAssociation> moviePeopleIds = moviePeopleAssocGateway.findCharactersOfMovie(movieId);
                   PeopleTableGateway peopleGateway = new PeopleTableGateway();
                   ArrayList<People> characterList = new ArrayList<>();
                   for(MoviePeopleAssociation mpRecord: moviePeopleIds) {
                        characterList.add(peopleGateway.findCharacterDetails(mpRecord.getMoviesPeople().get(1)));
                   }
                   for(People character: characterList){
                %>
                   <div><a href = "character.jsp?character=<% out.println(character.getPeopleId()); %>"> <%out.println(character.getName()); %></a> </div>
                   <% } %>
                   <br><br>
            </div>
            
        </div>
        <div style="clear:both;">
            <footer>
                <p> Creators: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)</p>
            </footer>
        </div>
    </body>
</html>
