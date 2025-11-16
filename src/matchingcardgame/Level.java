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

/**
 *
 * @author RNA
 */
public class Level extends BaseFrame{
    
    private JLabel timerLabel;
    private JLabel messageLabel;
    private JLabel levelLabel;
    
    private JButton homeButton;
    private GameTimer gameTimer;
    
    private JButton[] cards; 
    private int rows;
    private int columns;
    
    private int buttonWidth;
    
    public Level(String title, int y_location, int frame_hieght, int totalSeconds, int totalCards) {
        super(title, y_location, frame_hieght);
        setLayout(new BorderLayout());
        
        cards = new JButton[totalCards];
        initializeUI();
        
        gameTimer = new GameTimer(timerLabel, totalSeconds, () -> {
        messageLabel.setText("Time's up! Game Over.");
        });
    }
    
    private void initializeUI() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        topPanel.setOpaque(false);

        createHomeButton();
        createLevelLabel(super.getTitle());
        createTimerLabel();
        
        topPanel.add(homeButton, BorderLayout.WEST);
        topPanel.add(levelLabel, BorderLayout.CENTER);
        topPanel.add(timerLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        createMessageLabel();
        add(messageLabel, BorderLayout.CENTER);
        
        switch(cards.length){
            case 4:
                rows = 2;
                columns = 2;
                buttonWidth = 100;
                break;
            case 6:
                rows = 2;
                columns = 2;
                buttonWidth = 100;
                break;
            case 8:
                rows = 2;
                columns = 4;
                buttonWidth = 100;
                break;
            case 12:
                rows = 4;
                columns = 3;
                buttonWidth = 100;
                break;
            case 16:
                rows = 4;
                columns = 4;
                buttonWidth = 50;
                break;
            case 20:
                rows = 4;
                columns = 5;
                buttonWidth = 50;
                break; 
            case 24:
                rows = 4;
                columns = 6;
                buttonWidth = 50;
                break; 
            case 28:
                rows = 4;
                columns = 7;
                buttonWidth = 50;
                break;    
        }
        
        JPanel cardsPanel = new JPanel(new GridLayout(rows, columns, 25, 20));
        cardsPanel.setOpaque(false);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));
        
        for(int i=0; i< cards.length; i++){
            cards[i] = new JButton();
            cardStyle(cards[i]);
            cardsPanel.add(cards[i]);
        }
        
        add(cardsPanel, BorderLayout.SOUTH);
    }
    
    private void createLevelLabel(String levelName){
        levelLabel = new JLabel(levelName);
        levelLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        levelLabel.setForeground(UITheme.color_CC66DA);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void createTimerLabel(){
        timerLabel = new JLabel("5:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    public void createHomeButton(){
        homeButton = new JButton("Home");
        homeButton.setFont(new Font(UITheme.fontName2, Font.BOLD, 14));
        homeButton.setBackground(UITheme.color_FF2DD1);
        homeButton.setFocusable(false);
        homeButton.setPreferredSize(new Dimension(80, 30));
        UIUtilities.addNavigation(homeButton, this, Frames.homePage);
    }
    
    public void createMessageLabel(){
        messageLabel = new JLabel("correct, good job /wrong, try again");
        messageLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.BLACK);
    }
    
    public GameTimer getGameTimer(){
        return(gameTimer);
    }

    private void cardStyle(JButton card){
        card.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        card.setBackground(UITheme.color_63C8FF);
        card.setFocusable(false);
        card.setPreferredSize(new Dimension(100, 100));
    }
}
