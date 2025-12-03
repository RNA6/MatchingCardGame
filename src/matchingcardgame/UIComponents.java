/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author RNA
 */
public class UIComponents{
    
    public static JPanel createScrolling_panel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
        panel.setPreferredSize(new Dimension(400,20));
        panel.setBackground(UITheme.color_63C8FF);
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
        panel.setBackground(UITheme.color_C2EAFF);
        return(panel);
    }     
    
    //User Icon Label Declaration
    public static JLabel createUserIcon_label(UserMenuPanel userMenu_panel){
        Icon user_icon = new ImageIcon(userMenu_panel.getClass().getResource("user.png"));
        JLabel userIcon_label = new JLabel(user_icon);
        userIcon_label.setVerticalAlignment(SwingConstants.TOP);
        userIcon_label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                userMenu_panel.updateMouseClicked();
                userMenu_panel.setVisible(userMenu_panel.isMouseClicked());
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                userMenu_panel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!userMenu_panel.isMouseClicked()){
                    userMenu_panel.setVisible(false);
                }
            }
        });
        return(userIcon_label);
    }
}
