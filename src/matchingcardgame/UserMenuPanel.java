/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author RNA
 */
public class UserMenuPanel extends JPanel implements ActionListener{
    
    private JButton userInfo_button;
    private JButton signOut_button;
    private boolean mouseClicked = false;
    
    public UserMenuPanel(BaseFrame originalFrame){
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        setBounds(540, 60, 120, 110);
        setBackground(UITheme.color_CC66DA);
        
        userInfo_button = createUser_menuItem("User Info");
        userInfo_button.addActionListener(this);
        UIUtilities.addNavigation(userInfo_button, originalFrame, new UserInfo(originalFrame));
        add(userInfo_button);
        
        signOut_button = createUser_menuItem("Sign Out");
        signOut_button.addActionListener(this);
        UIUtilities.addNavigation(signOut_button, originalFrame, new UserInfo(originalFrame));
        add(signOut_button);
        setVisible(false);
    }
    
    public boolean isMouseClicked(){
        return mouseClicked;
    }
    
    public void updateMouseClicked(){
        mouseClicked = !mouseClicked;
    }
    
    private JButton createUser_menuItem(String label){
        JButton button = new JButton(label);  
        button.setFocusable(false);
        button.setBackground(UITheme.color_E29EEB);
        button.setPreferredSize(new Dimension(100, 40));
        return(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mouseClicked = false;
    }
}
