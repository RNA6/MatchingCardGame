/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DeleteUserAccount extends BaseFrame{

    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel usersList_panel;
    private JPanel deleteButton_panel;
    private ArrayList<JPanel> users_panels;

    private JScrollPane scrollPane;

    private JLabel head_label;
    private JLabel username_label;
    private JLabel id_label;
    private JLabel rank_label;

    private String username = "";
    private int id = 0;

    public DeleteUserAccount() {
        super("Delete User Account", 130, 500);

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
        users_panels = new ArrayList();
        for(int i=0; i<15 ; i++){
            users_panels.add(createUser_panel(i+1));
        }

        for (JPanel user_panel : users_panels) {
            usersList_panel.setPreferredSize(new Dimension(usersList_panel.getPreferredSize().width, (usersList_panel.getPreferredSize().height + 100)));
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
        head_label = new JLabel("Delete User Account");
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
    private JPanel createUser_panel(int id) {
        JPanel user_panel = UIComponents.createContent_panel();
        user_panel.setLayout(new GridLayout(1, 2));
        user_panel.setPreferredSize(new Dimension(500, 80));
        user_panel.add(createUserInfo_panel(id));
        createDeleteButton_panel();
        deleteButton_panel.add(createDelete_button(user_panel));
        user_panel.add(deleteButton_panel);
        return (user_panel);
    }
    
    //Users Panel Components
    //User Information Labels Declaration
    private void createUserInfo_labels(int id) {
        username_label = new JLabel(("Username: " + username), SwingConstants.LEFT);
        username_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        id_label = new JLabel("Id: " + id, SwingConstants.LEFT);
        id_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));
}
    
    //User Information Panel Declaration
    private JPanel createUserInfo_panel(int id) {
        createUserInfo_labels(id);
        JPanel userInfo_panel = new JPanel(new GridLayout(2, 1));
        userInfo_panel.setOpaque(false);
        userInfo_panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        userInfo_panel.add(username_label);
        userInfo_panel.add(id_label);
        return (userInfo_panel);
    }
    
    private void createDeleteButton_panel(){
        deleteButton_panel = new JPanel();
        deleteButton_panel.setOpaque(false);        
        deleteButton_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));      
    }
    
    //Delete Button Declaration
    private JButton createDelete_button(JPanel userPanel){
        JButton delete_button = new JButton("delete");
        delete_button.setBackground(UITheme.color_4DFFBE);
        delete_button.setFocusable(false);
        delete_button.setFont(new Font(UITheme.fontName2, Font.BOLD, 15));
        delete_button.setBounds(380, 40, 100, 30);
        delete_button.putClientProperty("userPanel", userPanel);
      
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION){
                    JPanel userPanel = (JPanel)delete_button.getClientProperty("userPanel");
                    usersList_panel.remove(userPanel);
                    users_panels.remove(userPanel);
                    usersList_panel.setPreferredSize(new Dimension(usersList_panel.getPreferredSize().width, (usersList_panel.getPreferredSize().height - 100)));
                    usersList_panel.revalidate();
                    usersList_panel.repaint();
                }
            }
        });
        return(delete_button);
    }
    
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
