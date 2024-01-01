# Star Wars 

## Project Overview

This Java-based project focuses on developing a comprehensive system that leverages the SWAPI (Star Wars API) to gather information about Star Wars movies, characters, planets, and species. The project involves parsing the API's JSON data and storing it in a MySQL relational database using MySQL Workbench. The application, built with Java, utilizes Java Server Pages (JSP) and HTML for the front-end to present data to end-users.

### Technologies Used

- **API**: [SWAPI](https://swapi.dev/)
- **Back-end**: MySQL Workbench
- **Application Language**: Java
- **Front-end**: Java Server Pages & HTML
- **Testing Framework**: JUnit

## API Details

The project captures data from SWAPI API and stores it in a relational model for the following entities:

- **Characters/People**
- **Movies**
- **Planets**
- **Species**

For simplicity, the project focuses on a subset of data from the SWAPI.

## Patterns Overview

### Structural Patterns

#### 1. Simple Mapping with Identity Field

- Each class corresponds to a table in the relational model.
- An Identity field is included in each table for unique identification.

#### 2. Association Table Mapping

- Implemented for many-to-many relationships, e.g., between People and Movies.

### Data Source Architectural Patterns

#### 1. Table Data Gateway

- Utilized to separate application logic from database access.
- Each class has its own Table Data Gateway (TDG) for interaction with the database.

### Design Patterns

#### 1. Singleton

- Implemented for the Logger class to facilitate centralized event logging.

## Patterns in Detail

### Structural Patterns

#### 1. Simple Mapping with Identity Field

- Each class corresponds to a table in the relational model.
- Identity field facilitates primary key and foreign key relationships.

#### 2. Association Table Mapping

- An association class, `MoviePeopleAssociation`, is introduced for many-to-many relationships between People and Movies.

### Data Source Architectural Patterns

#### 1. Table Data Gateway

- A TDG is employed for each class to encapsulate database queries.
- All TDGs extend a base class, `TableDataGateway`, with common functionality.

### Design Patterns

#### 1. Singleton

- Implemented for the Logger class to ensure a single instance for event logging.

## Object Model

- Application Classes: Logger, Table Data Gateways

## Relational Model

### People Table

- Columns: people_id, name, species, height, home_world, birth_year, gender, eye_color, hair_color, skin_color

### Movies Table

- Columns: movie_id, title, producers, director, release_date

### Movie_People Table

- Columns: movie_id, people_id

### Planets Table

- Columns: planet_id, name, climate, terrain, population

### Species Table

- Columns: species_id, classification, language, designation, home_world, name

## ER Diagram

[Include ER Diagram here]

## Refactoring Strategies

### 1. Composing Methods (Extract Method)

- A separate method, `connect`, is extracted to handle database connections.

### 2. Simplifying Method Calls (Parameterize Methods)

- Redundant methods are removed, and common functionality is consolidated.

### 3. Generalization (Extract Superclass)

- A base class, `TableDataGateway`, is introduced to accommodate common functionality.

### 4. Generalization (Pull Up Method)

- The common `connect` method is pulled up to the base class.

### 5. Generalization (Pull Up Constructor Body)

- Constructor bodies are pulled up to the base class.

## Coding Standards as per Java

1. Class names start with a capital letter.
2. Package names start with a lowercase letter.
3. Descriptive names for variables, functions, and identifiers following camel case.
4. Header comments explaining class functionality and author details.
5. Code commenting where necessary for clarity.
6. Proper error handling to avoid unexpected results.
7. Consistent code format and indentation for readability.

## Testing Technique

### Framework: JUnit

- A total of 14 unit tests cover each method's functionality.
- All tests pass successfully.


## Contributors

- Sonam Sonam
- Vikram Singh Brahm

Feel free to explore the project and contribute!


