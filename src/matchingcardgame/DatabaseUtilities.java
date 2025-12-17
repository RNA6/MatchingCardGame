/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RNA
 */
public class DatabaseUtilities {
    private Connection connection;
    private PreparedStatement loginStatement;
    private ResultSet resultSet;

    public DatabaseUtilities() {
        String db_url = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC";
        String db_username = "root";
        String db_password = "#";
        try {
            connection = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
