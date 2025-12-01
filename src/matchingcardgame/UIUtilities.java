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
                            Frames.homePage.getUserIcon_label().setVisible(false);
                            Frames.easyLevels.getUserIcon_label().setVisible(false);
                            Frames.normalLevels.getUserIcon_label().setVisible(false);
                            Frames.hardLevels.getUserIcon_label().setVisible(false);
                        }
                    }
                    
                    if(nextFrame.getClass() == Level.class){
                        Level level = (Level)nextFrame;
                        level.startLevel();
                    }
                }
                
                if(originalFrame.getClass() == SignIn.class && nextFrame.getClass() == HomePage.class){
                    SignIn signIn = (SignIn)originalFrame;
                    if(!signIn.userInfoExists()){
                        signIn.handleSignIn();
                        return;
                    }
                }
                
                if(originalFrame.getClass() == Level.class){
                    Level level = (Level)originalFrame;
                    level.getGameTimer().stop();
                }
                
                if(originalFrame.getClass() == WinLose.class && nextFrame == null){
                    int nextLevelNumber = Frames.winLose.getPreviousLevel().getLevelNumber() + 1;
                    System.out.println("Next Level: " + nextLevelNumber);
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
                    return;
                }
                
                originalFrame.dispose();
                nextFrame.setVisible(true);
            }
        });
    }
    
}
