/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Level11 extends baseFrame{
    private JLabel timerLabel;
    private JLabel messageLabel;
    
    public Level11() {
        super("Level 11", 40, 700);
        setLayout(new BorderLayout());
        initializeUI();
    }

    private void initializeUI() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        topPanel.setOpaque(false);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font(UITheme.fontName2, Font.BOLD, 14));
        homeButton.setBackground(UITheme.color_FF2DD1);
        homeButton.setFocusable(false);
        homeButton.setPreferredSize(new Dimension(80, 30));

        JLabel levelLabel = new JLabel("Level 11");
        levelLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        levelLabel.setForeground(UITheme.color_CC66DA);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timerLabel = new JLabel("3:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        topPanel.add(homeButton, BorderLayout.WEST);
        topPanel.add(levelLabel, BorderLayout.CENTER);
        topPanel.add(timerLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        
        messageLabel = new JLabel("correct, good job /wrong, try again");
        messageLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.BLACK);
        add(messageLabel, BorderLayout.CENTER);

        
        JPanel cardsPanel = new JPanel(new GridLayout(4, 3, 25, 20));
        cardsPanel.setOpaque(false);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));
        
        JButton card1 = new JButton("?");
        cardStyle(card1);            
        cardsPanel.add(card1);
        
        JButton card2 = new JButton("?");
        cardStyle(card2);            
        cardsPanel.add(card2);
        
        JButton card3 = new JButton("?");
        cardStyle(card3);            
        cardsPanel.add(card3);
        
        JButton card4 = new JButton("?");
        cardStyle(card4);            
        cardsPanel.add(card4);
        
        JButton card5 = new JButton("?");
        cardStyle(card5);            
        cardsPanel.add(card5);
        
        JButton card6 = new JButton("?");
        cardStyle(card6);            
        cardsPanel.add(card6);
        
        JButton card7 = new JButton("?");
        cardStyle(card7);            
        cardsPanel.add(card7);
        
        JButton card8 = new JButton("?");
        cardStyle(card8);            
        cardsPanel.add(card8);
        
        JButton card9= new JButton("?");
        cardStyle(card9);            
        cardsPanel.add(card9);
        
        JButton card10 = new JButton("?");
        cardStyle(card10);            
        cardsPanel.add(card10);
        
        JButton card11 = new JButton("?");
        cardStyle(card11);            
        cardsPanel.add(card11);
        
        JButton card12 = new JButton("?");
        cardStyle(card12);            
        cardsPanel.add(card12);
        
        
        add(cardsPanel, BorderLayout.SOUTH);
        }

    private void cardStyle(JButton card){
        card.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        card.setBackground(UITheme.color_63C8FF);
        card.setFocusable(false);
        card.setPreferredSize(new Dimension(100, 100));
    }
}