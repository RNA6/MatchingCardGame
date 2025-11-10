package matchingcardgame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WinLose extends JFrame {
    
    // both panels now use FlowLayout
    JPanel mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel iconpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel btnpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

    JLabel star1 = new JLabel();
    JLabel star2 = new JLabel();
    JLabel star3 = new JLabel();

    JLabel win = new JLabel("YOU WIN", JLabel.CENTER);
    JLabel lose = new JLabel("YOU LOSE", JLabel.CENTER);
    JLabel reward = new JLabel("YOUR REWARD IS #### POINTS", JLabel.CENTER);
    JLabel tryagain = new JLabel("LETs TRY AGAIN", JLabel.CENTER);
    
    JButton next = new JButton("NEXT");
    JButton home = new JButton("HOME");
    

    public WinLose() {
        super("win lose");
        UITheme.setFrameProperties(this, 130, 500);
        
        mainpanel.setOpaque(false);
        iconpanel.setOpaque(false);
        btnpanel.setOpaque(false);

        // put images
        star1.setIcon(new ImageIcon(getClass().getResource("normal-star.png")));
        star2.setIcon(new ImageIcon(getClass().getResource("normal-star.png")));
        star3.setIcon(new ImageIcon(getClass().getResource("dark-star.png")));

        star1.setSize(80, 80);
        star2.setSize(120, 120);
        star3.setSize(80, 80);

       
        iconpanel.add(star1);
        iconpanel.add(star2);
        iconpanel.add(star3);

        // label styles
        win.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        win.setForeground(UITheme.color_FF2DD1);

        lose.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        lose.setForeground(UITheme.color_FF2DD1);
        
        reward.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        reward.setForeground(UITheme.color_FF2DD1);
        
        tryagain.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        tryagain.setForeground(UITheme.color_FF2DD1);
        
        //btn style
        home.setBackground(UITheme.color_63C8FF);
        home.setFont(new Font(UITheme.fontName2, Font.BOLD, 20));
        home.setPreferredSize(new Dimension(150, 40));
        home.setFocusPainted(false);
        
        next.setBackground(UITheme.color_4DFFBE);
        next.setFont(new Font(UITheme.fontName2, Font.BOLD, 20));
        next.setPreferredSize(new Dimension(150, 40));
        next.setFocusPainted(false);
        
        //add buttons to panel
        btnpanel.add(home);
        btnpanel.add(next);        
        
        // SET PANELS TO SET POSITIONS
        
        tryagain.setPreferredSize(new Dimension(400, 100));
        tryagain.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 50));
        
        win.setPreferredSize(new Dimension(400, 100));
        win.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        iconpanel.setPreferredSize(new Dimension(400, 150));
        iconpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        btnpanel.setPreferredSize(new Dimension(500, 500));
        btnpanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        // add components (same order as before)
        mainpanel.add(win);
        mainpanel.add(iconpanel);
        mainpanel.add(reward);
        mainpanel.add(btnpanel);
        // You can switch to "lose" instead by commenting the line above:
        // mainpanel.add(lose);

        add(mainpanel);
    }
}
