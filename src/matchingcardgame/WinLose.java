package matchingcardgame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WinLose extends BaseFrame{
    
    // both panels now use FlowLayout
    private JPanel mainpanel;
    private JPanel iconpanel;
    private JPanel btnpanel;

    private JLabel[] stars;

    private JLabel won_label;
    private JLabel lost_label;
    private JLabel reward_label;
    private JLabel tryAgain_label;
    
    private JButton home_button;
    private JButton next_button;
    private JButton tryAgain_button;
    
    private Level previousLevel;  
    
    private final Icon normalStar; 
    private final Icon darkStar;
    
    private int points = 0;

    public WinLose() {
        super("win lose", 130, 500);
        mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainpanel.setOpaque(false);
        
        iconpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        iconpanel.setOpaque(false);
        
        btnpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnpanel.setOpaque(false);
        
        normalStar = new ImageIcon(getClass().getResource("normal-star.png"));
        darkStar = new ImageIcon(getClass().getResource("dark-star.png"));
        
        stars = new JLabel[3];
        for(int i=0; i<3; i++){
            stars[i] = new JLabel(normalStar);
            stars[i].setSize(100, 100);
            iconpanel.add(stars[i]);
        }

        // label styles
        won_label = new JLabel("YOU WON", JLabel.CENTER);
        won_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        won_label.setForeground(UITheme.color_FF2DD1);
        
        lost_label = new JLabel("YOU LOST", JLabel.CENTER);
        lost_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        lost_label.setForeground(UITheme.color_FF2DD1);
        lost_label.setVisible(false);
        
        reward_label = new JLabel("YOUR REWARD IS "+ points +" POINTS", JLabel.CENTER);
        reward_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        reward_label.setForeground(UITheme.color_FF2DD1);
        
        tryAgain_label = new JLabel("LETs TRY AGAIN", JLabel.CENTER);
        tryAgain_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        tryAgain_label.setForeground(UITheme.color_FF2DD1);
        tryAgain_label.setVisible(false);
        
        //btn style
        home_button = new JButton("HOME");
        home_button.setBackground(UITheme.color_63C8FF);
        home_button.setFont(new Font(UITheme.fontName2, Font.BOLD, 20));
        home_button.setPreferredSize(new Dimension(150, 40));
        home_button.setFocusPainted(false);
        
        next_button = new JButton("NEXT");
        next_button.setBackground(UITheme.color_4DFFBE);
        next_button.setFont(new Font(UITheme.fontName2, Font.BOLD, 20));
        next_button.setPreferredSize(new Dimension(150, 40));
        next_button.setFocusPainted(false);
        
        tryAgain_button = new JButton("TRY AGAIN");
        tryAgain_button.setBackground(UITheme.color_4DFFBE);
        tryAgain_button.setFont(new Font(UITheme.fontName2, Font.BOLD, 20));
        tryAgain_button.setPreferredSize(new Dimension(150, 40));
        tryAgain_button.setFocusPainted(false);
        tryAgain_button.setVisible(false);
        
        //add buttons to panel
        btnpanel.add(home_button);
        btnpanel.add(next_button);        
        btnpanel.add(tryAgain_button);        
        
        // SET PANELS TO SET POSITIONS
        
        tryAgain_label.setBorder(BorderFactory.createEmptyBorder(5, 50, 0, 50));
        
        reward_label.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        won_label.setPreferredSize(new Dimension(400, 100));
        won_label.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        lost_label.setPreferredSize(new Dimension(400, 100));
        lost_label.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        iconpanel.setPreferredSize(new Dimension(400, 150));
        iconpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        btnpanel.setPreferredSize(new Dimension(500, 500));
        btnpanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        // add components (same order as before)
        mainpanel.add(won_label);
        mainpanel.add(lost_label);
        mainpanel.add(iconpanel);
        mainpanel.add(reward_label);
        mainpanel.add(tryAgain_label);
        mainpanel.add(btnpanel);
        // You can switch to "lose" instead by commenting the line above:
        
        add(mainpanel);
    }

    public void setPreviousLevel(Level previousLevel) {
        this.previousLevel = previousLevel;
    }
    
    public Level getPreviousLevel() {
        return previousLevel;
    }

    public JButton getNext() {
        return next_button;
    }

    public JButton getHome() {
        return home_button;
    }

    public JButton getTryAgain_button() {
        return tryAgain_button;
    }
    
    public void updateMessage(String wonOrLost){
        
        // 1. Prepare the data to be sent
    int playerId = 1;        // Replace with your actual player ID variable
    int levelNum = 1;        // Replace with your actual level variable
    int time = 90;   // Replace with your actual timer variable
    int currentScore = this.points; 
    
    // Determine stars based on win/lose
    int starsEarned = wonOrLost.equals("lost") ? 0 : 3;

    DatabaseUtilities.saveGameData(playerId, levelNum, time, currentScore, starsEarned);    
    
        if(wonOrLost.equals("lost")){
            if(won_label.isVisible()){
                won_label.setVisible(false);
                reward_label.setVisible(false);
                next_button.setVisible(false);
                lost_label.setVisible(true);
                tryAgain_label.setVisible(true);
                tryAgain_button.setVisible(true);
                
                for(int i=0; i<3; i++){
                    stars[i].setIcon(darkStar);
                }
            }
        }
        else{
            if(lost_label.isVisible()){
                lost_label.setVisible(false);
                tryAgain_label.setVisible(false);
                tryAgain_button.setVisible(false);
                won_label.setVisible(true);
                reward_label.setVisible(true);
                next_button.setVisible(true);
                
                for(int i=0; i<3; i++){
                    stars[i].setIcon(normalStar);
                }
            }
        }
    }   
}
