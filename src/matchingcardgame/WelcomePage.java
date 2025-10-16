
package matchingcardgame;

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
    main.setBackground(new Color(255, 252, 210));
   
    //title labels
    welcome.setFont(new Font("Monospaced", Font.BOLD, 36));
    welcome.setForeground(new Color(120, 40, 150));
    welcome.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    match.setFont(new Font("SansSerif", Font.BOLD, 80));
    match.setForeground(new Color(255, 51, 170));
    match.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    game.setFont(new Font("SansSerif", Font.BOLD, 80));
    game.setForeground(new Color(255, 51, 170));
    game.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    //or join us as a guist label color black
    join.setFont(new Font("Dialog", Font.PLAIN, 12));
    join.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    
    //ButtonPanel for signup/in
    signPanel.setBackground(new Color(255, 252, 210));
    
    //ButtonPanel for guest
    guestPanel.setBackground(new Color(255, 252, 210));
    
    //Buttons
    signin.setBackground(new Color(98, 174, 238));
    signin.setFont(new Font("Monospaced", Font.PLAIN, 18));
    signin.setFocusPainted(false);
    
    signup.setBackground(new Color(208, 92, 202));
    signup.setFont(new Font("Monospaced", Font.PLAIN, 18));
    signup.setFocusPainted(false);
    
    guest.setBackground(new Color(105, 235, 183));
    guest.setFont(new Font("Monospaced", Font.PLAIN, 18));
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

