/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thirdtrainticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DatabaseConnection {
     public static Connection connect() {

        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/trainstation";
            String user = "root";
            String password = "eduv4810703@lilithabuhlungu2";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}
