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
        getConnection();
        /**
         * System.out.println("What would you like to do?");
         * System.out.println("1. Add Table\n2. Add to Table\n3. ");
         * String userInput = scan.nextLine();
         * switch(userInput.toUpperCase()){
            case "Y":
                break;
            case "N":
                break;
        }
         */
        
        AddTable at = new AddTable();
        at.start();        
    }

    private static void getConnection() {
        try{
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DemoDatabase", user, password);
        if(conn.isValid(0)){
            System.out.println("Succesfully Connected");
        }
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }

       
}