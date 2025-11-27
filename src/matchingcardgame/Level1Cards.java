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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Level1Cards extends BaseFrame{
    private JLabel timerLabel;
    private JLabel messageLabel;
    
    private JButton homeButton;
    private GameTimer gameTimer;
    
    private JButton[] cards = new JButton[4];
    private ImageIcon backImage;
    private ImageIcon[] cardFronts;//حق صور البطاقات

    private JButton firstCard = null;
    private JButton secondCard = null;
    private Integer firstId = null;
    private Integer secondId = null;
    private boolean blockClick = false;
    
    public Level1Cards() {
        super("Level 1", 130, 500);
        setLayout(new BorderLayout());
        initializeUI();
        
        gameTimer = new GameTimer(timerLabel, 300, () -> {
        messageLabel.setText("Time's up! Game Over.");
        });
        gameTimer.start();
    }
    
    private ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
    
    private void initializeUI() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        topPanel.setOpaque(false);

        homeButton = new JButton("Home");
        homeButton.setFont(new Font(UITheme.fontName2, Font.BOLD, 14));
        homeButton.setBackground(UITheme.color_FF2DD1);
        homeButton.setFocusable(false);
        homeButton.setPreferredSize(new Dimension(80, 30));
        System.out.println("Before creating HomePage");
        UIUtilities.addNavigation(homeButton, this, Frames.homePage);
        System.out.println("After creating HomePage");

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

        
        messageLabel = new JLabel("");
        messageLabel.setFont(new Font(UITheme.fontName1, Font.BOLD, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.BLACK);
        add(messageLabel, BorderLayout.CENTER);

        //تعريف الصور
        backImage = new ImageIcon("images/back.jpg");
        ImageIcon img1 = new ImageIcon("images/img1.jpg");
        ImageIcon img2 = new ImageIcon("images/img2.jpg");
        
        int cardW = 100;
        int cardH = 100;
        backImage = resizeImage(backImage, cardW, cardH);
        ImageIcon[] resizedUnique = new ImageIcon[2];
        resizedUnique[0] = resizeImage(img1, cardW, cardH);//id = 0
        resizedUnique[1] = resizeImage(img2, cardW, cardH);//id = 1
        
        List<Integer> order = new ArrayList<>();
        order.add(0); order.add(0);
        order.add(1); order.add(1);
        
        Collections.shuffle(order);// ينحطون عشوائي
        
        JPanel cardsPanel = new JPanel(new GridLayout(2, 2, 25, 20));
        cardsPanel.setOpaque(false);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));

        for (int i = 0; i < 4; i++) {
            JButton card = new JButton();
            card.setFocusable(false);
            card.setPreferredSize(new Dimension(cardW, cardH));
            card.setBackground(Color.WHITE);
            card.setBorderPainted(false);
            card.setMargin(new java.awt.Insets(0,0,0,0));
            
            int id = order.get(i);
            ImageIcon frontIcon = resizedUnique[id];
            card.putClientProperty("cardId", id);
            card.setIcon(backImage);
            
            card.addActionListener(e -> handleCardClick(card, frontIcon, id));

            cards[i] = card;
            cardsPanel.add(card);
        }

        add(cardsPanel, BorderLayout.SOUTH);
    }
    
    private void handleCardClick(JButton card, ImageIcon frontImage, int id){
        if (blockClick || card == firstCard)
            return;

        //يكشف البطاقه
        card.setIcon(frontImage);

        if (firstCard == null) {
            firstCard = card;
            firstId = id;
        } else {
            secondCard = card;
            secondId = id;
            blockClick = true;

            //يشيك التطابق
            if (firstId.equals(secondId)) {

                messageLabel.setText("Correct, good job!");

                firstCard.setEnabled(false);
                secondCard.setEnabled(false);
                resetSelection();
                
                if (allCardsMatched()) {
                    gameTimer.stop();
                    showWinScreen();
                }
            }
            else{
                messageLabel.setText("Wrong, try again");

                new javax.swing.Timer(700, e -> {
                    firstCard.setIcon(backImage);
                    secondCard.setIcon(backImage);
                    resetSelection();
                }).start();
            }
        }
    }

    private boolean allCardsMatched() {
        for (JButton c : cards) {
            if (c.isEnabled()) return false;
        }
        return true;
    }

    private void showWinScreen() {
        ShowScore win = new ShowScore();
        win.setVisible(true);
    }

    private void resetSelection() {
        firstCard = null;
        secondCard = null;
        firstId = null;
        secondId = null;
        blockClick = false;
    }
}