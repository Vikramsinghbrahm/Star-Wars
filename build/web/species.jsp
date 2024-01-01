<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*,tabledatagateways.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Species Details</title>
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
        <div id="main" style="width:100%;">
            <% int speciesId = Integer.parseInt(request.getParameter("species"));  
               SpeciesTableGateway speciesGateway = new SpeciesTableGateway();
               Species specie = speciesGateway.findSpeciesDetails(speciesId);
            %>
            <h1 style="margin-left: 50%;"><%out.println(specie.getName());%></h1>
            <div style="width:50%; margin-left: 50%;">
                <div><% out.println("Clasification: " + specie.getClassification());%></div>
                <div><% out.println("Language: " + specie.getLanguage());%></div>
                <div><% out.println("Designation: " + specie.getDesignation());%></div>

                <% PlanetTableGateway planetGateway = new PlanetTableGateway(); %>
                <div>Home World Name: <a href = "planet.jsp?planet=<% out.println(specie.getHomeworld()); %>"><% out.println((planetGateway.findPlanetDetails(specie.getHomeworld()).getName()) == "" ? "Unknown" : planetGateway.findPlanetDetails(specie.getHomeworld()).getName());  %></a></div>
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
