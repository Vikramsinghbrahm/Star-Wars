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

public class SpeciesTable {
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars","root","mysqlpwd@1234");
        try{
            for(int i=1; i<90; i++){   
                URL url = new URL("https://swapi.dev/api/species/"+ i + "/?format=json" );   
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
                    
                    String name = data.get("name").toString();
                    name = name.replaceAll("'", "");
                    int speciesId = Integer.parseInt(data.get("url").toString().replaceAll("[^0-9]",""));
                    String classification = data.get("classification").toString();
                    String language = data.get("language").toString();
                    language = language.replaceAll("'","");
                    String designation = data.get("designation").toString();
                    int homeWorld = (data.get("homeworld") == null ? 0 : Integer.parseInt(data.get("homeworld").toString().replaceAll("[^0-9]", "")));
                    
                    String q = "insert into species values (" + speciesId+ ", '" +classification+ "', '" +language+
                            "', '" +designation+ "'," +homeWorld+ ", '" +name+ "')";
                    PreparedStatement insertIntoSpecies = con.prepareStatement(q);
                    insertIntoSpecies.execute();
                }
            }
        }
        
        catch(IOException | NumberFormatException | ParseException e){}
    }
    
}