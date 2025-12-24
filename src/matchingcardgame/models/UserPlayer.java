/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame.models;

/**
 *
 * @author RNA
 */
public class UserPlayer{
    private String username;
    private int playerID;
    private String password;
    private String gender;
    private String phoneNumber;
    private int isAdmin;
    private int totalScores;
    private int savedLevels;

    public UserPlayer(String username, int playerID, String password, String gender, String phoneNumber, int isAdmin, int totalScores, int savedLevels) {
        this.username = username;
        this.playerID = playerID;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        this.totalScores = totalScores;
        this.savedLevels = savedLevels;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getTotalScores() {
        return totalScores;
    }

    public void setTotalScores(int totalScores) {
        this.totalScores = totalScores;
    }

    public int getSavedLevels() {
        return savedLevels;
    }

    public void setSavedLevels(int savedLevels) {
        this.savedLevels = savedLevels;
    }   
    
}
