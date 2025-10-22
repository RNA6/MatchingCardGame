
package matchingcardgame;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JFrame{
    
    JPanel main = new JPanel(new GridLayout(7, 1, 0, 5));
    JPanel signPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    JPanel guestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    
    JLabel welcome = new JLabel("WELCOME TO THE",JLabel.CENTER);
    JLabel match = new JLabel("MACHING",JLabel.CENTER);
    JLabel game = new JLabel("CARDS GAME",JLabel.CENTER);
    JLabel join = new JLabel("or join us as:",JLabel.CENTER);
    
    JButton signin = new JButton("Sign In");
    JButton signup = new JButton("Sign Up");
    JButton guest = new JButton("Guest");
    
   
    
    public WelcomePage(){
        super("matching cards game");
        getContentPane().setBackground(Theme.color_FDFFB8);
        main.setOpaque(false);
        signPanel.setOpaque(false);
        guestPanel.setOpaque(false);
        //panel
        main.setBackground(Theme.color_FDFFB8);

        setBounds(300, 130, 0, 0);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);

        //title labels
        welcome.setFont(new Font(Theme.fontName2, Font.BOLD, 36));
        welcome.setForeground(Theme.color_CC66DA);
        welcome.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        match.setFont(new Font(Theme.fontName1, Font.BOLD, 80));
        match.setForeground(Theme.color_FF2DD1);
        match.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        game.setFont(new Font(Theme.fontName1, Font.BOLD, 80));
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

        signPanel.add(signup);
        signPanel.add(signin);
    
        guestPanel.add(guest);


        main.add(welcome);
        main.add(match);
        main.add(game);
        main.add(new JLabel(" "));
        main.add(signPanel);
        main.add(join);
        main.add(guestPanel);
        add(main);
    }
}



