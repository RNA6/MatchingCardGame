
package matchingcardgame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends BaseFrame{
    
    private JPanel signPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    private JPanel guestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15, 0));
    
    private JLabel welcome = new JLabel("WELCOME TO THE",JLabel.CENTER);
    private JLabel match = new JLabel("MATCHING",JLabel.CENTER);
    private JLabel game = new JLabel("CARDS GAME",JLabel.CENTER);
    private JLabel join = new JLabel("or join us as:",JLabel.CENTER);
    
    private JButton signin = new JButton("Sign In");
    private JButton signup = new JButton("Sign Up");
    private JButton guest = new JButton("Guest");
        
    public WelcomePage(){
        super("matching cards game", 130, 500);
        setLayout(new GridLayout(6, 1));
        
        signPanel.setOpaque(false);
        guestPanel.setOpaque(false);
        
        //title labels
        welcome.setFont(new Font(UITheme.fontName2, Font.BOLD, 36));
        welcome.setForeground(UITheme.color_CC66DA);
        welcome.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        match.setFont(new Font(UITheme.fontName1, Font.BOLD, 70));
        match.setForeground(UITheme.color_FF2DD1);
        match.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        game.setFont(new Font(UITheme.fontName1, Font.BOLD, 70));
        game.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        game.setForeground(UITheme.color_FF2DD1);
        game.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //or join us as a guist label color black
        join.setFont(new Font(UITheme.fontName1, Font.BOLD, 12));
        join.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //Buttons
        signin.setBackground(UITheme.color_63C8FF);
        signin.setFont(new Font(UITheme.fontName2, Font.BOLD, 18));
        signin.setFocusPainted(false);

        signup.setBackground(UITheme.color_CC66DA);
        signup.setFont(new Font(UITheme.fontName2, Font.BOLD, 18));
        signup.setFocusPainted(false);

        guest.setBackground(UITheme.color_4DFFBE);
        guest.setFont(new Font(UITheme.fontName2, Font.BOLD, 18));
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
        
//        UIUtilities.addNavigation(guest, this, Frames.homePage);
//        guest.addActionListener(e -> {
//            dispose();
//            new HomePage().setVisible(true);
//        });
//        
//        UIUtilities.addNavigation(signup, this, new SignUp());
//        signup.addActionListener(e -> {
//            dispose();
//            new SignUp().setVisible(true);
//        });
//        
//        UIUtilities.addNavigation(signin, this, new SignIn());
//        signin.addActionListener(e -> {
//            dispose();
//            new SignIn().setVisible(true);
//        });
        
    }

    public JButton getSignin() {
        return signin;
    }

    public JButton getSignup() {
        return signup;
    }

    public JButton getGuest() {
        return guest;
    }
    
}
