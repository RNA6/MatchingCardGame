/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author RNA
 */
public class CustomizedComponents{
    
    public static JPanel createScrolling_panel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
        panel.setPreferredSize(new Dimension(400,20));
        panel.setBackground(Theme.color_63C8FF);
        return(panel);
    }
    
    public static JScrollPane createScrollPane(JPanel panel){
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return(scrollPane);
    }
    
    public static JPanel createContent_panel(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panel.setBackground(Theme.color_C2EAFF);
        return(panel);
    }
    
    public static JPanel createUserMenu_panel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel.setBounds(540, 60, 120, 110);
        panel.setBackground(Theme.color_CC66DA);
        panel.add(createUser_menuItem("User Info"));
        panel.add(createUser_menuItem("Sign Out"));
        return(panel);
    }
    
    private static JButton createUser_menuItem(String label){
        JButton button = new JButton(label);  
        button.setFocusable(false);
        button.setBackground(Theme.color_E29EEB);
        button.setPreferredSize(new Dimension(100, 40));
        return(button);
    }
}
