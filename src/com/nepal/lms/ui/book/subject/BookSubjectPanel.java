/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.book.subject;

import com.nepal.lms.action.SubjectListener;
import com.nepal.lms.bll.SubjectBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.subject.Subject;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.ui.BaseUserPanel;
import com.nepal.lms.util.Logy;
import com.nepal.lms.util.Utils;
import com.nepal.lms.view.BookView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suzn
 */
public final class BookSubjectPanel extends BaseUserPanel implements BookView<Subject>, SubjectListener {

    private List<Subject> subjectList;

    /**
     * Creates new form BookSubjectPanel
     *
     * @param userInfo
     */
    public BookSubjectPanel(UserInfo userInfo) {
        initComponents();
        setupUserView(userInfo);
        subjectList = new ArrayList<>();
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
        addBookButton = new javax.swing.JButton();
        updateBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

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

        tableModel.addColumn(com.nepal.lms.entity.subject.SubjectParams.ID.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.subject.SubjectParams.TITLE.toUpperCase());
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
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        addBookButton.setText("Add New");
        addBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBookButton.setPreferredSize(new java.awt.Dimension(80, 40));
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addBookButton);

        updateBookButton.setText("Update");
        updateBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBookButton.setPreferredSize(new java.awt.Dimension(80, 40));
        updateBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateBookButton);

        deleteBookButton.setText("Delete");
        deleteBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBookButton.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteBookButton);

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        BookSubjectInsertDialog bookSubjectInsertDialog = new BookSubjectInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookSubjectInsertDialog.setItemAddedListener((Subject subject) -> {
            appendSubjectData(subject);
        });
        bookSubjectInsertDialog.setVisible(true);

    }//GEN-LAST:event_addBookButtonActionPerformed

    private void updateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            Subject s = getBeanFromRow(row);
            if (s != null) {
                BookSubjectUpdateDialog bookSubjectUpdateDialog = new BookSubjectUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, s);
                bookSubjectUpdateDialog.setItemUpdatListener((Subject subject) -> {
                    updateSubjectData(subject, row);
                });
                bookSubjectUpdateDialog.setVisible(true);
            }
        }

    }//GEN-LAST:event_updateBookButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        if (Utils.isTableRowSelected(table)) {
            if (Alert.showDeleteConfirmDialog(this) == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                int id = Utils.getIdFromTable(table, row);
                try {
                    Subject subject = new Subject();
                    subject.setId(id);
                    SubjectBLL.deleteSubject(subject);
                    removeSubjectData(subject, row);
                } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    public void addSubjectRowData(Subject subject) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            subject.getId(),
            subject.getTitle()
        });
    }

    @Override
    public final void loadTableData() {

        if (subjectList == null || subjectList.isEmpty()) {
            Logy.d("Loading subject from file for first Time");
            try {
                subjectList = SubjectBLL.getAllSubject();
            } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        } else {
            Logy.d("subject already loaded");
        }
        this.fillTableData(subjectList);

    }

    @Override
    public final void fillTableData(List<Subject> subjectInfoList) {
        subjectInfoList.stream().forEach((subjectInfo) -> {
            addSubjectRowData(subjectInfo);
        });

    }

    private void updateSubjectData(Subject s, int row) {
        for (Subject subject : subjectList) {
            if (subject.getId() == subject.getId()) {
                subject.setTitle(subject.getTitle());
                break;
            }
        }

        updateSubjectRowData(s, row);
    }

    private void updateSubjectRowData(Subject subject, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(subject.getTitle(), row, 1);
    }

    private Subject getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return subjectList.stream()
                .filter((subject) -> subject.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBookButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSubjectDataChanged(Subject s) {
        appendSubjectData(s);
    }

    private void appendSubjectData(Subject s) {
        subjectList.add(s);
        addSubjectRowData(s);
    }

    @Override
    protected void setupAdminView() {

    }

    @Override
    protected void setupLibrarianView() {
        this.deleteBookButton.setVisible(false);
    }

    @Override
    public void onSubectDataRemoved(Subject s) {
        for (Subject auth : subjectList) {
            if (auth.getId() == s.getId()) {
                subjectList.remove(auth);
                break;
            }
        }

    }

    private void removeSubjectData(Subject a, int row) {
        onSubectDataRemoved(a);
        ((DefaultTableModel) table.getModel()).removeRow(row);
    }
}
