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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ViewTop5Users extends BaseFrame {

    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel usersList_panel;

    private JScrollPane scrollPane;

    public ViewTop5Users() {
        super("View Top 5 Users", 130, 500);

        createTop_panel();
        createHead_label();
        add(top_panel, BorderLayout.NORTH);

        createCenter_panel();
        loadTop5Users();
        add(center_panel, BorderLayout.CENTER);

        createBottom_panel();
        createBack_button();
        bottom_panel.add(back_button);
        add(bottom_panel, BorderLayout.SOUTH);
    }

            // Database
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/matchingcardgame?serverTimezone=UTC",
            "root",
            "#"
        );
    }

    private void loadTop5Users() {
        usersList_panel = UIComponents.createScrolling_panel();

        String sql =
            "SELECT u.username, p.playerID, p.totalScores " +
            "FROM players p " +
            "JOIN users u ON p.playerID = u.playerID " +
            "ORDER BY p.totalScores DESC " +
            "LIMIT 5";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int rank = 1;
            while (rs.next()) {
                String username = rs.getString("username");
                int playerID = rs.getInt("playerID");
                int totalScores = rs.getInt("totalScores");

                usersList_panel.add(
                    createUser_panel(rank, username, playerID, totalScores)
                );
                rank++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        scrollPane = UIComponents.createScrollPane(usersList_panel);
        center_panel.add(scrollPane);
    }
    
    private void createTop_panel() {
        top_panel = new JPanel();
        top_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        top_panel.setOpaque(false);
    }

    private void createHead_label() {
        JLabel head_label = new JLabel("View Top 5 Users");
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        top_panel.add(head_label);
    }

    private void createCenter_panel() {
        center_panel = new JPanel(new BorderLayout());
        center_panel.setOpaque(false);
    }

    private JPanel createUser_panel(int rank, String username, int id, int score) {
        JPanel panel = UIComponents.createContent_panel();
        panel.setLayout(new GridLayout(1, 2));
        panel.setPreferredSize(new Dimension(500, 120));

        panel.add(createUserInfo_panel(username, id, score));
        panel.add(createRank_panel(rank));

        return panel;
    }

    private JPanel createUserInfo_panel(String username, int id, int score) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setOpaque(false);

        panel.add(new JLabel("Username: " + username));
        panel.add(new JLabel("ID: " + id));
        panel.add(new JLabel("Total Scores: " + score));

        return panel;
    }

    private JPanel createRank_panel(int rank) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel label = new JLabel("Rank #" + rank);
        label.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4, true));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(120, 50));

        panel.add(label);
        return panel;
    }

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