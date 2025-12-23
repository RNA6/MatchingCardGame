package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
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

    private Connection connection;

    public SignIn() {
        super("Sign In", 130, 500);

        connectToDatabase();

        // ===== Header =====
        createHead_label();
        add(head_label, BorderLayout.NORTH);

        // ===== Center =====
        createCenter_panel();
        createLabels_panel();
        createLabels();
        center_panel.add(labels_panel, BorderLayout.WEST);

        createInputs_panel();
        createUsername_textField();
        createPasswordField();
        inputs_panel.add(username_textField);
        inputs_panel.add(passwordField);

        center_panel.add(inputs_panel, BorderLayout.CENTER);
        add(center_panel, BorderLayout.CENTER);

        // ===== Bottom =====
        createBottom_panel();
        createCancel_button();
        createSignIn_button();
        bottom_panel.add(cancel_button);
        bottom_panel.add(signIn_button);
        add(bottom_panel, BorderLayout.SOUTH);

        // ===== Event Handlers =====
        addEventHandlers();
    }

    // ================= EVENTS =================
    private void addEventHandlers() {
        
        signIn_button.addActionListener(e -> signIn());
        
    }

    private void signIn() {

        String username = username_textField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields!",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "SELECT isAdmin FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Sign In Successful!");
                // Navigation to next frame is handled by UIUtilities
            } else {
                JOptionPane.showMessageDialog(this,
                        "Incorrect Username or Password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ================= DATABASE =================
    private void connectToDatabase() {
        try {
            String db_url = "jdbc:mysql://localhost:3306/matcingcardgame?serverTimezone=UTC";
            String db_username = "root";
            String db_password = "#"; // عدليها حسب كلمة المرور عندك

            connection = DriverManager.getConnection(db_url, db_username, db_password);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Cannot connect to database",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ================= UI COMPONENTS =================
    private void createHead_label() {
        head_label = new JLabel("Sign In");
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 36));
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createCenter_panel() {
        center_panel = new JPanel(new BorderLayout());
        center_panel.setOpaque(false);
        center_panel.setBorder(BorderFactory.createEmptyBorder(70, 50, 0, 50));
    }

    private void createLabels_panel() {
        labels_panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 25));
        labels_panel.setOpaque(false);
    }

    private void createLabels() {
        inputLabels = new JLabel[labelNames.length];
        for (int i = 0; i < labelNames.length; i++) {
            inputLabels[i] = new JLabel(labelNames[i]);
            inputLabels[i].setFont(new Font(UITheme.fontName1, Font.BOLD, 28));
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

    private void createBottom_panel() {
        bottom_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        bottom_panel.setOpaque(false);
    }

    private void createCancel_button() {
        cancel_button = new JButton("Cancel");
        cancel_button.setPreferredSize(new Dimension(150, 40));
    }

    private void createSignIn_button() {
        signIn_button = new JButton("Sign In");
        signIn_button.setPreferredSize(new Dimension(150, 40));
    }

    // ===== Getters =====
    public JButton getCancel_button() {
        return cancel_button;
    }

    public JButton getSignIn_button() {
        return signIn_button;
    }

    public boolean userInfoExists() {
        // يمكن تعديل هذا حسب قاعدة البيانات
        return !username_textField.getText().isEmpty() && !passwordField.getText().isEmpty();
    }

    public void handleSignIn() {
        JOptionPane.showMessageDialog(this,
                "Incorrect Username or Password",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
