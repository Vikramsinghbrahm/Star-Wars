package parse;

import java.io.IOException;
import java.sql.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class PeopleTable {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        
       Class.forName("com.mysql.jdbc.Driver"); 
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars","root","mysqlpwd@1234");
       try {
            for(int i=1; i<90; i++){                
                URL url = new URL("https://swapi.dev/api/people/"+i+"/?format=json");    
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int responseCode = conn.getResponseCode();
                if (responseCode == 200){
                    StringBuilder informationString = new StringBuilder();
                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        informationString.append(scanner.nextLine());
                    }                    
                    scanner.close();
                    JSONParser parser = new JSONParser();
                    Object obj  = parser.parse(informationString.toString());
                    JSONArray array = new JSONArray();
                    array.add(obj);
                    JSONObject data=(JSONObject) array.get(0);
                                      
                    int peopleId = Integer.parseInt(data.get("url").toString().replaceAll("[^0-9]", "")); 
                    String name = data.getOrDefault("name","").toString();                  
                    String speciesString = data.get("species").toString().replaceAll("[^0-9]","");
                    int species = ("".equals(speciesString) ? 0 : Integer.parseInt(speciesString));  
                    String height = data.getOrDefault("height","").toString();
                    int homeWorld = Integer.parseInt(data.get("homeworld").toString().replaceAll("[^0-9]", ""));
                    String birthYear = data.getOrDefault("birth_year","").toString();
                    String gender = data.getOrDefault("gender","").toString();
                    String eyeColor = data.getOrDefault("eye_color","").toString();
                    String hairColor = data.getOrDefault("hair_color","").toString();
                    String skinColor=data.getOrDefault("skin_color","").toString();
                    
                    String query = "insert into people values (" +peopleId+ ", '" +name+ "', '" +species+ 
                            "', '" +height+ "', " +homeWorld+ ", '" +birthYear+ "', '" +gender+ "', '" +eyeColor+
                            "', '" +hairColor+ "', '" +skinColor+ "')";        
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.execute();               
               }
            
            }
        } catch (IOException | NumberFormatException | ParseException e) {
        }
    }
    
}
