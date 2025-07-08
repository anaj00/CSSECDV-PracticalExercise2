package View;

import Controller.SQLite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordDialog extends JDialog {
    private JTextField usernameField;
    private JButton continueButton;
    private JButton cancelButton;
    private SQLite sqlite;
    private JFrame parentFrame;

    public ForgotPasswordDialog(JFrame parent, SQLite sqlite) {
        super(parent, "Forgot Password", true);
        this.parentFrame = parent;
        this.sqlite = sqlite;
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initializeComponents() {
        usernameField = new JTextField(20);
        continueButton = new JButton("Continue");
        cancelButton = new JButton("Cancel");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Title
        JLabel titleLabel = new JLabel("Reset Password");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 15, 10, 15);
        mainPanel.add(titleLabel, gbc);
        
        // Instructions
        JLabel instructionLabel = new JLabel("<html><center>Enter your username to reset your password.</center></html>");
        gbc.gridy = 1; gbc.insets = new Insets(0, 15, 15, 15);
        mainPanel.add(instructionLabel, gbc);
        
        // Username
        gbc.gridwidth = 1; gbc.insets = new Insets(5, 15, 5, 5);
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Username:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 15);
        mainPanel.add(usernameField, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(continueButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupEventHandlers() {
        continueButton.addActionListener(e -> continueToPasswordReset());
        cancelButton.addActionListener(e -> dispose());
        
        // Enter key support
        usernameField.addActionListener(e -> continueToPasswordReset());
    }

    private void continueToPasswordReset() {
        String username = usernameField.getText().trim();
        
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if user exists
        if (!sqlite.userExists(username)) {
            JOptionPane.showMessageDialog(this, "Username not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Close this dialog and open password change dialog
        dispose();
        
        // Open change password dialog
        ChangePasswordDialog changeDialog = new ChangePasswordDialog(parentFrame, username, sqlite);
        changeDialog.setVisible(true);
        
        if (changeDialog.isPasswordChanged()) {
            JOptionPane.showMessageDialog(parentFrame, 
                "Password reset successfully! You can now login with your new password.", 
                "Password Reset Complete", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
