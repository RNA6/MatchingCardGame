/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import matchingcardgame.models.User;
import matchingcardgame.models.Player;
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

public class HomePage extends BaseFrame{

    private JButton savedLevels_button;
    private JButton back_button;
    private JButton easy_button;
    private JButton normal_button;
    private JButton hard_button;
    private JButton showScore_button;
    
    private JLayeredPane layeredPane;

    private JPanel base_panel;
    private JPanel east_panel;
    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel savedLevels_panel;
    private JPanel backButton_panel;
    private JPanel gameTypes_panel;
    
    private UserMenuPanel userMenu_panel;

    private JLabel userIcon_label;
    private JLabel head_label;
    
    private User signedIn_user;  
    private Player player;

    public HomePage() {
        super("Home Page", 130, 500);
        
        layeredPane = new JLayeredPane();
        base_panel = new JPanel(new BorderLayout());
        base_panel.setBounds(0, 0, 690, 450);
        base_panel.setOpaque(false);
        
        userMenu_panel = new UserMenuPanel(this);
        //Beginning of Top Panel
        createTop_panel();

        //Beginning of SavedLevels Panel
        createSavedLevels_panel();

        //SavedLevels Button
        createSavedLevels_button();
        savedLevels_panel.add(savedLevels_button);
        top_panel.add(savedLevels_panel, BorderLayout.WEST);
        //#End of SavedLevels panel
        
        //Beginning of Back Button Panel
        createBackButton_panel();
        
        east_panel = new JPanel();
        east_panel.setOpaque(false);
        
        //Back Button
        createBack_button();
        backButton_panel.add(back_button);
        east_panel.add(backButton_panel);
        top_panel.add(east_panel, BorderLayout.EAST);
        //#End of Back Button Panel
        //User Icon Label
        userIcon_label = UIComponents.createUserIcon_label(userMenu_panel);
        east_panel.add(userIcon_label);
        top_panel.add(east_panel, BorderLayout.EAST);

        base_panel.add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel

        //Beginning of Center Panel
        createCenter_panel();

        //Head Label
        createHead_label();
        center_panel.add(head_label, BorderLayout.NORTH);

        //Beginning of GameTypes Panel
        createGameTypes_panel();

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

        base_panel.add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel

        //Beginning of Bottom Panel
        createBottom_panel();

        //ShowScore Button
        createShowScore_button();

        bottom_panel.add(showScore_button);
        base_panel.add(bottom_panel, BorderLayout.SOUTH);
        //#End of Bottom Panel
        
        layeredPane.add(base_panel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(userMenu_panel, JLayeredPane.POPUP_LAYER);
        add(layeredPane);
        
    }

    public void setSignedIn_user(User signedIn_user) {
        this.signedIn_user = signedIn_user;
    }

    public User getSignedIn_user() {
        return signedIn_user;
    }
    

    //Top Panel Declaration
    private void createTop_panel(){
        top_panel = new JPanel();
        top_panel.setLayout(new BorderLayout());
        top_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 15));
        top_panel.setOpaque(false);
    }

    //Top Panel Components
    //Saved Levels Panel Declaration
    private void createSavedLevels_panel(){
        savedLevels_panel = new JPanel();
        savedLevels_panel.setLayout(new FlowLayout());
        savedLevels_panel.setOpaque(false);
    }

    //Saved Levels Panel Components
    //Saved Levels Button Declaration
    private void createSavedLevels_button(){
        savedLevels_button = new JButton("Saved Levels");
        savedLevels_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 12));
        savedLevels_button.setPreferredSize(new Dimension(110, 30));
        savedLevels_button.setFocusable(false);
        savedLevels_button.setBackground(UITheme.color_CC66DA);
    }
    //#End of SavedLevels Panel Components
    
    //Back Button Panel Declaration
    private void createBackButton_panel(){
        backButton_panel = new JPanel();
        backButton_panel.setLayout(new FlowLayout());
        backButton_panel.setOpaque(false);
    }
    //Back Button Panel Components
    //Back Button Declaration
    private void createBack_button(){
        back_button = new JButton("Back");
        back_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 12));
        back_button.setPreferredSize(new Dimension(70, 30));
        back_button.setFocusable(false);
        back_button.setBackground(UITheme.color_CC66DA);
        back_button.setVisible(false);
    }
    //#End of Back Button Panel Components
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
        head_label = new JLabel("Game Type");
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 48));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

     //Game Types Panel Declaration
    private void createGameTypes_panel(){
        gameTypes_panel = new JPanel();
        gameTypes_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        gameTypes_panel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
        gameTypes_panel.setOpaque(false);
    }

    //Game Types Panel Components
    //Object of a Game Type Button Declaration
    private JButton creatGameTypes_button(String buttonLabel){
        JButton button = new JButton(buttonLabel);
        button.setFocusable(false);
        button.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        button.setBackground(UITheme.color_63C8FF);
        button.setPreferredSize(new Dimension(130, 130));
        return button;
    }
    //#End of Game Types Panel Components


    //Bottom Panel Declaration
    private void createBottom_panel(){
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        bottom_panel.setOpaque(false);
    }

    //Bottom Panel Components
    //Show Score Button Declaration
    private void createShowScore_button(){
        showScore_button = new JButton("Show Score");
        showScore_button.setFocusable(false);
        showScore_button.setBackground(UITheme.color_4DFFBE);
        showScore_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        showScore_button.setPreferredSize(new Dimension(150, 50));
        showScore_button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Bottom Panel Components

    public JButton getSavedLevels_button() {
        return savedLevels_button;
    }

    public JButton getEasy_button() {
        return easy_button;
    }

    public JButton getNormal_button() {
        return normal_button;
    }

    public JButton getHard_button() {
        return hard_button;
    }

    public JButton getShowScore_button() {
        return showScore_button;
    }

    public JLabel getUserIcon_label() {
        return userIcon_label;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    
}