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

public class MovieTable {

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

                URL url = new URL("https://swapi.dev/api/films/"+ i + "/?format=json" );   
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
                    
                    int film_id = Integer.parseInt(data.get("url").toString().replaceAll("[^0-9]", ""));
                    String title = data.get("title").toString();
                    String director = data.get("director").toString();
                    String producers = data.get("producer").toString();
                    String releaseDate = data.get("release_date").toString();
                    String query = "insert into movies values (" +film_id+ ", '" +title+ "', '" +producers+ "', '" +director+ "', '" +releaseDate+ "')";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.execute();  
                        
                    String people = String.valueOf(data.get("characters"));
                    String[] chars=people.split(",");
                    for(int j = 0; j<chars.length; j++) {
                        chars[j] = chars[j].replaceAll("[^0-9]" ,"");
                        int characterId = Integer.parseInt(chars[j]);
                        String q = "insert into movie_people values ("+ film_id + "," + characterId + ")";
                        PreparedStatement insertIntoMoviePeople = con.prepareStatement(q);
                        insertIntoMoviePeople.execute(); 
                    }            
               }
            
            }
        } catch (IOException | NumberFormatException | ParseException e) {
        }
    }
    
}
