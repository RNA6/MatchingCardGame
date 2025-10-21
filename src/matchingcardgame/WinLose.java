
package matchingcardgame;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinLose extends JFrame{
    
    JPanel mainpanel = new JPanel(new GridLayout(2, 1, 0, 5));
    JPanel iconpanel = new JPanel(new GridLayout(1, 3, 5, 0) );
    
    JLabel star1 = new JLabel();
    JLabel star2 = new JLabel();
    JLabel star3 = new JLabel();
    
    JLabel win = new JLabel("YOU WIN", JLabel.CENTER);
    JLabel lose = new JLabel("YOU LOSE", JLabel.CENTER);
    
    public WinLose(){
        super("win lose");
        getContentPane().setBackground(Theme.color_FDFFB8);
        mainpanel.setOpaque(false);
        iconpanel.setOpaque(false);

        setBounds(300, 130, 0, 0);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);
        // put images
        star1.setIcon(new ImageIcon(getClass().getResource("normal-star.png")));
        star2.setIcon(new ImageIcon(getClass().getResource("normal-star.png")));
        star3.setIcon(new ImageIcon(getClass().getResource("dark-star.png")));

        star1.setSize(80, 80);
        star2.setSize(120, 120);
        star3.setSize(80, 80);
        
        iconpanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        iconpanel.add(star1);
        iconpanel.add(star2);
        iconpanel.add(star3);
        win.setFont(new Font(Theme.fontName1, Font.BOLD, 40));
        win.setForeground(Theme.color_FF2DD1);

        lose.setFont(new Font(Theme.fontName1, Font.BOLD, 40));
        lose.setForeground(Theme.color_FF2DD1);

        mainpanel.add(iconpanel);
        mainpanel.add(win);

        add(mainpanel);
    }
    
}


