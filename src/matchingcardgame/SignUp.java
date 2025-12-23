package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class SignUp extends BaseFrame {

    private JLabel head_label;
    private JLabel[] inputLabels;
    private JLabel femaleIcon_label;
    private JLabel maleIcon_label;

    private final String[] labelNames = {
        "Username", "Password", "Phone Number", "Gender"
    };

    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel labels_panel;
    private JPanel inputs_panel;

    private JTextField username_textField;
    private JTextField phoneNumber_textField;
    private JPasswordField passwordField;

    private JRadioButton female_radioButton;
    private JRadioButton male_radioButton;
    private ButtonGroup gender_buttonGroup;

    private Box female_box;
    private Box male_box;

    private JButton cancel_button;
    private JButton submit_button;

    private Icon female_icon;
    private Icon male_icon;

    private Connection connection;

    public SignUp() {
        super("Sign Up", 130, 500);

        connectToDatabase();

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

        // Gender
        gender_buttonGroup = new ButtonGroup();

        createFemale_box();
        createFemale_radioButton();
        createFemaleIcon_label();
        gender_buttonGroup.add(female_radioButton);
        female_box.add(female_radioButton);
        female_box.add(femaleIcon_label);
        inputs_panel.add(female_box);

        createMale_box();
        createMale_radioButton();
        createMaleIcon_label();
        gender_buttonGroup.add(male_radioButton);
        male_box.add(male_radioButton);
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

        addEventHandlers();
    }

    // ================= DATABASE =================
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/matcingcardgame?serverTimezone=UTC";
            String user = "root";
            String pass = "#";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Database connection failed");
        }
    }

    // ================= EVENT HANDLERS =================
    private void addEventHandlers() {
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = username_textField.getText();
        String password = new String(passwordField.getPassword());
        String phone = phoneNumber_textField.getText();
        String gender = female_radioButton.isSelected() ? "F" : "M";

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields");
            return;
        }

        String sql = "INSERT INTO users (username, password, phoneNumber, gender) "
                   + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setString(4, gender);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Account created successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Username already exists!");
        }
    }

    // ================= UI COMPONENTS =================
    private void createHead_label() {
        head_label = new JLabel("Sign Up");
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createCenter_panel() {
        center_panel = new JPanel(new BorderLayout());
        center_panel.setOpaque(false);
        center_panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
    }

    private void createLabels_panel() {
        labels_panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 25));
        labels_panel.setOpaque(false);
    }

    private void createLabels() {
        inputLabels = new JLabel[labelNames.length];
        for (int i = 0; i < labelNames.length; i++) {
            inputLabels[i] = new JLabel(labelNames[i]);
            inputLabels[i].setFont(new Font(UITheme.fontName1, Font.BOLD, 24));
            inputLabels[i].setForeground(UITheme.color_CC66DA);
            labels_panel.add(inputLabels[i]);
        }
    }

    private void createInputs_panel() {
        inputs_panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 22));
        inputs_panel.setOpaque(false);
    }

    private void createUsername_textField() {
        username_textField = new JTextField();
        username_textField.setPreferredSize(new Dimension(280, 35));
    }

    private void createPasswordField() {
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(280, 35));
    }

    private void createPhoneNumber_textField() {
        phoneNumber_textField = new JTextField();
        phoneNumber_textField.setPreferredSize(new Dimension(280, 35));
    }

    private void createFemale_box() {
        female_box = Box.createHorizontalBox();
    }

    private void createMale_box() {
        male_box = Box.createHorizontalBox();
    }

    private void createFemale_radioButton() {
        female_radioButton = new JRadioButton();
        female_radioButton.setOpaque(false);
    }

    private void createMale_radioButton() {
        male_radioButton = new JRadioButton();
        male_radioButton.setOpaque(false);
        male_radioButton.setSelected(true);
    }

    private void createFemaleIcon_label() {
        female_icon = new ImageIcon(getClass().getResource("female.png"));
        femaleIcon_label = new JLabel(female_icon);
    }

    private void createMaleIcon_label() {
        male_icon = new ImageIcon(getClass().getResource("male.png"));
        maleIcon_label = new JLabel(male_icon);
    }

    private void createBottom_panel() {
        bottom_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        bottom_panel.setOpaque(false);
    }

    private void createCancel_button() {
        cancel_button = new JButton("Cancel");
        cancel_button.setPreferredSize(new Dimension(150, 40));
    }

    private void createSubmit_button() {
        submit_button = new JButton("Submit");
        submit_button.setPreferredSize(new Dimension(150, 40));
    }

    // ================= GETTERS =================
    public JButton getCancel_button() {
        return cancel_button;
    }

    public JButton getSubmit_button() {
        return submit_button;
    }
}
