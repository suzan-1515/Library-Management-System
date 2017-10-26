/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.dashboard;

import com.nepal.lms.ui.book.LibrarianBookPanel;
import com.nepal.lms.util.ComponentUtils;
import com.nepal.lms.util.Logy;

/**
 *
 * @author Suzn
 */
public class LibrarianDashboard extends javax.swing.JFrame {

    private LibrarianBookPanel librarianBookPanel;

    /**
     * Creates new form LibrarianDashboard
     */
    public LibrarianDashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rootPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bookMenuButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        userMenuButton = new javax.swing.JButton();
        logoutButtonPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Knowledgica - Librarian Panel");
        getContentPane().setLayout(new java.awt.CardLayout());

        rootPanel.setBackground(new java.awt.Color(255, 255, 255));
        rootPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(39, 26, 252));
        topPanel.setLayout(new java.awt.GridLayout(1, 1, 10, 10));

        titlePanel.setBackground(new java.awt.Color(39, 26, 252));
        titlePanel.setPreferredSize(new java.awt.Dimension(508, 145));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jPanel2.setBackground(new java.awt.Color(39, 26, 252));
        jPanel2.setPreferredSize(new java.awt.Dimension(430, 135));

        jPanel1.setBackground(new java.awt.Color(39, 26, 252));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Knowledgica");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Library Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        logo.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        titlePanel.add(jPanel2);

        topPanel.add(titlePanel);

        rootPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setMinimumSize(new java.awt.Dimension(300, 10));
        centerPanel.setPreferredSize(new java.awt.Dimension(500, 10));
        centerPanel.setLayout(new java.awt.CardLayout());
        rootPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        leftPanel.setBackground(new java.awt.Color(204, 204, 204));
        leftPanel.setMinimumSize(new java.awt.Dimension(150, 10));
        leftPanel.setPreferredSize(new java.awt.Dimension(180, 412));
        leftPanel.setLayout(new java.awt.CardLayout(5, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        bookMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        bookMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bookMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        bookMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        bookMenuButton.setText("Book");
        bookMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(bookMenuButton);
        bookMenuButton.setContentAreaFilled(false);
        bookMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookMenuButton.setIconTextGap(10);
        bookMenuButton.setMargin(new java.awt.Insets(2, 15, 2, 14));
        bookMenuButton.setOpaque(true);
        bookMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        bookMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book1x.png"))); // NOI18N
        bookMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 0, 0)));
                userMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
                bookMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(136, 70));

        userMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        userMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        userMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        userMenuButton.setText("User");
        userMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(userMenuButton);
        userMenuButton.setContentAreaFilled(false);
        userMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userMenuButton.setIconTextGap(10);
        userMenuButton.setOpaque(true);
        userMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        userMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user1x.png"))); // NOI18N
        userMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMenuButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 0, 0)));
                bookMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
                userMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel4);

        logoutButtonPanel.setBackground(new java.awt.Color(255, 255, 255));

        logoutButton.setBackground(new java.awt.Color(255, 82, 36));
        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        logoutButton.setContentAreaFilled(false);
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutButton.setIconTextGap(10);
        logoutButton.setOpaque(true);
        logoutButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logoutButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout1x.png"))); // NOI18N

        javax.swing.GroupLayout logoutButtonPanelLayout = new javax.swing.GroupLayout(logoutButtonPanel);
        logoutButtonPanel.setLayout(logoutButtonPanelLayout);
        logoutButtonPanelLayout.setHorizontalGroup(
            logoutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoutButtonPanelLayout.setVerticalGroup(
            logoutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutButtonPanelLayout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(logoutButtonPanel);

        leftPanel.add(jPanel6, "card2");

        rootPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        getContentPane().add(rootPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Book menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getLibrarianBookPanel());
    }

    private void userMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibrarianDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LibrarianDashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookMenuButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel logoutButtonPanel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton userMenuButton;
    // End of variables declaration//GEN-END:variables

    private LibrarianBookPanel getLibrarianBookPanel() {
        if (librarianBookPanel == null) {
            Logy.d("Creating librarian panel instance");
            librarianBookPanel = new LibrarianBookPanel();
        }

        return librarianBookPanel;
    }
}
