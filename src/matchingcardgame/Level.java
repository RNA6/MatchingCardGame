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
import javax.swing.BorderFactory;
import javax.swing.Box;
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
    
    private final int buttonWidth = 65;
    private int cardsPanelWidth;
    private int cardsPanelHeight;
    private int bottomMargin;
    
    public Level(String title, int totalSeconds, int totalCards) {
        super(title, 130, 500);
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
                columns = 2;
                rows = 2;
                break;
            case 6:
                columns = 3;
                rows = 2;
                break;
            case 8:
                columns = 4;
                rows = 2;
                break;
            case 12:
                columns = 4;
                rows = 3;
                break;
            case 16:
                columns = 4;
                rows = 4;
                break;
            case 20:
                columns = 5;
                rows = 4;
                break; 
            case 24:
                columns = 6;
                rows = 4;
                break; 
            case 28:
                columns = 7;
                rows = 4;
                break;    
        }
        cardsPanelWidth = 25 + (columns)*(buttonWidth + 25);
        cardsPanelHeight = 20 + (rows)*(buttonWidth + 20);
        
        JPanel cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        cardsPanel.setPreferredSize(new Dimension(cardsPanelWidth,cardsPanelHeight));
        cardsPanel.setOpaque(false);
        
        switch(rows){
            case 2:
                bottomMargin = 100;
                break;
            case 3:
                bottomMargin = 50;
                break;
            default:
                bottomMargin =0;
                break;
        }
        
        for(int i=0; i< cards.length; i++){
            cards[i] = new JButton();
            cardStyle(cards[i]);
            cardsPanel.add(cards[i]);
        }
        JPanel cardsPanelWrapper = new JPanel();
        cardsPanelWrapper.setOpaque(false);
        cardsPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomMargin, 0));
        cardsPanelWrapper.add(cardsPanel);
        add(cardsPanelWrapper, BorderLayout.SOUTH);
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
        card.setPreferredSize(new Dimension(buttonWidth, buttonWidth));
    }
}
