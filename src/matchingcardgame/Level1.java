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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Level1 extends JFrame{
    private JLabel timerLabel;
    private JLabel messageLabel;
    private Timer gameTimer;
    private int secondsLeft = 300;
    
    public Level1() {
        super("Level 1");
        setLayout(new BorderLayout());
        initializeUI();
        startTimer();

    }

    private void initializeUI() {
        UITheme.setFrameProperties(this, 130, 500);
        
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

        JLabel levelLabel = new JLabel("Level 1");
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

        
        JPanel cardsPanel = new JPanel(new GridLayout(2, 2, 25, 20));
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
        
        add(cardsPanel, BorderLayout.SOUTH);
    }
    
    private void startTimer() {
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft--;
                if (secondsLeft <= 0) {
                    gameTimer.stop();
                    messageLabel.setText("Time's up! Game Over.");
                }
                updateTimerDisplay();
            }
        });
        gameTimer.start();
    }
    
    private void updateTimerDisplay() {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        timerLabel.setText(String.format("%d:%02d", minutes, seconds));
    }

    private void cardStyle(JButton card){
        card.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        card.setBackground(UITheme.color_63C8FF);
        card.setFocusable(false);
        card.setPreferredSize(new Dimension(100, 100));
    }
}
