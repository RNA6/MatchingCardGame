
package matchingcardgame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends JFrame{
    
    JPanel signPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    JPanel guestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    
    JLabel welcome = new JLabel("WELCOME TO THE",JLabel.CENTER);
    JLabel match = new JLabel("MATCHING",JLabel.CENTER);
    JLabel game = new JLabel("CARDS GAME",JLabel.CENTER);
    JLabel join = new JLabel("or join us as:",JLabel.CENTER);
    
    JButton signin = new JButton("Sign In");
    JButton signup = new JButton("Sign Up");
    JButton guest = new JButton("Guest");
    
   
    
    public WelcomePage(){
        super("matching cards game");
        setLayout(new GridLayout(6, 1));
        Theme.setFrameProperties(this, 130, 500);
        
        signPanel.setOpaque(false);
        guestPanel.setOpaque(false);
        
        //title labels
        welcome.setFont(new Font(Theme.fontName2, Font.BOLD, 36));
        welcome.setForeground(Theme.color_CC66DA);
        welcome.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        match.setFont(new Font(Theme.fontName1, Font.BOLD, 70));
        match.setForeground(Theme.color_FF2DD1);
        match.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        game.setFont(new Font(Theme.fontName1, Font.BOLD, 70));
        game.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        game.setForeground(Theme.color_FF2DD1);
        game.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //or join us as a guist label color black
        join.setFont(new Font(Theme.fontName1, Font.BOLD, 12));
        join.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //Buttons
        signin.setBackground(Theme.color_63C8FF);
        signin.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        signin.setFocusPainted(false);

        signup.setBackground(Theme.color_CC66DA);
        signup.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        signup.setFocusPainted(false);

        guest.setBackground(Theme.color_4DFFBE);
        guest.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        guest.setFocusPainted(false);
        
        signPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        signPanel.add(signup);
        signPanel.add(signin);
    
        guestPanel.add(guest);

        add(welcome);
        add(match);
        add(game);
        add(signPanel);
        add(join);
        add(guestPanel);
    }
}



