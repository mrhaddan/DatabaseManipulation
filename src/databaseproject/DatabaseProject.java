package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author nick
 */
public class DatabaseProject{

    static Connection conn;
    static String user, password;
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        System.out.println("###---Manage your database!---###");
        System.out.println("Log in to your database...");
        System.out.print("Enter username: ");
        user = scan.nextLine();
        System.out.print("Enter password: ");
        password = scan.nextLine();
        
        AddTable at = new AddTable(user, password);
        at.start();
        
        /*
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            
        }
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DemoDatabase", "Nick", "Astrwo1ot");
        if(conn.isValid(0)){
            System.out.println("Super Sexy");
        }
        Thread t = new Thread();
        t.run();
        */
        
    }

    private void begin() {
        System.out.println("Welcome!");
    }
    
}
