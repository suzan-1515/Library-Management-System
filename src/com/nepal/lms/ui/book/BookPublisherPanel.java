/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.book;

import com.nepal.lms.bll.PublisherBLL;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.publisher.Publisher;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.util.Logy;
import com.nepal.lms.view.BookView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @publisher Suzn
 */
public class BookPublisherPanel extends javax.swing.JPanel implements BookView<Publisher> {

    private List<Publisher> publisherList;

    /**
     * Creates new form BookPublisherPanel
     */
    public BookPublisherPanel() {
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
        updatePublisherButton = new javax.swing.JButton();
        addPublisherButton = new javax.swing.JButton();

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

        tableModel.addColumn(com.nepal.lms.entity.publisher.PublisherParams.ID.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.publisher.PublisherParams.TITLE.toUpperCase());
        tableModel.addColumn(com.nepal.lms.entity.publisher.PublisherParams.CONTACT.toUpperCase());
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

        updatePublisherButton.setText("Update");
        updatePublisherButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatePublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePublisherButtonActionPerformed(evt);
            }
        });

        addPublisherButton.setText("Add New");
        addPublisherButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addPublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(addPublisherButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatePublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addPublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPublisherButtonActionPerformed

    private void updatePublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePublisherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePublisherButtonActionPerformed

    @Override
    public final void loadTableData() {

        if (publisherList == null || publisherList.isEmpty()) {
            Logy.d("Loading publisher from file for first Time");
            try {
                publisherList = PublisherBLL.getAllPublisher();
            } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        } else {
            Logy.d("publisher already loaded");
        }

        this.fillTableData(publisherList);
    }

    /**
     *
     * @param publisherInfoList
     */
    @Override
    public final void fillTableData(List<Publisher> publisherInfoList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        int numOfColumn = defaultTableModel.getColumnCount();

        publisherInfoList.stream().forEach((publisherInfo) -> {
            Object[] object;
            object = new Object[numOfColumn];
            object[0] = publisherInfo.getId();
            object[1] = publisherInfo.getTitle();
            object[2] = publisherInfo.getContact();

            defaultTableModel.addRow(object);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPublisherButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JButton updatePublisherButton;
    // End of variables declaration//GEN-END:variables
}
