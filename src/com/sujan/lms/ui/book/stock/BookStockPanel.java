/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.ui.book.stock;

import com.sujan.lms.action.AuthorListener;
import com.sujan.lms.action.PublisherListener;
import com.sujan.lms.action.ReturnListener;
import com.sujan.lms.action.ShelfListener;
import com.sujan.lms.action.SubjectListener;
import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.custom.Alert;
import com.sujan.lms.entity.book.BookInfo;
import com.sujan.lms.entity.user.UserInfo;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.ui.BaseUserPanel;
import com.sujan.lms.ui.book.borrow.BookBorrowInsertDialog;
import com.sujan.lms.util.Logy;
import com.sujan.lms.util.Utils;
import com.sujan.lms.view.BookView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.sujan.lms.action.TransactionListener;
import com.sujan.lms.entity.transaction.Transaction;

/**
 *
 * @author Suzn
 */
public final class BookStockPanel extends BaseUserPanel implements BookView<BookInfo>,
        TransactionListener {

    private List<BookInfo> bookList;
    private SubjectListener subjectListener;
    private AuthorListener authorListener;
    private PublisherListener publisherListener;
    private ShelfListener shelfListener;
    private TransactionListener borrowListener;
    private ReturnListener returnListener;
    private final UserInfo userInfo;

    /**
     * Creates new form BookStockPanel
     *
     * @param userInfo
     */
    public BookStockPanel(UserInfo userInfo) {
        initComponents();
        this.userInfo = userInfo;
        setupUserView(userInfo);
        bookList = new ArrayList<>();
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
        borrowBookButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
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

        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.ACCESSION_NO.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.TITLE.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.SUBJECT.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.AUTHOR.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.PUBLISHER.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.EDITION.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.ISBN.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.NUMBER_OF_COPY.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.AVAILABLE_COPIES.toUpperCase());
        tableModel.addColumn(com.sujan.lms.entity.book.BookParams.SHELF_NO.toUpperCase());
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

        borrowBookButton.setText("Borrow");
        borrowBookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 51, 0)));
        borrowBookButton.setPreferredSize(new java.awt.Dimension(80, 40));
        borrowBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookButtonActionPerformed(evt);
            }
        });
        jPanel3.add(borrowBookButton);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(2, 40));
        jPanel3.add(jSeparator1);

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

    private void borrowBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookButtonActionPerformed
        int row = table.getSelectedRow();
        if (row < 0) {
            return;
        }
        row = (int) table.getModel().getValueAt(table.getRowSorter().convertRowIndexToModel(row), 0);
        BookBorrowInsertDialog bookBorrowInsertDialog = new BookBorrowInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, userInfo);
        bookBorrowInsertDialog.setBookId(row);
        bookBorrowInsertDialog.setItemAddedListener((Transaction t) -> {
            appendBorrowData(t);
        });
        bookBorrowInsertDialog.setVisible(true);
    }//GEN-LAST:event_borrowBookButtonActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        BookStockInsertDialog bookStockInsertDialog = new BookStockInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookStockInsertDialog.setItemAddedListener((BookInfo bookInfo) -> {
            appendBookData(bookInfo);
        });
        bookStockInsertDialog.setSubjectListener(subjectListener);
        bookStockInsertDialog.setAuthorListener(authorListener);
        bookStockInsertDialog.setPublisherListener(publisherListener);
        bookStockInsertDialog.setShelfListener(shelfListener);
        bookStockInsertDialog.setVisible(true);
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void updateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            BookInfo b = getBeanFromRow(table.getRowSorter().convertRowIndexToModel(row));
            if (b != null) {
                BookStockUpdateDialog bookStockUpdateDialog = new BookStockUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, b);
                bookStockUpdateDialog.setItemUpdatListener((BookInfo bookInfo) -> {
                    updateBookData(bookInfo, row);
                });
                bookStockUpdateDialog.setSubjectListener(subjectListener);
                bookStockUpdateDialog.setAuthorListener(authorListener);
                bookStockUpdateDialog.setPublisherListener(publisherListener);
                bookStockUpdateDialog.setShelfListener(shelfListener);
                bookStockUpdateDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_updateBookButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        if (Utils.isTableRowSelected(table)) {
            if (Alert.showDeleteConfirmDialog(this) == JOptionPane.YES_OPTION) {
                int row = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
                int id = Utils.getIdFromTable(table, row);
                try {
                    BookInfo book = new BookInfo(id);
                    BookBLL.deleteBook(book);
                    removeBookData(book, row);
                } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    @Override
    public final void loadTableData() {
        SwingUtilities.invokeLater(() -> {
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
        });

    }

    @Override
    public final void fillTableData(List<BookInfo> bookInfoList) {

        bookInfoList.stream().forEach((bookInfo) -> {
            addBookRowData(bookInfo);
        });

    }

    private void appendBookData(BookInfo b) {
        bookList.add(b);
        addBookRowData(b);
    }

    public void addBookRowData(BookInfo bookInfo) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            bookInfo.getId(),
            bookInfo.getTitle(),
            bookInfo.getSubject().getTitle(),
            bookInfo.getAuthor().getTitle(),
            bookInfo.getPublisher().getTitle(),
            bookInfo.getEdition(),
            bookInfo.getIsbn(),
            bookInfo.getNumberOfCopy(),
            bookInfo.getAvailableCopies(),
            bookInfo.getShelfNo().getLocation(),
            bookInfo.getAvailableCopies() > 0
        });
    }

    private void updateBookData(BookInfo bookInfo, int row) {
        for (BookInfo book : bookList) {
            if (book.getId() == bookInfo.getId()) {
                book.setTitle(bookInfo.getTitle());
                book.setSubject(bookInfo.getSubject());
                book.setPublisher(bookInfo.getPublisher());
                book.setAuthor(bookInfo.getAuthor());
                book.setEdition(bookInfo.getEdition());
                book.setNumberOfCopy(bookInfo.getNumberOfCopy());
                book.setAvailableCopies(bookInfo.getAvailableCopies());
                book.setIsbn(bookInfo.getIsbn());
                book.setShelfNo(bookInfo.getShelfNo());
                break;
            }
        }

        updateBookRowData(bookInfo, row);
    }

    private void updateBookRowData(BookInfo bookInfo, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getTitle(), row, 1);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getSubject().getTitle(), row, 2);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getAuthor().getTitle(), row, 3);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getPublisher().getTitle(), row, 4);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getEdition(), row, 5);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getIsbn(), row, 6);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getNumberOfCopy(), row, 7);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getAvailableCopies(), row, 8);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getShelfNo().getLocation(), row, 9);
        ((DefaultTableModel) table.getModel()).setValueAt(bookInfo.getAvailableCopies() > 0, row, 10);
    }

    private void updateBookRowData(BookInfo bookInfo) {

        DefaultTableModel dm = ((DefaultTableModel) table.getModel());

        for (int row = 0; row < table.getRowCount(); row++) {
            int id = (int) dm.getValueAt(row, 0);
            if (id == bookInfo.getId()) {
                dm.setValueAt(bookInfo.getAvailableCopies(), row, 8);
                dm.setValueAt(bookInfo.getAvailableCopies() > 0, row, 10);
                break;
            }
        }
    }

    @Override
    public void onBookBorrowed(Transaction transaction) {
        updateBookTransaction(transaction, true);
    }

    @Override
    public void onBookReturned(Transaction transaction) {
        updateBookTransaction(transaction, false);
    }

    private void updateBookTransaction(Transaction transaction, boolean operation) {

        BookInfo updatedBookInfo = null;

        for (BookInfo book : bookList) {
            if (book.getId() == transaction.getBook().getId()) {
                book.setAvailableCopies(operation ? (book.getAvailableCopies() - 1) : (book.getAvailableCopies() + 1));
                updatedBookInfo = book;
                break;
            }
        }

        if (updatedBookInfo != null) {
            try {
                BookBLL.updateBook(updatedBookInfo);
                updateBookRowData(updatedBookInfo);
            } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                Logy.e(ex);
                Alert.showError(this, "Error updating book borrow details");
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton borrowBookButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBookButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the subjectListener
     */
    public SubjectListener getSubjectListener() {
        return subjectListener;
    }

    /**
     * @param subjectListener the subjectListener to set
     */
    public void setSubjectListener(SubjectListener subjectListener) {
        this.subjectListener = subjectListener;
    }

    /**
     * @return the authorListener
     */
    public AuthorListener getAuthorListener() {
        return authorListener;
    }

    /**
     * @param authorListener the authorListener to set
     */
    public void setAuthorListener(AuthorListener authorListener) {
        this.authorListener = authorListener;
    }

    /**
     * @return the publisherListener
     */
    public PublisherListener getPublisherListener() {
        return publisherListener;
    }

    /**
     * @param publisherListener the publisherListener to set
     */
    public void setPublisherListener(PublisherListener publisherListener) {
        this.publisherListener = publisherListener;
    }

    /**
     * @return the shelfListener
     */
    public ShelfListener getShelfListener() {
        return shelfListener;
    }

    /**
     * @param shelfListener the shelfListener to set
     */
    public void setShelfListener(ShelfListener shelfListener) {
        this.shelfListener = shelfListener;
    }

    private BookInfo getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return bookList.stream()
                .filter((book) -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void setupAdminView() {

    }

    @Override
    protected void setupLibrarianView() {
        this.deleteBookButton.setVisible(false);
    }

    /**
     * @return the borrowListener
     */
    public TransactionListener getBorrowListener() {
        return borrowListener;
    }

    /**
     * @param borrowListener the borrowListener to set
     */
    public void setBorrowListener(TransactionListener borrowListener) {
        this.borrowListener = borrowListener;
    }

    /**
     * @return the returnListener
     */
    public ReturnListener getReturnListener() {
        return returnListener;
    }

    /**
     * @param returnListener the returnListener to set
     */
    public void setReturnListener(ReturnListener returnListener) {
        this.returnListener = returnListener;
    }

    private void removeBookData(BookInfo a, int row) {
        for (BookInfo book : bookList) {
            if (book.getId() == a.getId()) {
                bookList.remove(book);
                break;
            }
        }

        ((DefaultTableModel) table.getModel()).removeRow(row);
    }

    private void appendBorrowData(Transaction transaction) {
        onBookBorrowed(transaction);
        if (borrowListener != null) {
            borrowListener.onBookBorrowed(transaction);
        }
    }

}