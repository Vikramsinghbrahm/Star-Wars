/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is People Table Data Gateway class which creates a gateway between 
* People class and corresponding table in database.
* It does not have any state.
* It defines a bunch of find methods to run queries on the data and return the domain objects.
*/

package tabledatagateways;

import classes.People;
import logger.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PeopleTableGateway extends TableDataGateway  {
    public  PeopleTableGateway(String username,String password){
        super(username,password);
    }
    
    public  PeopleTableGateway() {
        super();
    }
    
    /*
    * This method returns the People object for the passed people id
    */
    
    public People findCharacterDetails(int peopleId) throws IOException {
        People peopleObj = new People();
        String q = "SELECT * FROM people WHERE people_id = "+ peopleId;
        Logger.getInstance().log("Query posed on people for details of character with people_id: "+ peopleId);
        try{            
            Connection con = TableDataGateway.connect(username, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(q);
            while(rs.next()){
                peopleObj.setPeopleId(peopleId);
                peopleObj.setName(rs.getString(2));
                peopleObj.setSpeciesId(rs.getInt(3));
                peopleObj.setHeight((rs.getString(4).equals("unknown")) ? 0 :Integer.parseInt(rs.getString(4)));
                peopleObj.setHomeWorld(rs.getInt(5));
                peopleObj.setBirthYear(rs.getString(6));
                peopleObj.setGender(rs.getString(7));
                peopleObj.setEyeColor(rs.getString(8));
                peopleObj.setHairColor(rs.getString(9));
                peopleObj.setSkinColor(rs.getString(10));
            }
            
        }
        catch(ClassNotFoundException | SQLException e){            
        }
       return peopleObj; 
    }
    
    /*
    * This method returns the list of all People objects which have the passed gender
    */
    
    public ArrayList<People> findCharsinMoviesByGenders(String gender) throws IOException{
        ArrayList<People> res=new ArrayList<>();
        try{       
            Logger.getInstance().log("Query posed on people for details of characters with gender: "+ gender);
            Connection con = TableDataGateway.connect(username, password);
            try(Statement stmt = con.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM people WHERE gender='"+gender+"'")){
                while(rs.next()){
                    People temp=new People(rs.getInt(1),rs.getString(2),rs.getInt(3),
                            rs.getInt(4),rs.getInt(5),rs.getString(6),
                            rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                    res.add(temp);
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        System.out.println(res);
        return res;
        
    }
    
    /*
    * This method returns the list of all People objects which have height greater than
    * the passed height
    */
    
    public ArrayList<People> findCharsinMoviesByHeight(int height) throws IOException{
        ArrayList<People> res=new ArrayList<>();
        try{
            Logger.getInstance().log("Query posed on people for details of characters with height > "+ height);
            Connection con = TableDataGateway.connect(username, password);
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM people WHERE height>"+height)) {
                while(rs.next()){
                    People temp=new People(rs.getInt(1),rs.getString(2),rs.getInt(3),
                            rs.getInt(4),rs.getInt(5),rs.getString(6),
                            rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                    if(temp.getHeight()>=1){
                        res.add(temp);
                    }
                    //Collections.sort(res,Comparator.comparing(PeopleRecord::getHeight));
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return res;
    }
    
    /*
    * This method returns the People object for the passed name
    */
    
    public People findCharacterDetailsWithName(String name) throws IOException {
        People peopleObj = new People();
        String q = "SELECT * FROM people WHERE name = '"+ name +"'";
        
        try{            
            Connection con=TableDataGateway.connect(username, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(q);
            while(rs.next()){
                peopleObj.setPeopleId(rs.getInt(1));
                peopleObj.setName(name);
                peopleObj.setSpeciesId(rs.getInt(3));
                peopleObj.setHeight(Integer.parseInt(rs.getString(4)));
                peopleObj.setHomeWorld(rs.getInt(5));
                peopleObj.setBirthYear(rs.getString(6));
                peopleObj.setGender(rs.getString(7));
                peopleObj.setEyeColor(rs.getString(8));
                peopleObj.setHairColor(rs.getString(9));
                peopleObj.setSkinColor(rs.getString(10));
            }
            
        }
        catch(ClassNotFoundException | SQLException e){            
        }
       return peopleObj; 
    }
    
    /*
    * This method returns the list of all People objects which belong to passed planet
    */
    public  ArrayList<People> findCharsinPlanets(String planet) throws IOException{
        ArrayList<People> res=new ArrayList<>();
        String query = "SELECT * FROM people INNER JOIN planets ON home_world = planet_id WHERE planets.name='"+planet+"'";
        try{
            Connection con = TableDataGateway.connect(username, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                People temp=new People(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                res.add(temp);
            }
        }
        catch(ClassNotFoundException | SQLException e){ }
        return res;
    }
}