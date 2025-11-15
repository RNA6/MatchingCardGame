package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< Updated upstream
=======
import javax.swing.Action;
>>>>>>> Stashed changes
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class SignUp extends BaseFrame {

    private JLabel head_label;
    private JLabel[] inputLabels;
    private JLabel femaleIcon_label;
    private JLabel maleIcon_label;

    private final String[] labelNames = {"Username", "Password", "Phone Number", "Gender"};

    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel labels_panel;
    private JPanel inputs_panel;

    private JTextField username_textField;
    private JTextField phoneNumber_textField;
    private JPasswordField passwordField;

    private JRadioButton female_radioButton;
    private JRadioButton male_radioButton;
    private final ButtonGroup gender_buttonGroup;

    private Box female_box;
    private Box male_box;

    private JButton cancel_button;
    private JButton submit_button;

    private Icon female_icon;
    private Icon male_icon;

    public SignUp() {
        super("SignUp", 130, 500);

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

        createPhoneNumber_textField();
        inputs_panel.add(phoneNumber_textField);

       
        gender_buttonGroup = new ButtonGroup();

       
        createFemale_box();

       
        createFemale_radioButton();
        gender_buttonGroup.add(female_radioButton);
        female_box.add(female_radioButton);

       
        createFemaleIcon_label();
        female_box.add(femaleIcon_label);
        inputs_panel.add(female_box);

      
        createMale_box();

        
        createMale_radioButton();
        gender_buttonGroup.add(male_radioButton);
        male_box.add(male_radioButton);

       
        createMaleIcon_label();
        male_box.add(maleIcon_label);
        inputs_panel.add(male_box);

        center_panel.add(inputs_panel, BorderLayout.CENTER);
        add(center_panel, BorderLayout.CENTER);

        createBottom_panel();
        createCancel_button();
        createSubmit_button();
        bottom_panel.add(cancel_button);
        bottom_panel.add(submit_button);
        add(bottom_panel, BorderLayout.SOUTH);
<<<<<<< Updated upstream

       
=======
        
>>>>>>> Stashed changes
        addEventHandlers();
    }
    
    private void createHead_label() 
    { head_label = new JLabel("Sign Up");
    head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36)); 
    head_label.setForeground(UITheme.color_CC66DA);
    head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
    head_label.setHorizontalAlignment(SwingConstants.CENTER); }

    
    private void createCenter_panel() { 
        center_panel = new JPanel();
        center_panel.setOpaque(false); 
        center_panel.setLayout(new BorderLayout());
        center_panel.setPreferredSize(new Dimension(300, 300)); 
        center_panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50)); }
    
    private void createLabels_panel() {
        labels_panel = new JPanel();
        labels_panel.setOpaque(false);
        labels_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
        labels_panel.setPreferredSize(new Dimension(250, 300)); 
        labels_panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0)); }
    
    private void createLabels() { 
        inputLabels = new JLabel[labelNames.length]; 
        for (int i = 0; i < labelNames.length; i++) { 
            inputLabels[i] = new JLabel(labelNames[i]); 
            inputLabels[i].setFont(new Font(UITheme.fontName1, Font.BOLD, 24)); 
            inputLabels[i].setPreferredSize(new Dimension(220, 30));
            inputLabels[i].setForeground(UITheme.color_CC66DA);
            labels_panel.add(inputLabels[i]); } }
    
    private void createInputs_panel() { 
        inputs_panel = new JPanel();
        inputs_panel.setOpaque(false); 
        inputs_panel.setPreferredSize(new Dimension(300, 200)); 
        inputs_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 22)); }
    
    private void createUsername_textField() {
        username_textField = new JTextField();
        username_textField.setBackground(UITheme.color_F3EFEF); 
        username_textField.setPreferredSize(new Dimension(280, 35));
        username_textField.setEnabled(false); }
    
    private void createPasswordField() {
        passwordField = new JPasswordField(); 
        passwordField.setBackground(UITheme.color_F3EFEF); 
        passwordField.setPreferredSize(new Dimension(280, 35)); 
        passwordField.setEnabled(false); }
    
    private void createPhoneNumber_textField() {
        phoneNumber_textField = new JTextField();
        phoneNumber_textField.setBackground(UITheme.color_F3EFEF);
        phoneNumber_textField.setPreferredSize(new Dimension(280, 35)); 
        phoneNumber_textField.setEnabled(false); } 
    private void createFemale_box(){
        female_box = Box.createHorizontalBox();
        female_box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80)); }
    
  private void createFemale_radioButton(){ 
      female_radioButton = new JRadioButton();
      female_radioButton.setOpaque(false); 
      female_radioButton.setEnabled(false); 
      female_radioButton.setSelected(true); } 
  
 private void createFemaleIcon_label(){ 
     female_icon = new ImageIcon(getClass().getResource("female.png"));
     femaleIcon_label = new JLabel(female_icon); }

 
 private void createMale_box(){ 
     male_box = Box.createHorizontalBox();
     male_box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80)); } 
 
 
 private void createMale_radioButton(){ 
     male_radioButton = new JRadioButton(); 
     male_radioButton.setOpaque(false); 
     male_radioButton.setEnabled(false); } 
 
 
 private void createMaleIcon_label(){
     male_icon = new ImageIcon(getClass().getResource("male.png"));
     maleIcon_label = new JLabel(male_icon); } 
 
 private void createBottom_panel() { 
     bottom_panel = new JPanel();
     bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0)); 
     bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
     bottom_panel.setOpaque(false); }
 
 
 private void createCancel_button() { 
cancel_button = new JButton("Cancel");
cancel_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 15));
cancel_button.setBackground(UITheme.color_63C8FF); 
cancel_button.setPreferredSize(new Dimension(150, 40));
cancel_button.setFocusable(false); } 

private void createSubmit_button() { 
submit_button = new JButton("Submit");
submit_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 15));
submit_button.setBackground(UITheme.color_4DFFBE);
submit_button.setPreferredSize(new Dimension(150, 40)); submit_button.setFocusable(false); } }
    
    private void addEventHandlers() {
        
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

       
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        
        female_radioButton.addActionListener(e -> enableFields());
        male_radioButton.addActionListener(e -> enableFields());
    }

    private void enableFields() {
        username_textField.setEnabled(true);
        passwordField.setEnabled(true);
        phoneNumber_textField.setEnabled(true);
        female_radioButton.setEnabled(true);
        male_radioButton.setEnabled(true);
    }
<<<<<<< Updated upstream
=======
    
     private void addEventHandlers() {
        // Cancel Button Action
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

       
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

       
        female_radioButton.addActionListener(e -> enableFields());
        male_radioButton.addActionListener(e -> enableFields());
    }

    private void enableFields() {
        username_textField.setEnabled(true);
        passwordField.setEnabled(true);
        phoneNumber_textField.setEnabled(true);
        female_radioButton.setEnabled(true);
        male_radioButton.setEnabled(true);
    }
>>>>>>> Stashed changes

    private void clearFields() {
        username_textField.setText("");
        passwordField.setText("");
        phoneNumber_textField.setText("");
        gender_buttonGroup.clearSelection();
<<<<<<< Updated upstream
        female_radioButton.setSelected(true); 
=======
        female_radioButton.setSelected(true);
>>>>>>> Stashed changes
    }

    private void submitForm() {
        String username = username_textField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String phone = phoneNumber_textField.getText().trim();
        String gender = female_radioButton.isSelected() ? "Female" : "Male";

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        JOptionPane.showMessageDialog(this,
                "Username: " + username +
                "\nPassword: " + password +
                "\nPhone: " + phone +
                "\nGender: " + gender,
                "Form Submitted",
                JOptionPane.INFORMATION_MESSAGE);
    }
<<<<<<< Updated upstream

   
}
=======
}
>>>>>>> Stashed changes
