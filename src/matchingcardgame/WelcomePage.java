
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
    //panel
    main.setBackground(Theme.FDFFB8);

    setBounds(300, 130, 0, 0);
    setMinimumSize(new Dimensin(700,500));
    setResizable(false);
        
    //title labels
    welcome.setFont(new Font(Theme.fontName2, Font.BOLD, 36));
    welcome.setForeground(Theme.CC66DA);
    welcome.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    match.setFont(new Font(Theme.fontName1, Font.BOLD, 80));
    match.setForeground(Theme.FF2DD1);
    match.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    game.setFont(new Font(Theme.FontName1, Font.BOLD, 80));
    game.setForeground(Theme.FF2DD1);
    game.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    //or join us as a guist label color black
    join.setFont(new Font(Theme.fontName1, Font.PLAIN, 12));
    join.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    //ButtonPanel for signup/in
    signPanel.setBackground(Theme.FDFFB8);
    
    //ButtonPanel for guest
    guestPanel.setBackground(Theme.FDFFB8);
    
    //Buttons
    signin.setBackground(Theme.63C8FF);
    signin.setFont(new Font(Theme.fontName2, Font.PLAIN, 18));
    signin.setFocusPainted(false);
    
    signup.setBackground(Theme.CC66DA);
    signup.setFont(new Font(Theme.fontName2, Font.PLAIN, 18));
    signup.setFocusPainted(false);
    
    guest.setBackground(Theme.4DFFBE);
    guest.setFont(new Font(Theme.fontName2, Font.PLAIN, 18));
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



