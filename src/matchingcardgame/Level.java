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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author RNA
 */
public class Level extends BaseFrame{
    
    private final static int buttonWidth = 55;
    private static final String[] IMAGES_URL = new String[15];
    private static final Icon[] ALL_IMAGES = new Icon[15];
    
    static{
        for(int i=0; i<15; i++){
            IMAGES_URL[i] = "memory game images/image-"+(i+1)+".png";
            ImageIcon imageIcon = new ImageIcon(Level.class.getResource(IMAGES_URL[i]));
            ALL_IMAGES[i] = resizeImage(imageIcon, buttonWidth, buttonWidth);
        }
    }
    
    private JLabel timerLabel;
    private JLabel messageLabel;
    private JLabel levelLabel;
    
    private GameTimer gameTimer;
    
    private JButton homeButton;
    private JButton saveLevelButton;
    private JButton[] pair = {null, null};;
    private ArrayList<JButton> iconedCards; 
    private ArrayList<JButton> emptyCards; 
    
    private int rows;
    private int columns;    
    private int cardsPanelWidth;
    private int cardsPanelHeight;
    private int bottomMargin;
    private final int totalCards;
    private int pairsCount = 0;
    
    
    private ArrayList<Integer> imagesIndexes;    
    private ArrayList<String> cardsRecord;
    private ArrayList<Icon> cardsRecordImages;
    private ArrayList<Integer> order;
    
    private JPanel topPanel;
    private JPanel cardsPanel;
    private JPanel cardsPanelWrapper;
    private JPanel saveLevelPanelWrapper;
    private JPanel bottomPanel;
    
    private final Random random = new Random();
    private final CardsHandler cardsHandler = new CardsHandler();
    
    
    public Level(String title, int totalSeconds, int totalCards) {
        super(title, 130, 500);
        setLayout(new BorderLayout());
        
        this.totalCards = totalCards;
        initializeUI();
        
        gameTimer = new GameTimer(timerLabel, totalSeconds, () -> {
        messageLabel.setText("Time's up! Game Over.");
        });
    }
    
    private void initializeUI() {
        topPanel = new JPanel(new BorderLayout());
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
        
        switch(totalCards){
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
        
        cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        cardsPanel.setPreferredSize(new Dimension(cardsPanelWidth,cardsPanelHeight));
        cardsPanel.setOpaque(false);
        
        createCards_buttons();
        
        switch(rows){
            case 2:
                bottomMargin = 80;
                break;
            case 3:
                bottomMargin = 30;
                break;
            default:
                bottomMargin =0;
                break;
        }
        
        cardsPanelWrapper = new JPanel();
        cardsPanelWrapper.setOpaque(false);
        cardsPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomMargin, 0));
        cardsPanelWrapper.add(cardsPanel);
        
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        bottomPanel.add(cardsPanelWrapper, BorderLayout.CENTER);
        
        createSaveLevelButton();
        
        saveLevelPanelWrapper = new JPanel();
        saveLevelPanelWrapper.setOpaque(false);
        saveLevelPanelWrapper.setPreferredSize(new Dimension(80, 40));
        saveLevelPanelWrapper.add(saveLevelButton);
        bottomPanel.add(saveLevelPanelWrapper, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);  
        
        
    }
    
    private void createLevelLabel(String levelName){
        levelLabel = new JLabel(levelName);
        levelLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
        levelLabel.setForeground(UITheme.color_CC66DA);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    private void createTimerLabel(){
        timerLabel = new JLabel("5:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    private void createHomeButton(){
        homeButton = new JButton("Home");
        homeButton.setFont(new Font(UITheme.fontName2, Font.BOLD, 14));
        homeButton.setBackground(UITheme.color_FF2DD1);
        homeButton.setFocusable(false);
        homeButton.setPreferredSize(new Dimension(80, 30));
        UIUtilities.addNavigation(homeButton, this, Frames.homePage);
    }
    
    private void createMessageLabel(){
        messageLabel = new JLabel("correct, good job /wrong, try again");
        messageLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.BLACK);
    }
    
    private void createSaveLevelButton(){
        saveLevelButton = new JButton("Save");
        saveLevelButton.setFont(new Font(UITheme.fontName2, Font.BOLD, 14));
        saveLevelButton.setBackground(UITheme.color_4DFFBE);
        saveLevelButton.setFocusable(false);
        saveLevelButton.setPreferredSize(new Dimension(80, 30));
        UIUtilities.addNavigation(saveLevelButton, this, Frames.savedLevels);
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
    
    private void createCards_buttons(){
        cardsRecord = new ArrayList();
        cardsRecordImages = new ArrayList();
        imagesIndexes = new ArrayList();
        order = new ArrayList();
        
        int randomNumber;
        
        for(int i=0; i<totalCards/2; i++){
            randomNumber = random.nextInt(1,16) -1;
            imagesIndexes.add(randomNumber);
            imagesIndexes.add(randomNumber);
        }
        
        Collections.shuffle(imagesIndexes);
        
        System.out.println("Image indexes: "+ imagesIndexes);
        for (int i : imagesIndexes) {
            cardsRecordImages.add(ALL_IMAGES[i]);            
            cardsRecord.add(IMAGES_URL[i]);
        }
        
        emptyCards = new ArrayList();
        iconedCards = new ArrayList();
        for(int i=0; i< totalCards; i++){
            iconedCards.add(new JButton(cardsRecordImages.get(i)));
            cardStyle(iconedCards.get(i));
            iconedCards.get(i).setVisible(false);
            iconedCards.get(i).putClientProperty("cardId", i);
            iconedCards.get(i).addActionListener(cardsHandler);
            cardsPanel.add(iconedCards.get(i));
            
            emptyCards.add(new JButton());
            cardStyle(emptyCards.get(i));
            emptyCards.get(i).setVisible(true);
            emptyCards.get(i).putClientProperty("cardId", i);
            emptyCards.get(i).addActionListener(cardsHandler);
            cardsPanel.add(emptyCards.get(i));
        }      
    }
    
    public void shuffleCards(){
        int randomNumber;
        imagesIndexes.clear();
        cardsRecord.clear();
        cardsRecordImages.clear();
        
        for(int i=0; i<totalCards/2; i++){
            randomNumber = random.nextInt(1,16) -1;
            imagesIndexes.add(randomNumber);
            imagesIndexes.add(randomNumber);
        }
        
        Collections.shuffle(imagesIndexes);

        for (int i : imagesIndexes) {
            cardsRecordImages.add(ALL_IMAGES[i]);            
            cardsRecord.add(IMAGES_URL[i]);
        }
        
        for(int i=0; i< totalCards; i++){
            iconedCards.get(i).setIcon(cardsRecordImages.get(i));
        }
    }
    
    private class CardsHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();
            int cardIndex = (int)source.getClientProperty("cardId");
            
            JButton iconedCard = iconedCards.get(cardIndex);
            JButton emptyCard = emptyCards.get(cardIndex);
            
            if(pair[0] == null || pair[1] == null){
                emptyCard.setVisible(false);
                iconedCard.setVisible(true);
            }
            
            if(pair[0] == null){
                pair[0] = iconedCard;
            }
            else if(pair[1] == null){
                pair[1] = iconedCard;
                
                Icon icon1 = pair[0].getIcon();
                Icon icon2 = pair[1].getIcon();
                if(icon1 == icon2){
                    messageLabel.setText("Correct, good job!");
                    pairsCount++;
                    for(int i=0; i<2;i++){
                        pair[i] = null;
                    }
                }
                else{
                    messageLabel.setText("Wrong, try again!");
                    flipCards();
                }
                if(pairsCount == totalCards/2){
                    gameTimer.setSolved(true);
                    //TODO: move to win page
//                    new Timer(700, new ActionListener(){
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            
//                        }
//                    });
                }
                
            }            
        }
        
        private void flipCards(){
            Timer flipCardsTimer = new Timer(700, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<2;i++){
                        int temporarryIndex = (int)pair[i].getClientProperty("cardId");
                        emptyCards.get(temporarryIndex).setVisible(true);
                        pair[i].setVisible(false);
                        pair[i] = null;
                    }
                }
            });
            flipCardsTimer.setRepeats(false);
            flipCardsTimer.start();
        }
    }

    public void closeCards(){
        for(int i=0; i< totalCards; i++){
            emptyCards.get(i).setVisible(true);
            iconedCards.get(i).setVisible(false);
        }
    }
    
    public void restartLevel(){
        gameTimer.start();
        messageLabel.setText("");
        closeCards();
        shuffleCards();
        pairsCount = 0;
    }
    
    private static ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
