/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matchingcardgame;

import javax.swing.JFrame;

public class MatchingCardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HomePage hp = new HomePage();
        hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hp.pack();
        hp.setVisible(true);
        
        UserInfo uip = new UserInfo();
        uip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uip.pack();
        uip.setVisible(true);
        
//        Test Testp = new Test();
//        Testp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Testp.pack();
//        Testp.setVisible(true);
    }
    
}
