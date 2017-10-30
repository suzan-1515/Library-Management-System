/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.report;

import com.nepal.lms.access.UserAccess;
import com.nepal.lms.bll.BookBLL;
import com.nepal.lms.bll.MemberBLL;
import com.nepal.lms.bll.UserBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.member.MemberInfo;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.util.Logy;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Suzn
 */
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form LibrarianBookPanel
     *
     * @param userInfo
     */
    public ReportPanel(UserInfo userInfo) {
        initComponents();
        prepareReport();
        Logy.d("Report panel initialized");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totalBook = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        availableBook = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        borrowedBook = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        totalMember = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        totalUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totlaLibrarian = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalAdmin = new javax.swing.JTextField();
        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        centerPanel.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 10, 5));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total Book");
        jPanel2.add(jLabel2);

        totalBook.setEditable(false);
        totalBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalBook.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalBook.setText("0");
        totalBook.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel2.add(totalBook);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Available Book");
        jPanel2.add(jLabel3);

        availableBook.setEditable(false);
        availableBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        availableBook.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        availableBook.setText("0");
        availableBook.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel2.add(availableBook);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Borrowed");
        jPanel2.add(jLabel4);

        borrowedBook.setEditable(false);
        borrowedBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        borrowedBook.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        borrowedBook.setText("0");
        borrowedBook.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel2.add(borrowedBook);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Total Member");
        jPanel4.add(jLabel7);

        totalMember.setEditable(false);
        totalMember.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalMember.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalMember.setText("0");
        totalMember.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel4.add(totalMember);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(3, 2, 10, 5));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total User");
        jPanel5.add(jLabel8);

        totalUser.setEditable(false);
        totalUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalUser.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalUser.setText("0");
        totalUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel5.add(totalUser);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Total Librarian");
        jPanel5.add(jLabel9);

        totlaLibrarian.setEditable(false);
        totlaLibrarian.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totlaLibrarian.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totlaLibrarian.setText("0");
        totlaLibrarian.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel5.add(totlaLibrarian);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total Admin");
        jPanel5.add(jLabel10);

        totalAdmin.setEditable(false);
        totalAdmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalAdmin.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalAdmin.setText("0");
        totalAdmin.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel5.add(totalAdmin);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel4, jPanel5});

        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel4, jPanel5});

        add(centerPanel, java.awt.BorderLayout.CENTER);

        topPanel.setBackground(new java.awt.Color(249, 249, 249));
        topPanel.setPreferredSize(new java.awt.Dimension(367, 80));
        topPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(120, 60));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("Report");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(29, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availableBook;
    private javax.swing.JTextField borrowedBook;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField totalAdmin;
    private javax.swing.JTextField totalBook;
    private javax.swing.JTextField totalMember;
    private javax.swing.JTextField totalUser;
    private javax.swing.JTextField totlaLibrarian;
    // End of variables declaration//GEN-END:variables

    private void prepareReport() {
        try {
            List<BookInfo> allBook = BookBLL.getAllBook();
            List<MemberInfo> allMember = MemberBLL.getAllMember();
            List<UserInfo> allUser = UserBLL.getAllUser();

            totalBook.setText(String.valueOf(
                    allBook.parallelStream()
                            .mapToInt(book -> book.getNumberOfCopy())
                            .sum()
            ));
            availableBook.setText(
                    String.valueOf(
                            allBook.stream()
                                    .filter(book -> book.getAvailableCopies() > 0)
                                    .mapToInt(book -> book.getAvailableCopies())
                                    .sum()
                    )
            );

            allBook = allBook.parallelStream()
                    .filter(book -> book.getAvailableCopies() != book.getNumberOfCopy())
                    .collect(Collectors.toList());
            int totalCopy = allBook.parallelStream()
                    .mapToInt(b -> b.getNumberOfCopy())
                    .sum();
            int totalAvai = allBook.parallelStream()
                    .mapToInt(b -> b.getAvailableCopies())
                    .sum();
            borrowedBook.setText(String.valueOf(totalCopy - totalAvai));

            totalMember.setText(String.valueOf(allMember.size()));

            totalUser.setText(String.valueOf(allUser.size()));

            totlaLibrarian.setText(String.valueOf(
                    allUser.parallelStream()
                            .filter(usr -> usr.getRole().getId() == UserAccess.LIBRARIAN)
                            .count()
            ));

            totalAdmin.setText(String.valueOf(
                    allUser.parallelStream()
                            .filter(usr -> usr.getRole().getId() == UserAccess.ADMIN)
                            .count()
            ));

        } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
            Logy.e(ex);
            Alert.showError(this, ex.getMessage());
        }
    }

}
