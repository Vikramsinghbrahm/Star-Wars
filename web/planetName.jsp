<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,classes.*,tabledatagateways.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planet Details</title>
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
            <% String planetName = String.valueOf(request.getParameter("planet"));  
               PlanetTableGateway planetGateway = new PlanetTableGateway();
               Planet planet = planetGateway.findPlanetDetailsWithName(planetName);
            %>
                        <h1><%out.println(planet.getName());%></h1>
            
                <div><% out.println("Climate: " + planet.getClimate());%></div>
                <div><% out.println("Terrain: " + planet.getTerrain());%></div>
                <div><% out.println("Population: " + planet.getPopulation());%></div>
                
            </div>    
                
                <div class="col-sm-8" style="float:right; width:50%"> 
                <h1>It is the homeworld of: </h1>
            
                <% 
                   PeopleTableGateway peopleGateway = new PeopleTableGateway(); 
                   ArrayList<People> peopleList = peopleGateway.findCharsinPlanets(planet.getName());                   
                   for(People character : peopleList){
                %>
                   <div><a href = "character.jsp?character=<% out.println(character.getPeopleId()); %>"> <%out.println(character.getName()); %></a> </div>
                   <% 
                       } 
                   %>
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