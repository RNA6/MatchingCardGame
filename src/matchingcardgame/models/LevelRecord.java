/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame.models;

/**
 *
 * @author RNA
 */
public class LevelRecord {  
    private int savedLevelID;    
    private int levelNumber;  
    private int imageID;
    private String imagePath;
    private int cardNumber;

    public LevelRecord(int savedLevelID, int levelNumber, int imageID, String imagePath, int cardNumber) {
        this.savedLevelID = savedLevelID;
        this.levelNumber = levelNumber;
        this.imageID = imageID;
        this.imagePath = imagePath;
        this.cardNumber = cardNumber;
    }

    public int getSavedLevelID() {
        return savedLevelID;
    }

    public void setSavedLevelID(int savedLevelID) {
        this.savedLevelID = savedLevelID;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
}
