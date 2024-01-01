<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,classes.*,tabledatagateways.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Character Details</title>
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
        <div id="main" style="width:100%">
            <div class="col-sm-8" style="float:left; width:50%"> 
                <% int characterId = Integer.parseInt(request.getParameter("character")); 
                   PeopleTableGateway peopleGateway = new PeopleTableGateway();
                   People character = peopleGateway.findCharacterDetails(characterId);
                    %>

                <h1><% out.println(character.getName());  %></h1>
                <div><% out.println("Gender: "+character.getGender());  %></div>
                <div><% out.println("Height: "+character.getHeight());  %></div>
                <div><% out.println("Birth Year: "+character.getBirthYear());  %></div>
                <div><% out.println("Eye Color: "+character.getEyeColor());  %></div>
                <div><% out.println("Hair Color: "+character.getHairColor());  %></div>
                <div><% out.println("Skin Color: "+character.getSkinColor());  %></div>
                

                <% SpeciesTableGateway speciesGateway = new SpeciesTableGateway(); %>
                <div>Species Name: <a href = "species.jsp?species=<% out.println(character.getSpeciesId()); %>"><% out.println((speciesGateway.findSpeciesDetails(character.getSpeciesId()).getName()) == "" ? "Unknown" : speciesGateway.findSpeciesDetails(character.getSpeciesId()).getName());  %></a></div>

                <% PlanetTableGateway planetGateway = new PlanetTableGateway(); %>
                <div>Home World Name: <a href = "planet.jsp?planet=<% out.println(character.getHomeWorld()); %>"><% out.println((planetGateway.findPlanetDetails(character.getHomeWorld()).getName()) == "" ? "Unknown" : planetGateway.findPlanetDetails(character.getHomeWorld()).getName());  %></a></div>
                <br><br>
            </div>
            <div class="col-sm-8" style="float:left; width:50%"> 
                <h1> Movies appeared in:</h1> 
                <%
                MoviePeopleAssociationGateway moviePeopleAssocGateway = new MoviePeopleAssociationGateway();
                ArrayList<MoviePeopleAssociation> moviePeopleIDs = moviePeopleAssocGateway.findMoviesOfCharacter(character.getPeopleId());
                MovieTableGateway movieGateway = new MovieTableGateway();
                for(MoviePeopleAssociation m:moviePeopleIDs){
                    Movie movie = movieGateway.findDetailsOfMovie(m.getMoviesPeople().get(0));
                %>
                <div><a href = "movie.jsp?movie=<% out.println(movie.getMovieId()); %>"> <%out.println(movie.getTitle()); %></a> </div>
                <% } %>
                
            </div>
        </div>
        <div style="clear:both;">
            <footer>
                <p> Creators: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)</p>
            </footer>
        </div>
    </body>
</html>
