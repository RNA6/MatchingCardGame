/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import matchingcardgame.models.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdministratorDashboard extends BaseFrame{
    
    private JButton delete_button;
    private JButton view_button;
    private JButton top5_button;
    
    private JLayeredPane layeredPane;

    private JPanel base_panel;
    private JPanel top_panel;
    private JPanel center_panel;
    
    private JPanel btns_panel;
    private UserMenuPanel userMenu_panel;

    private JLabel userIcon_label;
    private JLabel dashboard_label;
    
    private User signedIn_user;

    public AdministratorDashboard() {
        super("Administrator Dashboard", 130, 500);
        
        layeredPane = new JLayeredPane();
        base_panel = new JPanel(new BorderLayout());
        base_panel.setBounds(0, 0, 690, 450);
        base_panel.setOpaque(false);
        
        userMenu_panel = new UserMenuPanel(this);
        
        //Beginning of Top Panel
        createTop_panel();

        //User Icon Label
        userIcon_label = UIComponents.createUserIcon_label(userMenu_panel);
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

        //delete Button
        delete_button = creatGameTypes_button("Delete User Account");
        btns_panel.add(delete_button);

        //view Button
        view_button = creatGameTypes_button("View Users List");
        btns_panel.add(view_button);

        //top5 Button
        top5_button = creatGameTypes_button("View Top 5 Players");
        btns_panel.add(top5_button);
        
        delete_button.setBackground(UITheme.color_63C8FF);
        view_button.setBackground(UITheme.color_CC66DA);
        top5_button.setBackground(UITheme.color_4DFFBE);

        center_panel.add(btns_panel, BorderLayout.CENTER);
        //#End of GameTypes Panel

        base_panel.add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel
 
        layeredPane.add(base_panel, JLayeredPane.DEFAULT_LAYER);
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

    //Center Panel Declaration
    private void createCenter_panel(){
        center_panel = new JPanel();
        center_panel.setLayout(new BorderLayout());
        center_panel.setOpaque(false);
    }

    //Center Panel Components
    //Head Label Declaration
    private void Dashboard_label(){
        dashboard_label = new JLabel("Administrator Dashboard");
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
        button.setPreferredSize(new Dimension(350, 50));
        return button;
    }
    //#End of Game Types Panel Components

    public JLabel getUserIcon_label() {
        return userIcon_label;
    }
    
     public JButton getdelete_button() {
        return delete_button;
    }

    public JButton getview_button() {
        return view_button;
    }

    public JButton gettop5_button() {
        return top5_button;
    }

    public User getSignedIn_user() {
        return signedIn_user;
    }

    public void setSignedIn_user(User signedIn_user) {
        this.signedIn_user = signedIn_user;
    }    
}
