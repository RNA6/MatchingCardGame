/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame.models;

import java.util.Date;

/**
 *
 * @author RNA
 */
public class UserSavedLevel {
    private int savedLevelID;
    private int playerID;
    private int levelNumber;
    private Date savedDate;

    public UserSavedLevel(int savedLevelID, int playerID, int levelNumber, Date savedDate) {
        this.savedLevelID = savedLevelID;
        this.playerID = playerID;
        this.levelNumber = levelNumber;
        this.savedDate = savedDate;
    }

    public int getSavedLevelID() {
        return savedLevelID;
    }

    public void setSavedLevelID(int savedLevelID) {
        this.savedLevelID = savedLevelID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int PlayerID) {
        this.playerID = PlayerID;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Date getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(Date savedDate) {
        this.savedDate = savedDate;
    }
}
