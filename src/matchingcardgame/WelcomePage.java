package matchingcardgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends JFrame {
    //panels
    JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
    JPanel signPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
    JPanel guestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
    //labels
    JLabel welcome = new JLabel("WELCOME TO THE", JLabel.CENTER);
    JLabel match = new JLabel("MACHING", JLabel.CENTER);
    JLabel game = new JLabel("CARDS GAME", JLabel.CENTER);
    JLabel join = new JLabel("or join us as:", JLabel.CENTER);
    //buttons
    JButton signin = new JButton("Sign In");
    JButton signup = new JButton("Sign Up");
    JButton guest = new JButton("Guest");

    public WelcomePage() {
        super("matching cards game");
        setLayout(new BorderLayout()); 
        //frame
        getContentPane().setBackground(Theme.color_FDFFB8);
        main.setOpaque(false);
        signPanel.setOpaque(false);
        guestPanel.setOpaque(false);

        setBounds(300, 130, 0, 0);
        setMinimumSize(new Dimension(700, 500));
        setResizable(false);

        // settings title labels
        welcome.setFont(new Font(Theme.fontName2, Font.BOLD, 36));
        welcome.setForeground(Theme.color_CC66DA);

        match.setFont(new Font(Theme.fontName1, Font.BOLD, 80));
        match.setForeground(Theme.color_FF2DD1);

        game.setFont(new Font(Theme.fontName1, Font.BOLD, 80));
        game.setForeground(Theme.color_FF2DD1);

        // settings or join as label
        join.setFont(new Font(Theme.fontName1, Font.BOLD, 12));

        // settings Buttons
        signin.setBackground(Theme.color_63C8FF);
        signin.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        signin.setFocusPainted(false);

        signup.setBackground(Theme.color_CC66DA);
        signup.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        signup.setFocusPainted(false);

        guest.setBackground(Theme.color_4DFFBE);
        guest.setFont(new Font(Theme.fontName2, Font.BOLD, 18));
        guest.setFocusPainted(false);

        // Add buttons to panels
        signPanel.add(signup);
        signPanel.add(signin);
        guestPanel.add(join);
        guestPanel.add(guest);
        
        //settings panels to adjust positions
        signPanel.setPreferredSize(new Dimension(700, 90));
        signPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 50));
        guestPanel.setPreferredSize(new Dimension(100, 300));
        guestPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 0, 50));


        // Add everything to the main panel
        main.add(welcome);
        main.add(match);
        main.add(game);
        main.add(new JLabel(" "));
        main.add(signPanel);
        main.add(guestPanel);

        // Add  to the frame 
        add(main, BorderLayout.CENTER);  
    }
}
