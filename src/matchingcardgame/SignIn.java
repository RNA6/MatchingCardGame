package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignIn extends BaseFrame {

    private JLabel head_label;
    private JLabel[] inputLabels;
    private final String[] labelNames = {"Username", "Password"};

    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel labels_panel;
    private JPanel inputs_panel;
    private JTextField username_textField;
    private JPasswordField passwordField;

    private JButton cancel_button;
    private JButton signIn_button;

    public SignIn() {
        super("Sign In", 130, 500);

     
        createHeadLabel();
        add(head_label, BorderLayout.NORTH);

        createCenterPanel();
        createLabelsPanel();
        createLabels();
        center_panel.add(labels_panel, BorderLayout.WEST);

        createInputsPanel();
        createUsernameTextField();
        inputs_panel.add(username_textField);
        createPasswordField();
        inputs_panel.add(passwordField);
        center_panel.add(inputs_panel, BorderLayout.CENTER);
        add(center_panel, BorderLayout.CENTER);

        createBottomPanel();
        createCancelButton();
        createSignInButton();
        bottom_panel.add(cancel_button);
        bottom_panel.add(signIn_button);
        add(bottom_panel, BorderLayout.SOUTH);

       
        username_textField.setEnabled(true);
        passwordField.setEnabled(true);

       
        addEventHandlers();
    }

    
    private void addEventHandlers() {
      
        UIUtilities.addNavigation(cancel_button, this, Frames.welcomePage);

       
        signIn_button.addActionListener(e -> handleSignIn());
    }

    private void handleSignIn() {
        String username = username_textField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.equals("admin") && password.equals("123")) {
           
            UIUtilities.addNavigation(signIn_button, this, Frames.dashboardPage);
            signIn_button.doClick(); 
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createHeadLabel() {
        head_label = new JLabel("Sign In");
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createCenterPanel() {
        center_panel = new JPanel();
        center_panel.setOpaque(false);
        center_panel.setLayout(new BorderLayout());
        center_panel.setPreferredSize(new Dimension(300, 300));
        center_panel.setBorder(BorderFactory.createEmptyBorder(70, 50, 0, 50));
    }

    private void createLabelsPanel() {
        labels_panel = new JPanel();
        labels_panel.setOpaque(false);
        labels_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
        labels_panel.setPreferredSize(new Dimension(250, 300));
        labels_panel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));
    }

    private void createLabels() {
        inputLabels = new JLabel[labelNames.length];
        for (int i = 0; i < labelNames.length; i++) {
            inputLabels[i] = new JLabel(labelNames[i]);
            inputLabels[i].setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
            inputLabels[i].setPreferredSize(new Dimension(220, 30));
            inputLabels[i].setForeground(UITheme.color_CC66DA);
            labels_panel.add(inputLabels[i]);
        }
    }

    private void createInputsPanel() {
        inputs_panel = new JPanel();
        inputs_panel.setOpaque(false);
        inputs_panel.setPreferredSize(new Dimension(300, 200));
        inputs_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 22));
    }

    private void createUsernameTextField() {
        username_textField = new JTextField();
        username_textField.setBackground(UITheme.color_F3EFEF);
        username_textField.setPreferredSize(new Dimension(280, 35));
    }

    private void createPasswordField() {
        passwordField = new JPasswordField();
        passwordField.setBackground(UITheme.color_F3EFEF);
        passwordField.setPreferredSize(new Dimension(280, 35));
    }

    private void createBottomPanel() {
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0));
        bottom_panel.setOpaque(false);
    }

    private void createCancelButton() {
        cancel_button = new JButton("Cancel");
        cancel_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 15));
        cancel_button.setBackground(UITheme.color_63C8FF);
        cancel_button.setPreferredSize(new Dimension(150, 40));
        cancel_button.setFocusable(false);
    }

    private void createSignInButton() {
        signIn_button = new JButton("Sign In");
        signIn_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 15));
        signIn_button.setBackground(UITheme.color_4DFFBE);
        signIn_button.setPreferredSize(new Dimension(150, 40));
        signIn_button.setFocusable(false);
    }

   
    public JButton getCancel_button() {
        return cancel_button;
    }

    public JButton getSignIn_button() {
        return signIn_button;
    }
}



