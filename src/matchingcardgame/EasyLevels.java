/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EasyLevels extends JFrame {

    private JButton level1_button;
    private JButton level2_button;
    private JButton level3_button;
    private JButton level4_button;
    private JButton level5_button;
    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel levels_panel;

    private Icon user_icon;

    private JLabel userIcon_label;
    private JLabel head_label;

    public EasyLevels() {
        super("Easy Levels");
        getContentPane().setBackground(Theme.color_FDFFB8);
        setBounds(300, 130, 0, 0);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);

        //Beginning of Top Panel
        createTop_panel();

        //User Icon Label
        createUserIcon_label();
        top_panel.add(userIcon_label, BorderLayout.EAST);

        add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel

        //Beginning of Center Panel
        createCenter_panel();

        //Head Label
        createHead_label();
        center_panel.add(head_label, BorderLayout.NORTH);

        //Beginning of Levels Panel
        createLevels_panel();

        //Level 1 Button
        level1_button = creatLevels_button("1");
        levels_panel.add(level1_button);

        //Level 2 Button
        level2_button = creatLevels_button("2");
        levels_panel.add(level2_button);

        //Level 3 Button
        level3_button = creatLevels_button("3");
        levels_panel.add(level3_button);
        
        //Level 4 Button
        level4_button = creatLevels_button("4");
        levels_panel.add(level4_button);

        //Level 5 Button
        level5_button = creatLevels_button("5");
        levels_panel.add(level5_button);

        center_panel.add(levels_panel, BorderLayout.CENTER);
        //#End of Levels Panel

        add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel

        //Beginning of Bottom Panel
        createBottom_panel();

        //Back Button
        createBack_button();

        bottom_panel.add(back_button);
        add(bottom_panel, BorderLayout.SOUTH);
        //#End of Bottom Panel
    }

    //Top Panel Declaration
    private void createTop_panel(){
        top_panel = new JPanel();
        top_panel.setLayout(new BorderLayout());
        top_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 15));
        top_panel.setOpaque(false);
    }

    //Top Panel Components
    //User Icon Label Declaration
    private void createUserIcon_label(){
        user_icon = new ImageIcon(getClass().getResource("user.png"));
        userIcon_label = new JLabel(user_icon);
        userIcon_label.setVerticalAlignment(SwingConstants.TOP);
    }
    //#End of Top Panel Components

    //Center Panel Declaration
    private void createCenter_panel(){
        center_panel = new JPanel();
        center_panel.setLayout(new BorderLayout());
        center_panel.setOpaque(false);
    }

    //Center Panel Components
    //Head Label Declaration
    private void createHead_label(){
        head_label = new JLabel("Easy Levels");
        head_label.setForeground(Theme.color_CC66DA);
        head_label.setFont(new Font(Theme.fontName1, Font.BOLD, 48));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Levels Panel Declaration
    private void createLevels_panel(){
        levels_panel = new JPanel();
        levels_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 25));
        levels_panel.setPreferredSize(new Dimension(250, 150));
        levels_panel.setBorder(BorderFactory.createEmptyBorder(10, 110, 0, 110));
        levels_panel.setOpaque(false);
    }

    //Levels Panel Components
    //Object of a Level Button Declaration
    private JButton creatLevels_button(String buttonLabel){
        JButton button = new JButton(buttonLabel);
        button.setFocusable(false);
        button.setFont(new Font(Theme.fontName1, Font.BOLD, 28));
        button.setBackground(Theme.color_63C8FF);
        button.setPreferredSize(new Dimension(80, 80));
        return button;
    }
    //#End of Levels Panel Components


    //Bottom Panel Declaration
    private void createBottom_panel(){
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        bottom_panel.setOpaque(false);
    }

    //Bottom Panel Components
    //Back Button Declaration
    private void createBack_button(){
        back_button = new JButton("Back");
        back_button.setFocusable(false);
        back_button.setBackground(Theme.color_4DFFBE);
        back_button.setFont(new Font(Theme.fontName1, Font.BOLD, 20));
        back_button.setPreferredSize(new Dimension(150, 50));
        back_button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Bottom Panel Components
}