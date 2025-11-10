/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matchingcardgame;

public class MatchingCardGame {

   
    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);        
        
        SignIn signIn = new SignIn();
        signIn.setVisible(true);
        
        SignUp signUp = new SignUp();
        signUp.setVisible(true);
        
        HomePage homePage = new HomePage();
        homePage.setVisible(true);       
        
        UserInfo userInfo = new UserInfo();
        userInfo.setVisible(true);       
        
        ShowScore showScore = new ShowScore();
        showScore.setVisible(true);
        
        EasyLevels easyLevels = new EasyLevels();
        easyLevels.setVisible(true);
        
        NormalLevels normalLevels = new NormalLevels();
        normalLevels.setVisible(true);
        
        HardLevels hardLevels = new HardLevels();
        hardLevels.setVisible(true);
        
        Level1 level1 = new Level1();
        level1.setVisible(true);
        
        Level2 level2 = new Level2();
        level2.setVisible(true);
        
        Level3 level3 = new Level3();
        level3.setVisible(true);
        
        Level4 level4 = new Level4();
        level4.setVisible(true);
        
        Level5 level5 = new Level5();
        level5.setVisible(true);
        
        Level6 level6 = new Level6();
        level6.setVisible(true);
        
        Level7 level7 = new Level7();
        level7.setVisible(true);
        
        Level8 level8 = new Level8();
        level8.setVisible(true);
        
        Level9 level9 = new Level9();
        level9.setVisible(true);
        
        Level10 level10 = new Level10();
        level10.setVisible(true);
        
        Level11 level11 = new Level11();
        level11.setVisible(true);
        
        Level12 level12 = new Level12();
        level12.setVisible(true);
        
        Level13 level13 = new Level13();
        level13.setVisible(true);
        
        Level14 level14 = new Level14();
        level14.setVisible(true);
        
        Level15 level15 = new Level15();
        level15.setVisible(true);
        
        WinLose winLose = new WinLose();
        winLose.setVisible(true); 
        
        AdministrationsDashboard adminsDashboard = new AdministrationsDashboard();
        adminsDashboard.setVisible(true);
        
        ViewUsersList viewUsersList = new ViewUsersList();
        viewUsersList.setVisible(true);

        SavedLevels savedLevels = new SavedLevels();
        savedLevels.setVisible(true);

    }    
}
