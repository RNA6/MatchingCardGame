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
                if(nextFrame.getClass() == HomePage.class){
                    if(originalFrame.getClass() == WelcomePage.class){
                        
                        Frames.homePage.getUserIcon_label().setVisible(false);
                        Frames.easyLevels.getUserIcon_label().setVisible(false);
                        Frames.normalLevels.getUserIcon_label().setVisible(false);
                        Frames.hardLevels.getUserIcon_label().setVisible(false);
                    }
                }
                
                
                originalFrame.dispose();
                nextFrame.setVisible(true);
            }
        });
    }
    
}
