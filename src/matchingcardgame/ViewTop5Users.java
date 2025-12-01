/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ViewTop5Users extends BaseFrame{

    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel usersList_panel;
    private ArrayList<JPanel> Users_panels;

    private JScrollPane scrollPane;

    private JLabel head_label;
    private JLabel username_label;
    private JLabel id_label;
    private JLabel totalScores_label;
    private JLabel rank_label;

    private String username = "";
    private String id = "";
    private int totalScores = 0;

    public ViewTop5Users() {
        super("View Top 5 Users", 130, 500);

        //Beginning of Top Panel
        createTop_panel();

        //Head Label
        createHead_label();
        top_panel.add(head_label);

        add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel

        //Beginning of Center Panel
        createCenter_panel();
        //Beggining of Users List Panel
        usersList_panel = UIComponents.createScrolling_panel();

        //Users Panels
        Users_panels = new ArrayList();
        for(int i=1; i<=5 ; i++){
            Users_panels.add(createUser_panel(i));
        }

        for (JPanel user_panel : Users_panels) {
            usersList_panel.setPreferredSize(new Dimension(usersList_panel.getPreferredSize().width, (usersList_panel.getPreferredSize().height+ 140)));
            usersList_panel.add(user_panel);
        }
        //#End of Users List Panel
        //ScrollPane declaration
        scrollPane = UIComponents.createScrollPane(usersList_panel);
        center_panel.add(scrollPane);
        
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
    private void createTop_panel() {
        top_panel = new JPanel();
        top_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        top_panel.setOpaque(false);
    }

    //Top Panel Components
    //Head Label Declaration
    private void createHead_label() {
        head_label = new JLabel("View Top 5 Users");
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Top Panel Components

    //Center Panel Declaration
    private void createCenter_panel() {
        center_panel = new JPanel();
        center_panel.setLayout(new BorderLayout());
        center_panel.setOpaque(false);
    }

    //Center Panel Components
    //Users Panel Declaration
    private JPanel createUser_panel(int rank) {
        JPanel user_panel = UIComponents.createContent_panel();
        user_panel.setLayout(new GridLayout(1, 2));
        user_panel.setPreferredSize(new Dimension(500, 120));
        user_panel.add(createUserInfo_panel());
        user_panel.add(createRank_panel(rank));
        return (user_panel);
    }
    
    //Users Panel Components
    //User Information Labels Declaration
    private void createUserInfo_labels() {
        username_label = new JLabel(("Username: " + username), SwingConstants.LEFT);
        username_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        id_label = new JLabel("Id: " + id, SwingConstants.LEFT);
        id_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        totalScores_label = new JLabel("Total Scores: " + totalScores, SwingConstants.LEFT);
        totalScores_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));
    }
    
    //User Information Panel Declaration
    private JPanel createUserInfo_panel() {
        createUserInfo_labels();
        JPanel userInfo_panel = new JPanel(new GridLayout(3, 1));
        userInfo_panel.setOpaque(false);
        userInfo_panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        userInfo_panel.add(username_label);
        userInfo_panel.add(id_label);
        userInfo_panel.add(totalScores_label);
        return (userInfo_panel);
    }
    
    //Rank Panel Declaration
    private JPanel createRank_panel(int rank) {
        JPanel rank_panel = new JPanel();
        rank_panel.setOpaque(false);
        rank_panel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        if(rank <= 5){
            createRank_label(rank);
            rank_panel.add(rank_label);    
        }
        return (rank_panel);
    }
    
    //Rank Panel Components
    //Rank Label Declaration
    private void createRank_label(int rank) {
        rank_label = new JLabel("Rank #" + rank);
        rank_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        rank_label.setPreferredSize(new Dimension(100, 50));
        rank_label.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        rank_label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Rank Panel Components
    //#End of Users Panel Components
    //#End of Center Panel Components
    
    //Bottom Panel Declaration
    private void createBottom_panel() {
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        bottom_panel.setOpaque(false);
    }

    //Bottom Panel Components
    //Back Button Declaration
    private void createBack_button() {
        back_button = new JButton("Back");
        back_button.setFocusable(false);
        back_button.setBackground(UITheme.color_4DFFBE);
        back_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        back_button.setPreferredSize(new Dimension(100, 40));
        back_button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Bottom Panel Components

    public JButton getBack_button() {
        return back_button;
    }
}
