/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePage extends JFrame {

    private JButton signOut_button;
    private JButton easy_button;
    private JButton normal_button;
    private JButton hard_button;
    private JButton showScore_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel signOut_panel;
    private JPanel gameTypes_panel;

    private FlowLayout layout;

    private Icon user_icon;

    private JLabel userIcon_label;
    private JLabel head_label;

    public HomePage() {
        super("Home Page");
        getContentPane().setBackground(Theme.color_FDFFB8);
        setBounds(350, 95, 200, 200);
        setMinimumSize(new Dimension(700,500));
        
        layout = new FlowLayout();
        
        //Begining of Top Panel
        top_panel = new JPanel();
        top_panel.setLayout(new BorderLayout());
        top_panel.setPreferredSize(new Dimension(50,50));
        top_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 15));
        top_panel.setOpaque(false);
        
        //Begining of SignOut Panel
        signOut_panel = new JPanel();
        signOut_panel.setLayout(new FlowLayout());
        signOut_panel.setOpaque(false);
        
        //SignOut Button
        signOut_button = new JButton("Sign Out");
        signOut_button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        signOut_button.setSize(74, 31);
        signOut_button.setFocusable(false);
        signOut_button.setBackground(Theme.color_CC66DA);

        signOut_panel.add(signOut_button);
        top_panel.add(signOut_panel, BorderLayout.WEST);
        //#End of SignOut panel

        //UserIcon Label
        user_icon = new ImageIcon(getClass().getResource("user1.png"));
        
        userIcon_label = new JLabel(user_icon);
        userIcon_label.setVerticalAlignment(SwingConstants.TOP);
        top_panel.add(userIcon_label, BorderLayout.EAST);

        add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel
        
        //Begining of Center Panel
        center_panel = new JPanel();
        center_panel.setLayout(new BorderLayout());
        center_panel.setOpaque(false);
        
        //Head Label
        head_label = new JLabel("Game Type");
        head_label.setForeground(Theme.color_CC66DA);
        head_label.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
        center_panel.add(head_label, BorderLayout.NORTH);
        
        //Begining of GameTypes Panel
        gameTypes_panel = new JPanel();
        gameTypes_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        gameTypes_panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        gameTypes_panel.setOpaque(false);
        
        //Easy Button
        easy_button = creatGameTypes_button("Easy");
        gameTypes_panel.add(easy_button);
        
        //Normal Button
        normal_button = creatGameTypes_button("Normal");
        gameTypes_panel.add(normal_button);
        
        //Hard Button
        hard_button = creatGameTypes_button("Hard");
        gameTypes_panel.add(hard_button);

        center_panel.add(gameTypes_panel, BorderLayout.CENTER);
        //#End of GameTypes Panel
        
        add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel
        
        //Begining of Bottom Panel
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 55));
        bottom_panel.setOpaque(false);
        
        //ShowScore Button
        showScore_button = new JButton("Show Score");
        showScore_button.setFocusable(false);
        showScore_button.setBackground(Theme.color_4DFFBE);
        showScore_button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        showScore_button.setPreferredSize(new Dimension(150, 50));
        showScore_button.setHorizontalAlignment(SwingConstants.CENTER);
        
        bottom_panel.add(showScore_button);
        add(bottom_panel, BorderLayout.SOUTH);
    }
    
    private JButton creatGameTypes_button(String buttonLabel){
        JButton button = new JButton(buttonLabel);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        button.setBackground(Theme.color_63C8FF);
        button.setPreferredSize(new Dimension(130, 130));
        return button;
    }

}
