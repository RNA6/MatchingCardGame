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


public class Level9 extends baseFrame{
    private JLabel timerLabel;
    private JLabel messageLabel;
    private GameTimer gameTimer;
    
    public Level9() {
        super("Level 9", 130, 500);
        setLayout(new BorderLayout());
        initializeUI();
        gameTimer = new GameTimer(timerLabel, 300, () -> {
        messageLabel.setText("Time's up! Game Over.");
        });
        gameTimer.start();
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
        homeButton.addActionListener(e -> {
            dispose();
            new HomePage().setVisible(true);
        });

        JLabel levelLabel = new JLabel("Level 9");
        levelLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        levelLabel.setForeground(UITheme.color_CC66DA);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timerLabel = new JLabel("5:00");
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

        
        JPanel cardsPanel = new JPanel(new GridLayout(4, 6, 20, 20));
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
        
        JButton card13 = new JButton("?");
        cardStyle(card13);            
        cardsPanel.add(card13);
        
        JButton card14 = new JButton("?");
        cardStyle(card14);            
        cardsPanel.add(card14);
        
        JButton card15 = new JButton("?");
        cardStyle(card15);            
        cardsPanel.add(card15);
        
        JButton card16 = new JButton("?");
        cardStyle(card16);            
        cardsPanel.add(card16);
        
        JButton card17 = new JButton("?");
        cardStyle(card17);            
        cardsPanel.add(card17);
        
        JButton card18 = new JButton("?");
        cardStyle(card18);            
        cardsPanel.add(card18);
        
        JButton card19 = new JButton("?");
        cardStyle(card19);            
        cardsPanel.add(card19);
        
        JButton card20 = new JButton("?");
        cardStyle(card20);            
        cardsPanel.add(card20);
        
        JButton card21 = new JButton("?");
        cardStyle(card21);            
        cardsPanel.add(card21);
        
        JButton card22 = new JButton("?");
        cardStyle(card22);            
        cardsPanel.add(card22);
        
        JButton card23 = new JButton("?");
        cardStyle(card23);            
        cardsPanel.add(card23);
        
        JButton card24 = new JButton("?");
        cardStyle(card24);            
        cardsPanel.add(card24);
        
        add(cardsPanel, BorderLayout.SOUTH);
        }

    private void cardStyle(JButton card){
        card.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        card.setBackground(UITheme.color_63C8FF);
        card.setFocusable(false);
        card.setPreferredSize(new Dimension(50, 50));
    }
}