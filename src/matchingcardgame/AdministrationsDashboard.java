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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdministrationsDashboard extends JFrame{
    private JButton signout_button;
    private JButton delete_button;
    private JButton view_button;
    private JButton top5_button;
    
    
    private JLayeredPane layeredPane;

    private JPanel base_panel;
    private JPanel top_panel;
    private JPanel center_panel;
    
    private JPanel SignOut_panel;
    private JPanel btns_panel;
    private JPanel userMenu_panel;

    private Icon user_icon;

    private JLabel userIcon_label;
    private JLabel dashboard_label;

    public AdministrationsDashboard() {
        super("Administrations Dashboard");
        UITheme.setFrameProperties(this, 130, 500);
        
        layeredPane = new JLayeredPane();
        base_panel = new JPanel(new BorderLayout());
        base_panel.setBounds(0, 0, 690, 450);
        base_panel.setOpaque(false);
        //Beginning of Top Panel
        createTop_panel();

        //Beginning of SignOut Panel
        createSignOut_panel();

        //SignOut Button
        createSignOut_button();
        SignOut_panel.add(signout_button);
        top_panel.add(SignOut_panel, BorderLayout.WEST);
        //#End of SignOut panel

        //User Icon Label
        createUserIcon_label();
        top_panel.add(userIcon_label, BorderLayout.EAST);

        base_panel.add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel

        //Beginning of Center Panel
        createCenter_panel();

        //Head Label
        Dashboard_label();
        center_panel.add(dashboard_label, BorderLayout.NORTH);

        //Beginning of GameTypes Panel
        createBtns_panel();

        //Easy Button
        delete_button = creatGameTypes_button("Delete User Account");
        btns_panel.add(delete_button);

        //Normal Button
        view_button = creatGameTypes_button("View Users List");
        btns_panel.add(view_button);

        //Hard Button
        top5_button = creatGameTypes_button("View Top 5 Players");
        btns_panel.add(top5_button);

        center_panel.add(btns_panel, BorderLayout.CENTER);
        //#End of GameTypes Panel

        base_panel.add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel

 
        layeredPane.add(base_panel, JLayeredPane.DEFAULT_LAYER);
        
        userMenu_panel = new UserMenuPanel(this);
        layeredPane.add(userMenu_panel, JLayeredPane.POPUP_LAYER);
        add(layeredPane);
    }

    //Top Panel Declaration
    private void createTop_panel(){
        top_panel = new JPanel();
        top_panel.setLayout(new BorderLayout());
        top_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 15));
        top_panel.setOpaque(false);
    }

    //Top Panel Components
    //Sign Out panel Declaration
    private void createSignOut_panel(){
        SignOut_panel = new JPanel();
        SignOut_panel.setLayout(new FlowLayout());
        SignOut_panel.setOpaque(false);
    }

    //Saved Levels Panel Components
    //sign out Button Declaration
    private void createSignOut_button(){
        signout_button = new JButton("Sign Out");
        signout_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 12));
        signout_button.setPreferredSize(new Dimension(110, 30));
        signout_button.setFocusable(false);
        signout_button.setBackground(UITheme.color_CC66DA);
    }
    //#End of createSavedLevels_button Panel Components

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
    private void Dashboard_label(){
        dashboard_label = new JLabel("Adminstration Dashboard");
        dashboard_label.setForeground(UITheme.color_CC66DA);
        dashboard_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 48));
        dashboard_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Game Types Panel Declaration
    private void createBtns_panel(){
        btns_panel = new JPanel();
        btns_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        btns_panel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
        btns_panel.setOpaque(false);
    }

    //btns Panel Components
    //Object of a Game Type Button Declaration
    private JButton creatGameTypes_button(String buttonLabel){
        JButton button = new JButton(buttonLabel);
        button.setFocusable(false);
        button.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        button.setBackground(UITheme.color_4DFFBE);
        button.setPreferredSize(new Dimension(350, 50));
        return button;
    }
    //#End of Game Types Panel Components


    
    
    
}
