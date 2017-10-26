/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.book;

import com.nepal.lms.bll.BookBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.util.Logy;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suzn
 */
public class BookStockPanel extends javax.swing.JPanel {

    private List<BookInfo> bookList;

    /**
     * Creates new form BookStockPanel
     */
    public BookStockPanel() {
        initComponents();
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
        updateBookButton = new javax.swing.JButton();
        addBookButton = new javax.swing.JButton();
        borrowBookButton = new javax.swing.JButton();
        returnBookButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

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

        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.TITLE.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.SUBJECT.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.AUTHOR.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.PUBLISHER.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.EDITION.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.ISBN.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.NUMBER_OF_COPY.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.AVAILABLE_COPIES.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.book.BookParams.SHELF_NO.toUpperCase());
        tableModel.addColumn("Available".toUpperCase());
        table.setModel(tableModel);
        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> rowSorter = new javax.swing.table.TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        table.setRowHeight(26);
        table.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(table);

        centerSubPanel.add(jScrollPane1, "card2");

        jPanel4.add(centerSubPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jPanel3.setOpaque(false);

        updateBookButton.setText("Update");
        updateBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookButtonActionPerformed(evt);
            }
        });

        addBookButton.setText("Add New");
        addBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        borrowBookButton.setText("Borrow");
        borrowBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 51, 0)));
        borrowBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookButtonActionPerformed(evt);
            }
        });

        returnBookButton.setText("Return");
        returnBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 51, 0)));
        returnBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(borrowBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrowBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void borrowBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowBookButtonActionPerformed

    private void returnBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnBookButtonActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void updateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBookButtonActionPerformed

    private void loadTableData() {

        if (bookList == null || bookList.isEmpty()) {
            Logy.d("Loading book from file for first Time");
            try {
                bookList = BookBLL.getAllBook();
            } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        } else {
            Logy.d("book already loaded");
        }
        this.fillTableData(bookList);

    }

    private void fillTableData(List<BookInfo> bookInfoList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        int numOfColumn = defaultTableModel.getColumnCount();

        bookInfoList.stream().forEach((bookInfo) -> {
            Object[] object;
            object = new Object[numOfColumn + 1]; //+1 for id
            object[0] = bookInfo.getTitle();
            object[1] = bookInfo.getSubject().getTitle();
            object[2] = bookInfo.getAuthor().getTitle();
            object[3] = bookInfo.getPublisher().getTitle();
            object[4] = bookInfo.getEdition();
            object[5] = bookInfo.getIsbn();
            object[6] = bookInfo.getNumberOfCopy();
            object[7] = bookInfo.getAvailableCopies();
            object[8] = bookInfo.getShelfNo().getLocation();
            object[9] = bookInfo.getAvailableCopies() > 0;
            object[10] = bookInfo.getId();

            defaultTableModel.addRow(object);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton borrowBookButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton returnBookButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBookButton;
    // End of variables declaration//GEN-END:variables
}
