package matchingcardgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteUserAccount extends BaseFrame {

    private JPanel usersPanel;

    public DeleteUserAccount() {

        super("Delete User Account",130,500);

       
        getContentPane().setBackground(UITheme.color_FDFFB8);
        setLayout(null);

      
        JLabel title = new JLabel("Delete User Account", SwingConstants.CENTER);
        title.setFont(new Font(UITheme.fontName1, Font.BOLD, 32));
        title.setBounds(140, 20, 430, 50);
        add(title);

       
        usersPanel = new JPanel();
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));
        usersPanel.setBackground(UITheme.color_63C8FF);

        JScrollPane scroll = new JScrollPane(usersPanel);
        scroll.setBounds(80, 100, 540, 320);
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        add(scroll);

        
        addUserBox("User1", "12345");
        addUserBox("User2", "67890");

       
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font(UITheme.fontName2, Font.BOLD, 16));
        backBtn.setBackground(UITheme.color_4DFFBE);
        backBtn.setBounds(80, 440, 100, 35);

       
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        add(backBtn);

        setVisible(true);
    }

    
    private void addUserBox(String username, String id) {

        JPanel box = new JPanel(null);
        box.setPreferredSize(new Dimension(500, 120));
        box.setBackground(UITheme.color_C2EAFF);
        box.setBorder(BorderFactory.createLineBorder(UITheme.color_A19F9F, 1));

        JLabel userLabel = new JLabel("Username: " + username);
        userLabel.setBounds(20, 15, 300, 30);
        userLabel.setFont(new Font(UITheme.fontName2, Font.BOLD, 18));

        JLabel idLabel = new JLabel("Id: " + id);
        idLabel.setBounds(20, 50, 300, 30);
        idLabel.setFont(new Font(UITheme.fontName2, Font.PLAIN, 18));

      
        JButton deleteBtn = new JButton("delete");
        deleteBtn.setBackground(UITheme.color_4DFFBE);
        deleteBtn.setFont(new Font(UITheme.fontName2, Font.BOLD, 15));
        deleteBtn.setBounds(380, 40, 100, 30);

      
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    usersPanel.remove(box);
                    usersPanel.revalidate();
                    usersPanel.repaint();
                }
            }
        });

     
        box.add(userLabel);
        box.add(idLabel);
        box.add(deleteBtn);

        usersPanel.add(Box.createVerticalStrut(10));
        usersPanel.add(box);
    }
}
