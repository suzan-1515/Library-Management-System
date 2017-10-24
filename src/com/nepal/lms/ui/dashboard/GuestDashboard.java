/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.dashboard;

import com.nepal.lms.bll.BookBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.book.BookParams;
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
public class GuestDashboard extends javax.swing.JFrame {

    private List<BookInfo> bookList;

    /**
     * Creates new form GuestDashboard
     */
    public GuestDashboard() {
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

        rootPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        toolbarPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchControlPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library");
        setMinimumSize(new java.awt.Dimension(680, 460));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        rootPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(39, 26, 252));
        topPanel.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        titlePanel.setBackground(new java.awt.Color(39, 26, 252));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Library");
        titlePanel.add(jLabel2);

        topPanel.add(titlePanel);

        controlPanel.setLayout(new java.awt.GridLayout());

        toolbarPanel.setPreferredSize(new java.awt.Dimension(349, 74));
        toolbarPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.gif"))); // NOI18N
        loginButton.setMinimumSize(new java.awt.Dimension(64, 64));
        loginButton.setPreferredSize(new java.awt.Dimension(64, 64));
        toolbarPanel.add(loginButton);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit5.gif"))); // NOI18N
        exitButton.setMinimumSize(new java.awt.Dimension(64, 64));
        exitButton.setPreferredSize(new java.awt.Dimension(64, 64));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        toolbarPanel.add(exitButton);

        controlPanel.add(toolbarPanel);

        searchPanel.setPreferredSize(new java.awt.Dimension(349, 74));

        jLabel3.setText("Search:");

        searchTextField.setMinimumSize(new java.awt.Dimension(200, 15));
        searchTextField.setPreferredSize(new java.awt.Dimension(200, 15));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.gif"))); // NOI18N
        searchButton.setMinimumSize(new java.awt.Dimension(48, 32));
        searchButton.setPreferredSize(new java.awt.Dimension(48, 32));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchControlPanelLayout = new javax.swing.GroupLayout(searchControlPanel);
        searchControlPanel.setLayout(searchControlPanelLayout);
        searchControlPanelLayout.setHorizontalGroup(
            searchControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchControlPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchControlPanelLayout.setVerticalGroup(
            searchControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchControlPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(searchControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        searchPanel.add(searchControlPanel);

        controlPanel.add(searchPanel);

        topPanel.add(controlPanel);

        rootPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setLayout(new java.awt.CardLayout(5, 5));

        table.setAutoCreateRowSorter(true);
        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        tableModel.addColumn(BookParams.TITLE.toUpperCase());
        tableModel.addColumn(BookParams.SUBJECT.toUpperCase());
        tableModel.addColumn(BookParams.AUTHOR.toUpperCase());
        tableModel.addColumn(BookParams.PUBLISHER.toUpperCase());
        tableModel.addColumn(BookParams.EDITION.toUpperCase());
        tableModel.addColumn(BookParams.ISBN.toUpperCase());
        tableModel.addColumn(BookParams.SHELF_NO.toUpperCase());
        tableModel.addColumn("Available".toUpperCase());
        table.setModel(tableModel);
        table.setRowHeight(24);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        centerPanel.add(jScrollPane1, "card2");

        rootPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel1.setText("Developed by: Sujan Parajuli");
        bottomPanel.add(jLabel1);

        rootPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(rootPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadTableData();
    }//GEN-LAST:event_formWindowOpened

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchData(searchTextField.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GuestDashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchControlPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel toolbarPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private void loadTableData() {

        if (bookList == null || bookList.isEmpty()) {

            try {
                bookList = BookBLL.getAllBook();
            } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        }
        this.fillTableData(bookList);

    }

    private void fillTableData(List<BookInfo> bookInfoList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        int numOfColumn = defaultTableModel.getColumnCount();

        bookInfoList.stream().forEach((bookInfo) -> {
            Object[] object;
            object = new Object[numOfColumn];
            object[0] = bookInfo.getTitle();
            object[1] = bookInfo.getSubject().getTitle();
            object[2] = bookInfo.getAuthor().getTitle();
            object[3] = bookInfo.getPublisher().getTitle();
            object[4] = bookInfo.getEdition();
            object[5] = bookInfo.getIsbn();
            object[6] = bookInfo.getShelfNo().getLocation();
            object[7] = bookInfo.getAvailableCopies() > 0;

            defaultTableModel.addRow(object);
        });

    }

    private void searchData(String text) {
        
    }
}
