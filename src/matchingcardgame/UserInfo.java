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
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author RNA
 */
public class UserInfo extends JFrame{
    
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
    
    private Box female_box;
    private Box male_box;
    
    private Icon female_icon;
    private Icon male_icon;
    
    private JRadioButton female_radioButton;
    private JRadioButton male_radioButton;
    private final ButtonGroup gender_buttonGroup;
    
    private JButton cancel_button;
    private JButton update_button;
    private JButton cancelUpdating_button;
    private JButton confirmUpdate_button;

    public UserInfo(){
        super("User Info");
        getContentPane().setBackground(Theme.color_FDFFB8);
        setBounds(300, 130, 0, 0);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);
        
        //Head Label
        createHead_label();
        add(head_label, BorderLayout.NORTH);
        
        //Beginning of Center Panel
        createCenter_panel();
        
        //Beginning of Labels Panel
        createLabels_panel();
        
        //Labels declaration
        createLabels();
        
        center_panel.add(labels_panel, BorderLayout.WEST);
        //#End of Labels Panel
        
        //Beginning of Inputs Panel
        createInputs_panel();
        
        //Username TextField
        createUsername_textField();
        inputs_panel.add(username_textField);
        
        //PasswordField
        createPasswordField();
        inputs_panel.add(passwordField);
        
        //Phone Number TextField
        createPhoneNumber_textField();
        inputs_panel.add(phoneNumber_textField);
        
        //Create Gender Button Group
        gender_buttonGroup = new ButtonGroup();
        
        //Female Box
        createFemale_box();
        
        //Female Radio Button
        createFemale_radioButton();        
        gender_buttonGroup.add(female_radioButton);
        female_box.add(female_radioButton);
        
        //Female Icon Label
        createFemaleIcon_label();
        female_box.add(femaleIcon_label);
        inputs_panel.add(female_box);
        
        //Male Box
        createMale_box();
               
        //Male Radio Button
        createMale_radioButton();
        gender_buttonGroup.add(male_radioButton);
        male_box.add(male_radioButton);
        
        //Male Icon Label
        createMaleIcon_label();
        male_box.add(maleIcon_label);
        inputs_panel.add(male_box);
        
        center_panel.add(inputs_panel, BorderLayout.CENTER);
        //#End of Inputs Panel
        
        add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel
        
        //Beginning of Bottom Panel
        createBottom_panel();
        
        //Cancel Button
        createCancel_button();
        bottom_panel.add(cancel_button);
        
        //Update Button
        createUpdate_button();
        bottom_panel.add(update_button);
        
        //Cancel Updating Button
        createCancelUpdating_button();
        bottom_panel.add(cancelUpdating_button);
        
        //Confirm Update Button
        createConfirmUpdate_button();
        bottom_panel.add(confirmUpdate_button);
        
        add(bottom_panel, BorderLayout.SOUTH);
        //#End of Bottom Panel
    }
    //Head Label Declaration
    private void createHead_label(){
        head_label = new JLabel("Update User Information");
        head_label.setFont(new Font(Theme.fontName1, Font.BOLD, 36));
        head_label.setForeground(Theme.color_CC66DA);
        head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    //Center Panel Declaration
    private void createCenter_panel(){
        center_panel = new JPanel();
        center_panel.setOpaque(false);
        center_panel.setLayout(new BorderLayout());
        center_panel.setPreferredSize(new Dimension(300, 300));
        center_panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 50));
    }
    
    //Center Panel Components
    //Labels Panel Declaration
    private void createLabels_panel(){
        labels_panel = new JPanel(); 
        labels_panel.setOpaque(false);
        labels_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0,25));
        labels_panel.setPreferredSize(new Dimension(250, 300));
        labels_panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
    }
    
    //Label Panel Components
    //Labels Declaration
    private void createLabels(){
        inputLabels = new JLabel[labelNames.length];
        
        for(int counter = 0; counter < labelNames.length; counter++){
            inputLabels[counter] = new JLabel(labelNames[counter]);
            inputLabels[counter].setFont(new Font(Theme.fontName1, Font.BOLD, 24));
            inputLabels[counter].setHorizontalAlignment(SwingConstants.LEFT);
            inputLabels[counter].setPreferredSize(new Dimension(220, 30));
            inputLabels[counter].setForeground(Theme.color_CC66DA);
            labels_panel.add(inputLabels[counter]);
        }
    }
    //#End of Label Panel Components
    
    //Inputs Panel Declaration
    private void createInputs_panel(){
        inputs_panel = new JPanel();
        inputs_panel.setOpaque(false);
        inputs_panel.setPreferredSize(new Dimension(300,200));
        inputs_panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,22));
    }
    
    //Inputs Panel Components
    //Username Text Field Declaration
    private void createUsername_textField(){
        username_textField = new JTextField();
        username_textField.setBackground(Theme.color_F3EFEF);
        username_textField.setPreferredSize(new Dimension(280,35));
        username_textField.setEnabled(false);
    }
    
    //Password Field Declaration
    private void createPasswordField(){
        passwordField = new JPasswordField();
        passwordField.setBackground(Theme.color_F3EFEF);
        passwordField.setPreferredSize(new Dimension(280,35));
        passwordField.setEnabled(false);
    }
    
    //Phone Number Declaration
    private void createPhoneNumber_textField(){
        phoneNumber_textField = new JTextField();
        phoneNumber_textField.setBackground(Theme.color_F3EFEF);
        phoneNumber_textField.setPreferredSize(new Dimension(280, 35));
        phoneNumber_textField.setEnabled(false);
    }
    
    //Female Box Declaration
    private void createFemale_box(){
        female_box = Box.createHorizontalBox();
        female_box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80));
    }
    
    //Female Box Components
    //Female Radio Button Declaration
    private void createFemale_radioButton(){
        female_radioButton = new JRadioButton();
        female_radioButton.setOpaque(false);
        female_radioButton.setEnabled(false);
        female_radioButton.setSelected(true);
    }
    
    //Female Icon Label Declaration
    private void createFemaleIcon_label(){
        female_icon = new ImageIcon(getClass().getResource("female.png"));
        femaleIcon_label = new JLabel(female_icon);
    } 
    //#End of Female Box Components    
    //#End of Inputs Panel Components
    //#End of Center Panel Components
    
    //Male Box Declaration
    private void createMale_box(){
        male_box = Box.createHorizontalBox();
        male_box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80));
    }
    
    //Male Box Components
    //Male Radio Button Declaration
    private void createMale_radioButton(){
        male_radioButton = new JRadioButton();
        male_radioButton.setOpaque(false);
        male_radioButton.setEnabled(false);
    }
    
    //Male Icon Label Declaration
    private void createMaleIcon_label(){
        male_icon = new ImageIcon(getClass().getResource("male.png"));
        maleIcon_label = new JLabel(male_icon);
    }
    //#End of Male Box Components

    //Bottom Panel Declaration
    private void createBottom_panel(){
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        bottom_panel.setOpaque(false);
    }
    
    //Bottom Panel Components
    //Cancel Button Declaration
    private void createCancel_button(){
        cancel_button = new JButton("Cancel");
        cancel_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        cancel_button.setBackground(Theme.color_63C8FF);
        cancel_button.setPreferredSize(new Dimension(150, 40));
        cancel_button.setFocusable(false);
    }
    
    //Update Button Declaration
    private void createUpdate_button(){
        update_button = new JButton("Update");
        update_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        update_button.setBackground(Theme.color_4DFFBE);
        update_button.setPreferredSize(new Dimension(150, 40));
        update_button.setFocusable(false);
    }
    
    //Cancel Updating Button Declaration
    private void createCancelUpdating_button(){
        cancelUpdating_button = new JButton("Cancel Updating");
        cancelUpdating_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        cancelUpdating_button.setBackground(Theme.color_63C8FF);
        cancelUpdating_button.setPreferredSize(new Dimension(150, 40));
        cancelUpdating_button.setFocusable(false);
        cancelUpdating_button.setVisible(false);
    }
    
    //Confirm Update Button Declaration
    private void createConfirmUpdate_button(){
        confirmUpdate_button = new JButton("Confirm Update");
        confirmUpdate_button.setFont(new Font(Theme.fontName1, Font.BOLD, 15));
        confirmUpdate_button.setBackground(Theme.color_4DFFBE);
        confirmUpdate_button.setPreferredSize(new Dimension(150, 40));
        confirmUpdate_button.setFocusable(false);
        confirmUpdate_button.setVisible(false);
    }
    //#End of Bottom Panel Components 
}
