/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author RNA
 */
public class UserMenuPanel extends JPanel{
    
    private JButton userInfo_button;
    private JButton signOut_button;
    
    public UserMenuPanel(JFrame originalFrame){
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        setBounds(540, 60, 120, 110);
        setBackground(Theme.color_CC66DA);
        
        userInfo_button = createUser_menuItem("User Info");
        CustomizedComponents.addNavigation(userInfo_button, originalFrame, new UserInfo());
        add(userInfo_button);
        
        signOut_button = createUser_menuItem("Sign Out");
        CustomizedComponents.addNavigation(signOut_button, originalFrame, new UserInfo());
        add(userInfo_button);
        
        setVisible(false);
    }
    
    private JButton createUser_menuItem(String label){
        JButton button = new JButton(label);  
        button.setFocusable(false);
        button.setBackground(Theme.color_E29EEB);
        button.setPreferredSize(new Dimension(100, 40));
        return(button);
    }
}
