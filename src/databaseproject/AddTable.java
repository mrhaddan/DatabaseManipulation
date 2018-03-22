/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author nick
 * 
 */
public class AddTable implements Runnable{

    static String user, password, tableName;
    int cols;
    static Connection conn;
    Thread t;
    static Statement stmt;
    
    // Default Constructor
    public AddTable(String user, String pass){
        this.user = user;
        this.password = pass;
        System.out.print("Enter Table Name: ");
        tableName = DatabaseProject.scan.nextLine();
        connectToDatabase();
        System.out.println("###---Add a table---###");
    }
    
    @Override
    public void run() {
        System.out.println("Run method");
    }

    void start() {
        t = new Thread(this);
        t.start();
    }

    private void connectToDatabase() {
        try{
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DemoDatabase", user, password);
            if(conn.isValid(0)){
                System.out.println("Successfully connected to database");
                conn.close();
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
