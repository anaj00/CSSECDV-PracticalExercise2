package View;

import Controller.PasswordUtils;
import Controller.SQLite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordDialog extends JDialog {
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JCheckBox showPasswordCheckBox;
    private JButton changeButton;
    private JButton cancelButton;
    private String username;
    private SQLite sqlite;
    private boolean passwordChanged = false;

    public ChangePasswordDialog(JFrame parent, String username, SQLite sqlite) {
        super(parent, "Change Password", true);
        this.username = username;
        this.sqlite = sqlite;
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initializeComponents() {
        newPasswordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        showPasswordCheckBox = new JCheckBox("Show Password");
        changeButton = new JButton("Change");
        cancelButton = new JButton("Cancel");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Title
        JLabel titleLabel = new JLabel("Change Password for: " + username);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 14f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        mainPanel.add(titleLabel, gbc);
        
        // New Password
        gbc.gridwidth = 1; gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(new JLabel("New Password:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(newPasswordField, gbc);
        
        // Confirm Password
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(new JLabel("Confirm Password:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(confirmPasswordField, gbc);
        
        // Show Password Checkbox
        gbc.gridx = 1; gbc.gridy = 3; gbc.insets = new Insets(10, 10, 10, 5);
        mainPanel.add(showPasswordCheckBox, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(changeButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupEventHandlers() {
        showPasswordCheckBox.addActionListener(e -> {
            char echoChar = showPasswordCheckBox.isSelected() ? (char) 0 : '*';
            newPasswordField.setEchoChar(echoChar);
            confirmPasswordField.setEchoChar(echoChar);
        });

        changeButton.addActionListener(e -> changePassword());
        cancelButton.addActionListener(e -> dispose());
        
        // Enter key support
        newPasswordField.addActionListener(e -> confirmPasswordField.requestFocus());
        confirmPasswordField.addActionListener(e -> changePassword());
    }

    private void changePassword() {
        String newPassword = new String(newPasswordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        // Validate passwords match
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate password strength
        if (!PasswordUtils.isValidPassword(newPassword)) {
            JOptionPane.showMessageDialog(this, 
                "Password must be at least 8 characters long and contain:\n" +
                "- At least one uppercase letter\n" +
                "- At least one lowercase letter\n" +
                "- At least one number\n" +
                "- At least one special character", 
                "Invalid Password", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Change password
        try {
            boolean success = sqlite.changeUserPassword(username, newPassword);
            if (success) {
                // Log the password change
                sqlite.addLogs("INFO", username, "Password changed successfully", 
                    new java.sql.Timestamp(new java.util.Date().getTime()).toString());
                
                JOptionPane.showMessageDialog(this, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                passwordChanged = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Clear password fields for security
        newPasswordField.setText("");
        confirmPasswordField.setText("");
    }
    
    public boolean isPasswordChanged() {
        return passwordChanged;
    }
}
