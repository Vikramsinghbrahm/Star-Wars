<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,classes.*,tabledatagateways.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Star wars website</title>
<style>    
    select {
        height: 30px;
	background: #992600;
        border-radius: 5px;
	border: 1px solid black;
        font-family: Arial, Helvetica, sans-serif;
        color: #fff;
        margin: 0;
	padding: 0 0 0 .5em;
	cursor: pointer;
	}
	
	.select {
	position: relative;
	display: block;
	background: #2C3E50;
	}
	
	select::-ms-expand {
	display: none;
	}
	
	.select::after {
	content: '\25BC';
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	padding: 0 1em;
	background: #34495E;
	pointer-events: none;
	}
	
	.select:hover::after {
            color: #F39C12;
	}
	
	<!-- For different browsers -->
        .select::after {
            -webkit-transition: .25s all ease;
            -o-transition: .25s all ease;
            transition: .25s all ease;
	}
    
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
            <h3> Please select a movie to find more about it: </h3>
            <form action="movie.jsp" method = "POST">       
                <select name="movie">
                    <option selected disabled>-- Select --</option>
                    <%
                    MovieTableGateway moviesGateway = new MovieTableGateway();
                    ArrayList<Movie> movies = moviesGateway.findAllMovies();
                    for(Movie movie: movies){                            
                    %>
                    <option value="<%= movie.getMovieId() %>"><%= movie.getTitle() %></option>
                    <% 
                        }
                    %>
                </select>
                <input type="submit" value="OK"/>
            </form>
        </div>
        <div class="col-sm-8" style="float:left; width:50%">    
            <h3> To find characters greater than a given height, enter height in centimeters:</h3>
            <form action="greaterThanHeight.jsp" method = "POST">    
                <input type="text" id="height" name="height">
                <input type="submit" value="OK"/>
            </form>
        </div>

        <div class="col-sm-8" style="float:left; width:50%"> 
            <h3>Please select gender of the characters you want to view:</h3>
            <form action="genderDetails.jsp" method="POST"> 
            <select name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="hermaphrodite">Hermaphrodite</option>
            </select>
            <input type="submit" value="OK"/>
            </form>
        </div>
                
        <div class="col-sm-8" style="float:left; width:50%"> 
            <h3> Please enter character name to find out more: </h3>
            <form action="characterName.jsp" method = "POST">  
            <input type="text" id="character" name="character">
            <input type="submit" value="OK"/>
            </form>
        </div>

        <div class="col-sm-8" style="float:left; width:50%">  
            <h3> Select Planet Name to get the details of a planet:</h3>
            <form action="planetName.jsp" method = "POST"> 
            <select name = "planet">
            <%
                PlanetTableGateway planetGateway = new PlanetTableGateway();
                ArrayList<Planet> planets = planetGateway.findAll();
                for(Planet planet:planets){
            %>
            <option value="<%= planet.getName() %>"><%= planet.getName() %></option>
            <% 
                } 
            %>
            </select>
            <input type="submit" value="OK"/>
            </form>
        </div>
            
            <div class="col-sm-8" style="float:left; width:50%">  
            <h3> Select a date to find movies released after it:</h3>
            <form action="moviesList.jsp" method = "POST"> 
                <input type="date" name="Date">
            
            <input type="submit" value="OK"/>
            </form>
        </div>

    </div>
    <div style="clear:both;">
        <footer>
            <p> Creators: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)</p>
        </footer>
    </div>
    
</body>
</html> 