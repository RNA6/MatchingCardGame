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

      static  String db_url = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC";
       static String db_username = "root";
        static String db_password = "#";
    
    public DatabaseUtilities() {
        
        try {
            connection = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    public static void saveGameData(int playerId, int levelNum, String timeLeft, int score, int stars) {
        
        String query = "INSERT INTO levelscore (playerid, levelnumber, timeleft, score, star) VALUES (?, ?, ?, ?, ?)";

        // Using a background thread so the game window doesn't "freeze" while saving
        new Thread(() -> {
            try (Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, playerId);
                pstmt.setInt(2, levelNum);
                pstmt.setString(3, timeLeft);
                pstmt.setInt(4, score);
                pstmt.setInt(5, stars);

                pstmt.executeUpdate();
                System.out.println("Data successfully saved to levelscore!");

            } catch (SQLException e) {
                System.err.println("Database connection error: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }
    
    
    public static String getPlayerScoreData(int playerId) {
    String result = "";
   
    String query = "SELECT levelnumber, score, star FROM levelscore WHERE playerid = ? ORDER BY id DESC LIMIT 1";

    try (Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, playerId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int level = rs.getInt("levelnumber");
            int score = rs.getInt("score");
            int stars = rs.getInt("star");
            
            
            result = "Level: " + level + " | Score: " + score + " | Stars: " + stars;
        } else {
            result = "No data found for this player.";
        }

    } catch (SQLException e) {
        e.printStackTrace();
        result = "Error loading score.";
    }
    return result;
}
}
