# Starwars

Creators: Sonam Sonam, Vikram Singh Brahm

This is a JSP website project which provides details about Star Wars movies and characters. There are details about planets and species as well. 
There is an API called SWAPI which provides information about Star wars in JSON format. The parser then parses this JSON and puts data in relational Model.
The application represents this data in Object model. 
There are gateway classes (Table Data Gateways) which work as an intermediary between application and relational model.
The application classes get data from databases through table data gateways.
The table data gateways encapsulate SQL queries to separate the access to database from main application logic.
There is a logger class which logs the events into a log file. This file implements Singleton design pattern.
