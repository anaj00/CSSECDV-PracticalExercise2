package View;

import Controller.Main;
import Controller.RoleManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.*;

public class Frame extends javax.swing.JFrame {
    private Model.User currentUser;

    public void setCurrentUser(Model.User user) {
        this.currentUser = user;
    }

    public Model.User getCurrentUser() {
        return this.currentUser;
    }

    public Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        HomePnl = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        Navigation = new javax.swing.JPanel();
        adminBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        managerBtn = new javax.swing.JButton();
        staffBtn = new javax.swing.JButton();
        clientBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 450));

        HomePnl.setBackground(new java.awt.Color(102, 102, 102));
        HomePnl.setPreferredSize(new java.awt.Dimension(801, 500));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Navigation.setBackground(new java.awt.Color(204, 204, 204));

        adminBtn.setBackground(new java.awt.Color(250, 250, 250));
        adminBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminBtn.setText("Admin Home");
        adminBtn.setFocusable(false);
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        managerBtn.setBackground(new java.awt.Color(250, 250, 250));
        managerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managerBtn.setText("Manager Home");
        managerBtn.setFocusable(false);
        managerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerBtnActionPerformed(evt);
            }
        });

        staffBtn.setBackground(new java.awt.Color(250, 250, 250));
        staffBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffBtn.setText("Staff Home");
        staffBtn.setFocusable(false);
        staffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBtnActionPerformed(evt);
            }
        });

        clientBtn.setBackground(new java.awt.Color(250, 250, 250));
        clientBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clientBtn.setText("Client Home");
        clientBtn.setFocusable(false);
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(250, 250, 250));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(managerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HomePnlLayout = new javax.swing.GroupLayout(HomePnl);
        HomePnl.setLayout(HomePnlLayout);
        HomePnlLayout.setHorizontalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePnlLayout.createSequentialGroup()
                .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomePnlLayout.setVerticalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        if (currentUser != null && RoleManager.canAccess(currentUser.getRole(), RoleManager.ADMIN)) {
            adminHomePnl.showPnl("home");
            contentView.show(Content, "adminHomePnl");
        } else {
            showAccessDeniedMessage("Admin");
        }
    }//GEN-LAST:event_adminBtnActionPerformed

    private void managerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerBtnActionPerformed
        if (currentUser != null && RoleManager.canAccess(currentUser.getRole(), RoleManager.MANAGER)) {
            managerHomePnl.showPnl("home");
            contentView.show(Content, "managerHomePnl");
        } else {
            showAccessDeniedMessage("Manager");
        }
    }//GEN-LAST:event_managerBtnActionPerformed

    private void staffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBtnActionPerformed
        if (currentUser != null && RoleManager.canAccess(currentUser.getRole(), RoleManager.STAFF)) {
            staffHomePnl.showPnl("home");
            contentView.show(Content, "staffHomePnl");
        } else {
            showAccessDeniedMessage("Staff");
        }
    }//GEN-LAST:event_staffBtnActionPerformed

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        if (currentUser != null && RoleManager.canAccess(currentUser.getRole(), RoleManager.CLIENT)) {
            clientHomePnl.showPnl("home");
            contentView.show(Content, "clientHomePnl");
        } else {
            showAccessDeniedMessage("Client");
        }
    }//GEN-LAST:event_clientBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        currentUser = null; // Clear current user session
        updateNavigationForRole(0); // Hide all navigation buttons
        frameView.show(Container, "loginPnl");
    }//GEN-LAST:event_logoutBtnActionPerformed

    public Main main;
    public Login loginPnl = new Login();
    public Register registerPnl = new Register();
    
    private AdminHome adminHomePnl = new AdminHome();
    private ManagerHome managerHomePnl = new ManagerHome();
    private StaffHome staffHomePnl = new StaffHome();
    private ClientHome clientHomePnl = new ClientHome();
    
    private CardLayout contentView = new CardLayout();
    private CardLayout frameView = new CardLayout();
    
    public void init(Main controller){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("CSSECDV - SECURITY Svcs");
        this.setLocationRelativeTo(null);
        
        this.main = controller;
        loginPnl.frame = this;
        registerPnl.frame = this;
        
        adminHomePnl.init(main.sqlite);
        clientHomePnl.init(main.sqlite);
        managerHomePnl.init(main.sqlite);
        staffHomePnl.init(main.sqlite);
        
        Container.setLayout(frameView);
        Container.add(loginPnl, "loginPnl");
        Container.add(registerPnl, "registerPnl");
        Container.add(HomePnl, "homePnl");
        frameView.show(Container, "loginPnl");
        
        Content.setLayout(contentView);
        Content.add(adminHomePnl, "adminHomePnl");
        Content.add(managerHomePnl, "managerHomePnl");
        Content.add(staffHomePnl, "staffHomePnl");
        Content.add(clientHomePnl, "clientHomePnl");
        
        this.setVisible(true);
    }
    
    /**
     * Update navigation buttons visibility based on user role
     * Implements role-based access control for UI elements
     */
    public void updateNavigationForRole(int userRole) {
        // Show buttons based on role permissions
        adminBtn.setVisible(RoleManager.canAccess(userRole, RoleManager.ADMIN));
        managerBtn.setVisible(RoleManager.canAccess(userRole, RoleManager.MANAGER));
        staffBtn.setVisible(RoleManager.canAccess(userRole, RoleManager.STAFF));
        clientBtn.setVisible(RoleManager.canAccess(userRole, RoleManager.CLIENT));
        
        if (currentUser != null) {
            jLabel1.setText("SECURITY Svcs - " + RoleManager.getRoleName(userRole));
        } else {
            jLabel1.setText("SECURITY Svcs");
        }
        
        showDefaultPanelForRole(userRole);
    }
    
    private void showDefaultPanelForRole(int userRole) {
        if (userRole >= RoleManager.ADMIN) {
            adminHomePnl.showPnl("home");
            contentView.show(Content, "adminHomePnl");
        } else if (userRole >= RoleManager.MANAGER) {
            managerHomePnl.showPnl("home");
            contentView.show(Content, "managerHomePnl");
        } else if (userRole >= RoleManager.STAFF) {
            staffHomePnl.showPnl("home");
            contentView.show(Content, "staffHomePnl");
        } else if (userRole >= RoleManager.CLIENT) {
            clientHomePnl.showPnl("home");
            contentView.show(Content, "clientHomePnl");
        }
    }
    
    /**
     * Show access denied message when user tries to access unauthorized area
     */
    private void showAccessDeniedMessage(String attemptedArea) {
        String userRole = currentUser != null ? RoleManager.getRoleName(currentUser.getRole()) : "Unknown";
        String message = String.format(
            "Access Denied!\n\nYou (%s) do not have permission to access %s area.\n\nContact your administrator if you believe this is an error.",
            userRole, attemptedArea
        );
        JOptionPane.showMessageDialog(this, message, "Access Denied", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Enhanced main navigation with user role setup
     */
    public void mainNav() {
        if (currentUser != null) {
            updateNavigationForRole(currentUser.getRole());
        }
        frameView.show(Container, "homePnl");
    }
    
    public void loginNav(){
        frameView.show(Container, "loginPnl");
    }
    
    public void registerNav(){
        frameView.show(Container, "registerPnl");
    }

    // Removed confirmation of password.
    public void registerAction(String username, String password){
        try {
            main.sqlite.addUser(username, password, 2);
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Registration failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public void showUsersPanel() {
        if (currentUser != null && RoleManager.canManageUsers(currentUser.getRole())) {
            // Navigate to users management
            if (currentUser.getRole() >= RoleManager.ADMIN) {
                adminHomePnl.showPnl("users");
                contentView.show(Content, "adminHomePnl");
            }
        } else {
            showAccessDeniedMessage("Users Management");
        }
    }
    
 
    public void showProductsManagementPanel() {
        if (currentUser != null && RoleManager.canManageProducts(currentUser.getRole())) {
            // Navigate to products management
            if (currentUser.getRole() >= RoleManager.ADMIN) {
                adminHomePnl.showPnl("products");
                contentView.show(Content, "adminHomePnl");
            } else if (currentUser.getRole() >= RoleManager.MANAGER) {
                managerHomePnl.showPnl("products");
                contentView.show(Content, "managerHomePnl");
            }
        } else {
            showAccessDeniedMessage("Products Management");
        }
    }
    

    public void showProductsCatalogPanel() {
        if (currentUser != null && RoleManager.canViewProducts(currentUser.getRole())) {
            // Navigate to appropriate products view based on role
            if (currentUser.getRole() >= RoleManager.ADMIN) {
                adminHomePnl.showPnl("products");
                contentView.show(Content, "adminHomePnl");
            } else if (currentUser.getRole() >= RoleManager.MANAGER) {
                managerHomePnl.showPnl("products");
                contentView.show(Content, "managerHomePnl");
            } else if (currentUser.getRole() >= RoleManager.STAFF) {
                staffHomePnl.showPnl("products");
                contentView.show(Content, "staffHomePnl");
            } else if (currentUser.getRole() >= RoleManager.CLIENT) {
                clientHomePnl.showPnl("products");
                contentView.show(Content, "clientHomePnl");
            }
        } else {
            showAccessDeniedMessage("Products Catalog");
        }
    }
    

    public void showHistoryPanel() {
        if (currentUser != null && RoleManager.canViewHistory(currentUser.getRole())) {
            // Navigate to appropriate history view based on role
            if (currentUser.getRole() >= RoleManager.ADMIN) {
                adminHomePnl.showPnl("history");
                contentView.show(Content, "adminHomePnl");
            } else if (currentUser.getRole() >= RoleManager.MANAGER) {
                managerHomePnl.showPnl("history");
                contentView.show(Content, "managerHomePnl");
            } else if (currentUser.getRole() >= RoleManager.STAFF) {
                staffHomePnl.showPnl("history");
                contentView.show(Content, "staffHomePnl");
            } else if (currentUser.getRole() >= RoleManager.CLIENT) {
                clientHomePnl.showPnl("history");
                contentView.show(Content, "clientHomePnl");
            }
        } else {
            showAccessDeniedMessage("Purchase History");
        }
    }
    

    public void showLogsPanel() {
        if (currentUser != null && RoleManager.canViewLogs(currentUser.getRole())) {
            // Navigate to appropriate logs view based on role
            if (currentUser.getRole() >= RoleManager.ADMIN) {
                adminHomePnl.showPnl("logs");
                contentView.show(Content, "adminHomePnl");
            } else if (currentUser.getRole() >= RoleManager.MANAGER) {
                managerHomePnl.showPnl("logs");
                contentView.show(Content, "managerHomePnl");
            } else if (currentUser.getRole() >= RoleManager.STAFF) {
                staffHomePnl.showPnl("logs");
                contentView.show(Content, "staffHomePnl");
            }
        } else {
            showAccessDeniedMessage("System Logs");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel HomePnl;
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton adminBtn;
    private javax.swing.JButton clientBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton managerBtn;
    private javax.swing.JButton staffBtn;
    // End of variables declaration//GEN-END:variables
}
