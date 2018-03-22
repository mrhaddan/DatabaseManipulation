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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author nick
 * 
 */
public class AddTable implements Runnable{
    static Scanner scan = new Scanner(System.in);
    static String tableName;
    int cols;
    static Connection conn;
    Thread t;
    static Statement stmt;
    static StringBuilder sb = new StringBuilder();
    
    // Default Constructor
    public AddTable() throws SQLException{
        System.out.println("###---Add a table---###");
        sb.append("CREATE TABLE ");
        System.out.print("Enter Table Name: ");
        tableName = scan.nextLine();
        sb.append(tableName + " (id INT NOT NULL PRIMARY KEY");
        System.out.print("How many columns will the table have? ");
        cols = scan.nextInt();
        for (int i = 0; i < cols; i++) {
            System.out.print("Column Name: ");
            String s = scan.nextLine();
            sb.append(s + " ");
            
            System.out.print("Enter data type (VARCHAR(255), INT ): ");
            s = scan.nextLine();
            sb.append(s + ", ");
        }
        sb.append(");");
        
        System.out.println(sb.toString());
        //stmt.executeUpdate(sb.toString()); After I figure out scanner issue
    }
    
    @Override
    public void run() {
        System.out.println("Run method");
    }

    void start() {
        t = new Thread(this);
        t.start();
    }
}