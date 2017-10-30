/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.user;

import com.nepal.lms.action.UserListener;
import com.nepal.lms.bll.UserBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.ui.BaseUserPanel;
import com.nepal.lms.util.Logy;
import com.nepal.lms.view.UserView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @user Suzn
 */
public final class UserPanel extends BaseUserPanel implements UserView {

    private List<UserInfo> userList;
    private UserListener userListener;

    /**
     * Creates new form LibrarianBookPanel
     *
     * @param userInfo
     */
    public UserPanel(UserInfo userInfo) {
        initComponents();
        setupUserView(userInfo);
        userList = new ArrayList<>();
        Logy.d("Librarian user panel initialized");
        this.loadTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        centerSubPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addUserButton = new javax.swing.JButton();
        updateUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(249, 249, 249));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(367, 80));
        topPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(120, 60));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("User");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        topPanel.add(titlePanel);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setLayout(new java.awt.CardLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        searchPanel.setBackground(new java.awt.Color(249, 249, 249));
        searchPanel.setPreferredSize(new java.awt.Dimension(367, 70));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        searchPanel.setLayout(flowLayout1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 65));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_blue.png"))); // NOI18N

        searchTextField.setBackground(new java.awt.Color(249, 249, 249));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setToolTipText("Search for title, publisher, author..");
        searchTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 26, 252)));
        searchTextField.setMinimumSize(new java.awt.Dimension(200, 15));
        searchTextField.setOpaque(false);
        searchTextField.setPreferredSize(new java.awt.Dimension(200, 15));
        searchTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String text = searchTextField.getText();
                System.out.println(text);
                if (text.trim().length() == 0) {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(null);
                } else {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(javax.swing.RowFilter.regexFilter("^(?i)" + text));
                }
                table.repaint();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                String text = searchTextField.getText();
                if (text.trim().length() == 0) {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(null);
                } else {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(javax.swing.RowFilter.regexFilter("^(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                //not needed: throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        searchPanel.add(jPanel2);

        jPanel4.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        centerSubPanel.setLayout(new java.awt.CardLayout());

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        tableModel.addColumn(com.nepal.lms.entity.user.UserParams.ID.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.user.UserParams.NAME.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.user.UserParams.USERNAME.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.user.UserParams.PASSWORD.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.user.UserParams.ROLE.toUpperCase());
        table.setModel(tableModel);
        table.setRowHeight(26);
        table.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(table);
        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> rowSorter = new javax.swing.table.TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        centerSubPanel.add(jScrollPane1, "card2");

        jPanel4.add(centerSubPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jPanel3.setOpaque(false);

        addUserButton.setText("Add New");
        addUserButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addUserButton.setPreferredSize(new java.awt.Dimension(80, 40));
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addUserButton);

        updateUserButton.setText("Update");
        updateUserButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateUserButton.setPreferredSize(new java.awt.Dimension(80, 40));
        updateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateUserButton);

        deleteUserButton.setText("Delete");
        deleteUserButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteUserButton.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteUserButton);

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            UserInfo u = getBeanFromRow(row);
            if (u != null) {
                UserUpdateDialog userUserUpdateDialog = new UserUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, u);
                userUserUpdateDialog.setItemUpdatedListener((UserInfo user) -> {
                    updateUserData(user, row);
                });
                userUserUpdateDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_updateUserButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        UserInsertDialog userInsertDialog = new UserInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        userInsertDialog.setItemAddedListener((UserInfo user) -> {
            appendUserData(user);
        });

        userInsertDialog.setVisible(true);
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    @Override
    public final void loadTableData() {
        SwingUtilities.invokeLater(() -> {
            if (userList == null || userList.isEmpty()) {
                Logy.d("Loading user from file for first Time");
                try {
                    userList = UserBLL.getAllUser();
                } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                    return;
                }

            } else {
                Logy.d("user already loaded");
            }
            this.fillTableData(userList);
        });
    }

    @Override
    public final void fillTableData(List<UserInfo> list) {
        userList.stream().forEach((user) -> {
            addUserRowData(user);
        });
    }

    public void addUserRowData(UserInfo user) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            user.getId(),
            user.getName(),
            user.getUsername(),
            user.getPassword(),
            user.getRole().getTitle()
        });
    }

    private void appendUserData(UserInfo user) {
        userList.add(user);
        addUserRowData(user);
    }

    private void updateUserData(UserInfo s, int row) {
        for (UserInfo user : userList) {
            if (user.getId() == user.getId()) {
                user.setName(user.getName());
                user.setPassword(user.getPassword());
                break;
            }
        }

        updateUserInfoRowData(s, row);
    }

    private void updateUserInfoRowData(UserInfo user, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(user.getName(), row, 1);
        ((DefaultTableModel) table.getModel()).setValueAt(user.getPassword(), row, 3);
    }

    private UserInfo getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return userList.stream()
                .filter((user) -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton updateUserButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the userListener
     */
    public UserListener getUserListener() {
        return userListener;
    }

    /**
     * @param userListener the userListener to set
     */
    public void setUserListener(UserListener userListener) {
        this.userListener = userListener;
    }

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
        this.deleteUserButton.setVisible(false);
    }

}
