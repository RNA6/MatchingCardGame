/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RNA
 */
public class Frames{
    
    public static WelcomePage welcomePage = new WelcomePage();
    public static SignIn signIn = new SignIn();
    public static SignUp signUp = new SignUp();
    
    public static HomePage homePage = new HomePage();
    
    public static EasyLevels easyLevels = new EasyLevels();
    public static Level[] easyLevel = {Levels.createLevel1(), Levels.createLevel2(),
        Levels.createLevel3(), Levels.createLevel4(), Levels.createLevel5()};
    
    public static NormalLevels normalLevels = new NormalLevels();
    public static Level[] normalLevel = {Levels.createLevel6(), Levels.createLevel7(),
        Levels.createLevel8(), Levels.createLevel9(), Levels.createLevel10()};
    
    public static HardLevels hardLevels = new HardLevels();
    public static Level[] hardLevel = {Levels.createLevel11(), Levels.createLevel12(),
        Levels.createLevel13(), Levels.createLevel14(), Levels.createLevel15()};
    
    public static Level[][] allLevels = {easyLevel, normalLevel, hardLevel};
    public static SavedLevels savedLevels = new SavedLevels();
    public static ShowScore showScore = new ShowScore();
    public static AdministratorDashboard administrationsDashboard = new AdministratorDashboard();
    public static ViewUsersList viewUsersList = new ViewUsersList();
    
    
    
    public static void InitializeFrames(){
        //WelcomePage buttons
        UIUtilities.addNavigation(welcomePage.getGuest(), welcomePage, homePage);
        UIUtilities.addNavigation(welcomePage.getSignin(), welcomePage, signIn);
        UIUtilities.addNavigation(welcomePage.getSignup(), welcomePage, signUp);
        
        //HomePage buttons
        UIUtilities.addNavigation(homePage.getEasy_button(), homePage, easyLevels);
        UIUtilities.addNavigation(homePage.getNormal_button(), homePage, normalLevels);
        UIUtilities.addNavigation(homePage.getHard_button(), homePage, hardLevels);
        UIUtilities.addNavigation(homePage.getSavedLevels_button(), homePage, savedLevels);
        UIUtilities.addNavigation(homePage.getShowScore_button(), homePage, showScore);
    
        //SignIn buttons
        UIUtilities.addNavigation(signIn.getCancel_button(), signIn, welcomePage);
        UIUtilities.addNavigation(signIn.getSignIn_button(), signIn, homePage);
        
        //SignUp buttons
        UIUtilities.addNavigation(signUp.getCancel_button(), signUp, welcomePage);
        UIUtilities.addNavigation(signUp.getSubmit_button(), signUp, welcomePage);
        
        //EasyLevels buttons
        UIUtilities.addNavigation(easyLevels.getBack_button(), easyLevels, homePage);
        for(int i=0; i<easyLevel.length; i++){
            Level level = easyLevel[i];
            UIUtilities.addNavigation(easyLevels.getLevels_buttons()[i], easyLevels, level);
            easyLevels.getLevels_buttons()[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    level.getGameTimer().start();
                }
            });
        }
        
        //NormalLevels buttons
        UIUtilities.addNavigation(normalLevels.getBack_button(), normalLevels, homePage);
        for(int i=0; i<normalLevel.length; i++){
            Level level = normalLevel[i];
            UIUtilities.addNavigation(normalLevels.getLevels_buttons()[i], normalLevels, normalLevel[i]);
            normalLevels.getLevels_buttons()[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    level.getGameTimer().start();
                }
            });
        }
        
        //HardLevels buttons
        UIUtilities.addNavigation(hardLevels.getBack_button(), hardLevels, homePage);
        for(int i=0; i<hardLevel.length; i++){
            Level level = hardLevel[i];
            UIUtilities.addNavigation(hardLevels.getLevels_buttons()[i], hardLevels, hardLevel[i]);
            hardLevels.getLevels_buttons()[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    level.getGameTimer().start();
                }
            });
        }
        
        //SavedLevels buttons
        UIUtilities.addNavigation(savedLevels.getBack_button(), savedLevels, homePage);
        
        //ShowScore buttons
        
        //AdministrationsDashboard buttons
        
        //ViewUsersList buttons
        UIUtilities.addNavigation(viewUsersList.getBack_button(), viewUsersList, administrationsDashboard);
    }
}
