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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DeleteUserAccount extends BaseFrame {

    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel usersList_panel;

    private JScrollPane scrollPane;
    private JLabel head_label;

    public DeleteUserAccount() {
        super("Delete User Account", 130, 500);

        // Top Panel
        createTop_panel();
        createHead_label();
        top_panel.add(head_label);
        add(top_panel, BorderLayout.NORTH);

        // Center Panel
        createCenter_panel();
        usersList_panel = UIComponents.createScrolling_panel();
        loadUsers();

        scrollPane = UIComponents.createScrollPane(usersList_panel);
        center_panel.add(scrollPane);
        add(center_panel, BorderLayout.CENTER);

        // Bottom Panel
        createBottom_panel();
        createBack_button();
        bottom_panel.add(back_button);
        add(bottom_panel, BorderLayout.SOUTH);
    }

    // ================= TOP PANEL =================
    private void createTop_panel() {
        top_panel = new JPanel();
        top_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        top_panel.setOpaque(false);
    }

    private void createHead_label() {
        head_label = new JLabel("Delete User Account");
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    // ================= CENTER PANEL =================
    private void createCenter_panel() {
        center_panel = new JPanel(new BorderLayout());
        center_panel.setOpaque(false);
    }
   

    private void loadUsers() {
        String sql = "SELECT username, playerID FROM users WHERE isAdmin = 0";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getInt("playerID")
                );

                usersList_panel.add(createUser_panel(user));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error loading users from database",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private JPanel createUser_panel(User user) {
        JPanel user_panel = UIComponents.createContent_panel();
        user_panel.setLayout(new GridLayout(1, 2));
        user_panel.setPreferredSize(new Dimension(500, 80));

        user_panel.add(createUserInfo_panel(user));
        user_panel.add(createDeleteButton_panel(user, user_panel));

        return user_panel;
    }

    private JPanel createUserInfo_panel(User user) {
        JLabel usernameLabel = new JLabel("Username: " + user.getUsername());
        JLabel idLabel = new JLabel("Player ID: " + user.getPlayerID());

        usernameLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));
        idLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        panel.add(usernameLabel);
        panel.add(idLabel);

        return panel;
    }

    private JPanel createDeleteButton_panel(User user, JPanel userPanel) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JButton delete_button = new JButton("Delete");
        delete_button.setBackground(UITheme.color_4DFFBE);
        delete_button.setFocusable(false);
        delete_button.setFont(new Font(UITheme.fontName2, Font.BOLD, 15));

        delete_button.addActionListener(e -> deleteUser(user, userPanel));

        panel.add(delete_button);
        return panel;
    }

    private void deleteUser(User user, JPanel userPanel) {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete " + user.getUsername() + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "DELETE FROM users WHERE username = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.executeUpdate();

            usersList_panel.remove(userPanel);
            usersList_panel.revalidate();
            usersList_panel.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to delete user",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ================= BOTTOM PANEL =================
    private void createBottom_panel() {
        bottom_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        bottom_panel.setOpaque(false);
    }

    private void createBack_button() {
        back_button = new JButton("Back");
        back_button.setFocusable(false);
        back_button.setBackground(UITheme.color_4DFFBE);
        back_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        back_button.setPreferredSize(new Dimension(100, 40));
    }

    public JButton getBack_button() {
        return back_button;
    }
}


