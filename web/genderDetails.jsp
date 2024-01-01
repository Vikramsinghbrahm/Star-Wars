
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="classes.*,tabledatagateways.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gender wise Character Names</title>
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
            <% String gender = String.valueOf(request.getParameter("gender"));  %>
            <h1 style="margin-left: 30%;">Characters which are <%= gender %>  </h1>
            <div style="width:50%; margin-left: 50%;">
                <% 
                PeopleTableGateway peopleGateway = new PeopleTableGateway();
                ArrayList<People> list = peopleGateway.findCharsinMoviesByGenders(gender);
                for(People character:list){%>
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
