/*
* Authors: Sonam Sonam (40205470), Vikram Singh Brahm (40241024)
* This is Logger class which defines a Logger type to log the events happenning in application
* fileWriter: A FileWriter Object
* buffer: A BufferedWriter object
* This also defines a class variable instance which is the only instance which can be created for
* this class. This implements a singleton design pattern by having the full control of creating
* instances to itself. The outside world can ask for the instance by using getInstance() class
* method.
* log(..) method can be called on the obtained instance to log messages.
*/

package logger;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static Logger instance = null;
    private FileWriter fileWriter = null;
    private BufferedWriter buffer = null;
    
    private Logger() throws IOException{
        try {
            fileWriter = new FileWriter("logs.txt", true);
            buffer = new BufferedWriter(fileWriter);
        }
        catch(IOException e) {
            System.out.println("Error occurred.");
        }
    }
    
    public static Logger getInstance() throws IOException {
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String str) {
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now(); 
            buffer.write("[LOGS] [" +f.format(now) +"] " + str +"\n");
        }
        catch(IOException e) {
            
        }
        
    }
}
