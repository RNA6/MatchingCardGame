/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignIn extends JFrame {

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
        super("SignIn");
        Theme.setFrameProperties(this, 130, 500);

       
        createHead_label();
        add(head_label, BorderLayout.NORTH);

        
        createCenter_panel();
        createLabels_panel();
        createLabels();
        center_panel.add(labels_panel, BorderLayout.WEST);

        createInputs_panel();
        createUsername_textField();
        inputs_panel.add(username_textField);

        createPasswordField();
        inputs_panel.add(passwordField);

        center_panel.add(inputs_panel, BorderLayout.CENTER);
        add(center_panel, BorderLayout.CENTER);

       
        createBottom_panel();
        createCancel_button();
        createsignIn_button();

        bottom_panel.add(cancel_button);
        bottom_panel.add(signIn_button);
        add(bottom_panel, BorderLayout.SOUTH);

        
        username_textField.setEnabled(true);
        passwordField.setEnabled(true);

      
        cancel_button.addActionListener(e -> {
            dispose();
        });

        
        signIn_button.addActionListener(e -> {
            String username = username_textField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Please fill all fields!");
                return;
            }

            if (username.equals("admin") && password.equals("123")) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Incorrect Username or Password.");
            }
        });
    }

    private void createHead_label() {
        head_label = new JLabel("Sign In");
        head_label.setFont(new Font(Theme.fontName1, Font.BOLD, 36));
        head_label.setForeground(Theme.color_CC66DA);
        head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createCenter_panel() {
        center_panel = new JPanel();
        center_panel.setOpaque(false);
        center_panel.setLayout(new BorderLayout());
        center_panel.setPreferredSize(new Dimension(300, 300));
        center_panel.setBorder(BorderFactory.createEmptyBorder(70, 50, 0, 50));
    }

    private void createLabels_panel() {
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
            inputLabels[i].setFont(new Font(Theme.fontName1, Font.BOLD, 28));
            inputLabels[i].setPreferredSize(new Dimension(220, 30));
            inputLabels[i].setForeground(Theme.color_CC66DA);
            labels_panel.add(inputLabels[i]);
        }
    }

    private void createInputs_panel() {
        inputs_panel = new JPanel();
        inputs_panel.setOpaque(false);
        inputs_panel.setPreferredSize(new Dimension(300, 200));
        inputs_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 22));
    }

    private void createUsername_textField() {
        username_textField = new JTextField();
        username_textField.setBackground(Theme.color_F3EFEF);
        username_textField.setPreferredSize(new Dimension(280, 35));
        username_textField.setEnabled(false);
    }

    private void createPasswordField() {
        passwordField = new JPasswordField();
        passwordField.setBackground(Theme.color_F3EFEF);
        passwordField.setPreferredSize(new Dimension(280, 35));
        passwordField.setEnabled(false);
    }

    private void createBottom_panel() {
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0));
        bottom_panel.setOpaque(false);
    }

    private void createCancel_button() {
        cancel_button = new JButton("Cancel");
        cancel_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        cancel_button.setBackground(Theme.color_63C8FF);
        cancel_button.setPreferredSize(new Dimension(150, 40));
        cancel_button.setFocusable(false);
    }

    private void createsignIn_button() {
        signIn_button = new JButton("Sign In");
        signIn_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        signIn_button.setBackground(Theme.color_4DFFBE);
        signIn_button.setPreferredSize(new Dimension(150, 40));
        signIn_button.setFocusable(false);
    }
}


