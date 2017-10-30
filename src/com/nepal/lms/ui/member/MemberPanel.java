/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.member;

import com.nepal.lms.action.MemberListener;
import com.nepal.lms.bll.MemberBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.member.MemberInfo;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.ui.BaseUserPanel;
import com.nepal.lms.util.Logy;
import com.nepal.lms.util.Utils;
import com.nepal.lms.view.MemberView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @member Suzn
 */
public final class MemberPanel extends BaseUserPanel implements MemberView {

    private List<MemberInfo> memberList;
    private MemberListener memberListener;
    private final UserInfo userInfo;

    /**
     * Creates new form LibrarianBookPanel
     *
     * @param userInfo
     */
    public MemberPanel(UserInfo userInfo) {
        initComponents();
        this.userInfo = userInfo;
        memberList = new ArrayList<>();

        Logy.d("Librarian member panel initialized");
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
        addMemberButton = new javax.swing.JButton();
        updateMemberButton = new javax.swing.JButton();
        deleteMemberButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(249, 249, 249));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(367, 80));
        topPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(120, 60));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("Member");

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

        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.ID.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.NAME.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.ADDRESS.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.CONTACT.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.JOINED_DATE.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.member.MemberParams.EXPIRY_DATE.toUpperCase());
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

        addMemberButton.setText("Add New");
        addMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addMemberButton);

        updateMemberButton.setText("Update");
        updateMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        updateMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateMemberButton);

        deleteMemberButton.setText("Delete");
        deleteMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteMemberButton);

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMemberButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            MemberInfo b = getBeanFromRow(row);
            if (b != null) {
                MemberUpdateDialog memberMemberUpdateDialog = new MemberUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, b);
                memberMemberUpdateDialog.setItemUpdatedListener((MemberInfo memberInfo) -> {
                    updateMemberData(memberInfo, row);
                });
                memberMemberUpdateDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_updateMemberButtonActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        MemberInsertDialog memberInsertDialog = new MemberInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        memberInsertDialog.setItemAddedListener((MemberInfo memberInfo) -> {
            appendMemberData(memberInfo);
        });

        memberInsertDialog.setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void deleteMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMemberButtonActionPerformed

    @Override
    public final void loadTableData() {
        SwingUtilities.invokeLater(() -> {
            if (memberList == null || memberList.isEmpty()) {
                Logy.d("Loading member from file for first Time");
                try {
                    memberList = MemberBLL.getAllMember();
                } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                    return;
                }

            } else {
                Logy.d("member already loaded");
            }
            this.fillTableData(memberList);
        });
    }

    @Override
    public final void fillTableData(List<MemberInfo> list) {
        memberList.stream().forEach((memberInfo) -> {
            addMemberRowData(memberInfo);
        });
    }

    public void addMemberRowData(MemberInfo member) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            member.getId(),
            member.getName(),
            member.getAddress().getTemporary(),
            member.getContact(),
            Utils.millisToSql(member.getJoinedDate()),
            Utils.millisToSql(member.getExpiryDate())
        });
    }

    private void appendMemberData(MemberInfo member) {
        memberList.add(member);
        addMemberRowData(member);
    }

    private void updateMemberData(MemberInfo s, int row) {
        for (MemberInfo member : memberList) {
            if (member.getId() == member.getId()) {
                member.setName(member.getName());
                member.setAddress(member.getAddress());
                member.setContact(member.getContact());
                member.setExpiryDate(member.getExpiryDate());
                break;
            }
        }

        updateMemberInfoRowData(s, row);
    }

    private void updateMemberInfoRowData(MemberInfo member, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(member.getName(), row, 1);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getAddress().getTemporary(), row, 2);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getContact(), row, 3);
        ((DefaultTableModel) table.getModel()).setValueAt(Utils.millisToSql(member.getExpiryDate()), row, 5);
    }

    private MemberInfo getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return memberList.stream()
                .filter((member) -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteMemberButton;
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
    private javax.swing.JButton updateMemberButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the memberListener
     */
    public MemberListener getMemberListener() {
        return memberListener;
    }

    /**
     * @param memberListener the memberListener to set
     */
    public void setMemberListener(MemberListener memberListener) {
        this.memberListener = memberListener;
    }

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
        this.deleteMemberButton.setVisible(false);
    }

}
