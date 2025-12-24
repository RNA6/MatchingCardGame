/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author RNA
 */
public class UIUtilities {

    public static void addNavigation(JButton button, BaseFrame originalFrame, BaseFrame nextFrame) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(nextFrame != null){
                    if(nextFrame.getClass() == HomePage.class){
                        if(originalFrame.getClass() == WelcomePage.class){
                            Frames.homePage.getBack_button().setVisible(true);
                            Frames.homePage.getSavedLevels_button().setVisible(false);
                            Frames.homePage.getUserIcon_label().setVisible(false);
                            Frames.easyLevels.getUserIcon_label().setVisible(false);
                            Frames.normalLevels.getUserIcon_label().setVisible(false);
                            Frames.hardLevels.getUserIcon_label().setVisible(false);
                            
                            
                        }
                        Level level;
                        for(int levelNumber=1; levelNumber<=15; levelNumber++){
                            if(levelNumber >=1 && levelNumber<=5){
                                level = Frames.easyLevel[levelNumber-1];
                            }
                            else if(levelNumber >=6 && levelNumber<=10){ 
                                level = Frames.normalLevel[levelNumber-6];
                            }
                            else{
                                level = Frames.hardLevel[levelNumber-11];
                            }
                            level.getSaveLevelButton().setVisible(false);
                        }
                        DatabaseUtilities.createPlayer();
                        Frames.homePage.setPlayer(DatabaseUtilities.getPlayerInfo());
                                                
                    }
                    
                    if(nextFrame.getClass() == UserInfo.class){
                        UserInfo userInfo = (UserInfo)nextFrame;
                        if(Frames.homePage.isVisible() ||
                           Frames.easyLevels.isVisible() ||
                           Frames.normalLevels.isVisible() ||
                           Frames.hardLevels.isVisible()){
                           userInfo.setSignedIn_user(Frames.homePage.getSignedIn_user()); 
                        }
                        else{
                            userInfo.setSignedIn_user(Frames.administrationsDashboard.getSignedIn_user());
                        }
                        userInfo.displayUserInfo();
                        
                    }
                    
                    if(nextFrame.getClass() == Level.class){
                        Level level = (Level)nextFrame;
                        level.startLevel();
                    }
                    
                    if(nextFrame.getClass() == WelcomePage.class){
                        if(Frames.homePage.isVisible() ||
                           Frames.easyLevels.isVisible() ||
                           Frames.normalLevels.isVisible() ||
                           Frames.hardLevels.isVisible()){
                            Frames.homePage.setSignedIn_user(null);                            
                            Frames.savedLevels.setSignedIn_user(null);
                        }
                        else{
                            Frames.administrationsDashboard.setSignedIn_user(null);
                        }
                    }
                    
                    if(nextFrame.getClass() == ViewUsersList.class){
                        ViewUsersList viewUsersList = (ViewUsersList)nextFrame;
                        viewUsersList.displayUsersList();
                    }
                    if(nextFrame.getClass() == ViewTop5Users.class){
                        ViewTop5Users viewTop5Users = (ViewTop5Users)nextFrame;
                        viewTop5Users.displayUsersList();
                    }
                    if(nextFrame.getClass() == SavedLevels.class){
                        SavedLevels savedLevels = (SavedLevels)nextFrame;
                        savedLevels.displaySavedLevelsList();
                    }
                }
                
                if(originalFrame.getClass() == Level.class){
                    Level level = (Level)originalFrame;
                    level.getGameTimer().stop();
                }                              
                
                if(originalFrame.getClass() == SignIn.class && nextFrame == null){
                    Frames.homePage.getBack_button().setVisible(false);
                    Frames.homePage.getUserIcon_label().setVisible(true);
                            Frames.homePage.getSavedLevels_button().setVisible(true);
                    Frames.easyLevels.getUserIcon_label().setVisible(true);
                    Frames.normalLevels.getUserIcon_label().setVisible(true);
                    Frames.hardLevels.getUserIcon_label().setVisible(true);
                    
                    Level level;
                        for(int levelNumber=1; levelNumber<=15; levelNumber++){
                            if(levelNumber >=1 && levelNumber<=5){
                                level = Frames.easyLevel[levelNumber-1];
                            }
                            else if(levelNumber >=6 && levelNumber<=10){ 
                                level = Frames.normalLevel[levelNumber-6];
                            }
                            else{
                                level = Frames.hardLevel[levelNumber-11];
                            }
                            level.getSaveLevelButton().setVisible(true);
                        }
                    return;
                }
                
                originalFrame.dispose();
                
                if(originalFrame.getClass() == WinLose.class && nextFrame == null){
                    int levelNumber = Frames.winLose.getPreviousLevel().getLevelNumber();
                    if(e.getSource() == Frames.winLose.getTryAgain_button()){
                        Level level;
                        if(levelNumber >=1 && levelNumber<=5){
                                level = Frames.easyLevel[levelNumber-1];
                            }
                            else if(levelNumber >=6 && levelNumber<=10){ 
                                level = Frames.normalLevel[levelNumber-6];
                            }
                            else{
                                level = Frames.hardLevel[levelNumber-11];
                            }
                            level.startLevel();
                            level.setVisible(true);
                    }
                    else{
                        int nextLevelNumber = levelNumber + 1;
                        Level levelnextFrame;
                        if(nextLevelNumber >=1 && nextLevelNumber<=15){
                            if(nextLevelNumber >=1 && nextLevelNumber<=5){
                                levelnextFrame = Frames.easyLevel[nextLevelNumber-1];
                            }
                            else if(nextLevelNumber >=6 && nextLevelNumber<=10){ 
                                levelnextFrame = Frames.normalLevel[nextLevelNumber-6];
                            }
                            else{
                                levelnextFrame = Frames.hardLevel[nextLevelNumber-11];
                            }
                            levelnextFrame.startLevel();
                            levelnextFrame.setVisible(true);
                        }
                        else
                        {
                            Frames.homePage.setVisible(true);
                        }
                    }
                    return;
                }
                
                nextFrame.setVisible(true);
            }
        });
    }
    
}
