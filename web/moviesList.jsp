<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,java.text.SimpleDateFormat,java.util.Date,classes.*,tabledatagateways.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies List</title>
        <style>
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
            <h1 style="margin-left: 50%;">Movies List</h1>
            <div style="width:50%; margin-left: 50%;">
                <% 
                String date = request.getParameter("Date");
                if(date.equals("")){
                    date = "2020-10-10";
                    }
                Date d = new SimpleDateFormat("yyyy-mm-dd").parse(date);
                java.sql.Date dt = new java.sql.Date(d.getTime());
                MovieTableGateway movieTableGateway = new MovieTableGateway();
                ArrayList<Movie> movies = movieTableGateway.findMoviesReleasedAfter(dt);
                
                for(Movie mov: movies){%>
                <a href = "movie.jsp?movie=<% out.println(mov.getMovieId()); %>"> <%out.println(mov.getTitle()); %></a><br/>
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
