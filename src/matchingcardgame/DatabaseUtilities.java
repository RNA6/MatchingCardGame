/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import matchingcardgame.models.User;
import matchingcardgame.models.Player;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import matchingcardgame.models.LevelRecord;
import matchingcardgame.models.UserPlayer;
import matchingcardgame.models.UserSavedLevel;

/**
 *
 * @author RNA
 */
public class DatabaseUtilities {
    private static Connection connection;
    private static PreparedStatement loginStatement;
    private static ResultSet resultSet;

    private static final String db_url = "jdbc:mysql://localhost:3306/MatchingCardGame?serverTimezone=UTC";
    private static final String db_username = "root";
    private static final String db_password = "#";
    
    static{
        try {
            connection = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean userInfoExists(String username, String password){
        try {
            String sql="SELECT username,password, isAdmin FROM users WHERE username =? AND password = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(resultset.next()){
                Frames.signIn.setIsAdmin(resultset.getInt("isAdmin"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static User getUserInfo(String username, String password, int isAdmin){
        String query = "Select * FROM users WHERE username = ? AND password = ? AND isAdmin = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, isAdmin);
            
            ResultSet result = preparedStatement.executeQuery();            
            int playerID;
            String phoneNumber;
            String gender;
            User signedIn_user;
            
            if(result.next()){
                playerID = result.getInt("playerID");
                phoneNumber = result.getString("phoneNumber");
                gender = result.getString("gender");
                signedIn_user = new User(username, playerID, password, gender, phoneNumber, isAdmin);
                return signedIn_user;
            
            }else{
                System.out.println("User not found");
                return null;
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Player getUserPlayerInfo(String username, String password, int isAdmin){
        String query = "Select p.playerID, p.totalScores FROM users u JOIN players p ON u.playerID = p.playerID WHERE username = ? AND password = ? AND isAdmin = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, isAdmin);
            
            ResultSet result = preparedStatement.executeQuery();  
            int playerID;
            int totalScores;
            Player player;
            
            if(result.next()){
                playerID = result.getInt("playedID");
                totalScores = result.getInt("totalScores");
                player = new Player(playerID, totalScores);
                
                System.out.println("Data successfully updated");
                return player;
            
            }else{
                System.out.println("User not found");
                return null;
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Player getPlayerInfo(){
        String query = "Select playerID, totalScores FROM players";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                        
            ResultSet result = preparedStatement.executeQuery();  
            int playerID;
            int totalScores;
            Player player;
            
            if(result.last()){
                playerID = result.getInt("playerID");
                totalScores = result.getInt("totalScores");
                player = new Player(playerID, totalScores);
                
                return player;
            
            }else{
                System.out.println("User not found");
                return null;
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void createPlayer(){
        String query = "INSERT INTO players () VALUES ();";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateUserInfo(User signedIn_user){
        String query = "UPDATE users SET username = ?, phoneNumber = ?, password = ?, gender = ? WHERE playerID =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, signedIn_user.getUsername());
            preparedStatement.setString(2, signedIn_user.getPhoneNumber());
            preparedStatement.setString(3, signedIn_user.getPassword());
            
            preparedStatement.setString(4, String.valueOf(signedIn_user.getGender()));
            preparedStatement.setInt(5, signedIn_user.getPlayerID());
            preparedStatement.executeUpdate();
            System.out.println("Data successfully updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<UserPlayer> loadTop5Users() {
        String sql =
            "SELECT * " +
            "FROM players p " +
            "JOIN users u ON p.playerID = u.playerID " +
            "ORDER BY p.totalScores DESC " +
            "LIMIT 5";
        ArrayList<UserPlayer> userPlayers = new ArrayList();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                int playerID = rs.getInt("playerID");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                int isAdmin = rs.getInt("isAdmin");
                int totalScores = rs.getInt("totalScores");
                
                userPlayers.add(new UserPlayer(username,playerID,password, gender,phoneNumber,isAdmin, totalScores, 0));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userPlayers;
    }
    
    public static ArrayList<UserPlayer> loadUsers() {
        String sql =
            "SELECT *, COUNT(p.playerID) savedlevels "
                + "FROM users u "
                + "JOIN players p on p.playerID = u.playerID "
                + "LEFT JOIN savedlevels s on p.playerID = s.playerID "
                + "GROUP BY p.playerID;";
        ArrayList<UserPlayer> userPlayers = new ArrayList();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                int playerID = rs.getInt("playerID");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                int isAdmin = rs.getInt("isAdmin");
                int totalScores = rs.getInt("totalScores");
                int savedLevels = rs.getInt("savedLevels");
                
                userPlayers.add(new UserPlayer(username,playerID,password, gender,phoneNumber,isAdmin, totalScores, savedLevels));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userPlayers;
    }
    
    public static ArrayList<UserSavedLevel> loadUserSavedLevels(int playerID) {
        String sql =
            "SELECT s.* "
                + "FROM users u "
                + "JOIN players p ON p.playerID = u.playerID "
                + "JOIN savedlevels s ON p.playerID = s.playerID "
                + "WHERE p.playerID = ?;";
        ArrayList<UserSavedLevel> userSavedLevels = new ArrayList();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, playerID);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int savedLevelID = rs.getInt("savedLevelID");
                int levelNumber = rs.getInt("levelNumber");
                Date savedDate = rs.getDate("savedDate");
                
                userSavedLevels.add(new UserSavedLevel(savedLevelID, playerID, levelNumber, savedDate));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userSavedLevels;
    }
    public static ArrayList<LevelRecord> loadSavedLevel(int savedLevelID) {
        String sql =
            "SELECT s.levelNumber, r.*, i.path "
                + "FROM savedlevelsrecords r "
                + "JOIN savedlevels s ON r.savedLevelID = s.savedLevelID "
                + "JOIN images i ON r.imageID = i.imageID "
                + "WHERE r.savedLevelID = ? "
                + "ORDER BY cardNumber ASC;";
        ArrayList<LevelRecord> levelRecord = new ArrayList();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, savedLevelID);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int levelNumber = rs.getInt("levelNumber");
                int imageID = rs.getInt("imageID");
                String imagePath = rs.getString("path");
                int cardNumber = rs.getInt("cardNumber");
                
                levelRecord.add(new LevelRecord(savedLevelID, levelNumber, imageID, imagePath, cardNumber));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return levelRecord;
    }
   
    public static void saveGameData(int playerId, int levelNum, int timeLeft, int score, int stars) {
        
        String query = "INSERT INTO levelscore (playerid, levelnumber, timeleft, score, stars) VALUES (?, ?, ?, ?, ?)";

        // Using a background thread so the game window doesn't "freeze" while saving
        new Thread(() -> {
            try (
                 PreparedStatement pstmt = connection.prepareStatement(query)) {

                pstmt.setInt(1, playerId);
                pstmt.setInt(2, levelNum);
                pstmt.setInt(3, timeLeft);
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

    try (
            PreparedStatement pstmt = connection.prepareStatement(query)) {

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
    public static void saveCurrentLevel(int playerID, int levelNumber, ArrayList<Integer> imagesIndexes) {
        new Thread(() -> {
            String insertSavedLevelSQL = "INSERT INTO savedlevels (playerID, levelNumber, savedDate) VALUES (?, ?, CURDATE())";
            String insertRecordSQL = "INSERT INTO savedlevelsrecords (savedLevelID, imageID, cardNumber) VALUES (?, ?, ?)";
            try {
                connection.setAutoCommit(false);
                
                try (PreparedStatement ps = connection.prepareStatement(insertSavedLevelSQL, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, playerID);
                    ps.setInt(2, levelNumber);
                    ps.executeUpdate();
                    ResultSet keys = ps.getGeneratedKeys();
                    if (!keys.next()) {
                        throw new SQLException("Failed to retrieve savedLevelID.");
                    }
                    int savedLevelID = keys.getInt(1);
                    
                    try (PreparedStatement ps2 = connection.prepareStatement(insertRecordSQL)) {
                        for (int i = 0; i < imagesIndexes.size(); i++) {
                            int imageIndexZeroBased = imagesIndexes.get(i);
                            int imageID = imageIndexZeroBased + 1;
                            int cardNumber = i + 1;

                            ps2.setInt(1, savedLevelID);
                            ps2.setInt(2, imageID);
                            ps2.setInt(3, cardNumber);
                            ps2.addBatch();
                        }
                        ps2.executeBatch();
                    }
                }

                connection.commit();
                System.out.println("Saved level successfully (savedLevel created).");
            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ex.printStackTrace();
                System.err.println("Failed to save level: " + ex.getMessage());
            } finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
